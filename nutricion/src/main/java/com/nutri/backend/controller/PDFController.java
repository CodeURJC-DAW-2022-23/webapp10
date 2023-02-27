package com.nutri.backend.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Recepy;
import com.nutri.backend.repositories.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import com.nutri.backend.repositories.RecepyRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/PDF")
public class PDFController {


    @Autowired
    ServletContext servletContext;

    @Autowired
    private RecepyRepository recepyRepository;

    @Autowired
    private DietRepository dietRepository;

    private final TemplateEngine templateEngine;

    public PDFController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @PostMapping("/")
    public String getRecipePage(Model model, @RequestParam(required = false) List<Long> id) {
        if(id != null) {
            for (Long l : id) {
                Optional<Recepy> recipe = recepyRepository.findById(l);
                model.addAttribute("recipeEntry", recipe);
            }
        }else{
            return "redirect:/viewRecipe";
        }
        return "recipe";
    }

    @PostMapping("/downloadRecepy")
    public Object getRecepyPDF(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) List<Long> id) throws IOException {

        /* Do Business Logic*/

        if(id != null) {
            //Recepy[] recipes = new Recepy[id.size()];
            int i = 0;
            Optional<Recepy> recipe = null;
            for (Long l : id) {
                recipe = recepyRepository.findById(l);
                //recipes[i] = recepyRepository.findById(l).get();
                i++;
            }
            /* Create HTML using Thymeleaf template Engine */

            WebContext context = new WebContext(request, response, servletContext);
            String name = recipe.get().getName();
            String ingredients = recipe.get().getIngredients();
            String description = recipe.get().getDescription();
            Blob image = recipe.get().getImageFile();

            context.setVariable("name", name);
            context.setVariable("ingredients", ingredients);
            context.setVariable("description", description);
            context.setVariable("image", image);
            String recipeHtml = templateEngine.process("USR_ClientRecipePDF", context);

            /* Setup Source and target I/O streams */

            ByteArrayOutputStream target = new ByteArrayOutputStream();
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setBaseUri("http://localhost:8080");
            /* Call convert method */
            HtmlConverter.convertToPdf(recipeHtml, target, converterProperties);

            /* extract output as bytes */
            byte[] bytes = target.toByteArray();


            /* Send the response as downloadable PDF */

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=recipe.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(bytes);

        }
        return "redirect:/viewRecipe";
    }

    @PostMapping("/downloadDiet")
    public Object getDietPDF(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) List<Long> id) throws IOException {

        /* Do Business Logic*/
        System.out.println(id);
        if(id != null) {
            int i = 0;
            Optional<Diet> diet = null;
            for (Long l : id) {
                diet = dietRepository.findById(l);
                i++;
            }
            /* Create HTML using Thymeleaf template Engine */

            WebContext context = new WebContext(request, response, servletContext);
            context.setVariable("diet", diet);
            //model.addAttribute("description", recipe.getDescription());
            String dietHtml = templateEngine.process("USR_ClientDietPDF", context);

            /* Setup Source and target I/O streams */

            ByteArrayOutputStream target = new ByteArrayOutputStream();
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setBaseUri("http://localhost:8080");
            /* Call convert method */
            HtmlConverter.convertToPdf(dietHtml, target, converterProperties);

            /* extract output as bytes */
            byte[] bytes = target.toByteArray();


            /* Send the response as downloadable PDF */

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=diet.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(bytes);

        }
        return "redirect:/viewDiet";
    }

}
