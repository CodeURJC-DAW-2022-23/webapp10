package com.nutri.backend.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.nutri.backend.model.Recepy;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/PDF")
public class PDFController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ServletContext servletContext;

    @Autowired
    private RecepyRepository recepyRepository;

    private final TemplateEngine templateEngine;

    public PDFController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @PostMapping("/")
    public String getRecipePage(Model model, @RequestParam(required = false) List<Long> id) {
        if (id != null) {
            for (Long l : id) {
                Optional<Recepy> recipe = recepyRepository.findById(l);
                model.addAttribute("recipeEntry", recipe);
            }
        } else {
            return "redirect:/viewRecipe";
        }
        return "recipe";
    }
    @GetMapping("/recepy/image/{id}")
    public ResponseEntity<InputStreamResource> downloadUserAvatarImage(@PathVariable Long id) throws SQLException {
        Optional<Recepy> recepy = recepyRepository.findById(id);
        if (!recepy.get().getImage().isEmpty()){
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Content-Disposition",
                    "inline;filename=\"" + recepy.get().getImage()+ "\"");
            System.out.println(responseHeaders.toString());
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .contentLength(recepy.get().getImageFile().length())
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(recepy.get().getImageFile().getBinaryStream()));
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/downloadRecepy")
    public Object getRecepyPDF(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) List<Long> id) throws IOException, SQLException {
        String name = request.getUserPrincipal().getName();
        User user = userRepository.findByEmail(name).orElseThrow();
        if (id != null) {
            Optional<Recepy> recipe;
            for (Long l : id) {
                recipe = recepyRepository.findById(l);
                String recipeType = recipe.get().getKindOfRecepy();
                if (recipeType.equals("Breakfast")){
                    int bCounter = user.getbCounter();
                    bCounter++;
                    user.setbCounter(bCounter);
                } else if (recipeType.equals("Lunch")) {
                    int lCounter = user.getbCounter();
                    lCounter++;
                    user.setbCounter(lCounter);
                } else if (recipeType.equals("Dinner")) {
                    int dCounter = user.getbCounter();
                    dCounter++;
                    user.setbCounter(dCounter);
                }
            }
            userRepository.save(user);
        }

        /* Do Business Logic*/

            if (id != null) {
                //Recepy[] recipes = new Recepy[id.size()];
                //int i = 0;
                Optional<Recepy> recipe = Optional.empty();
                for (Long l : id) {
                    recipe = recepyRepository.findById(l);
                    //recipes[i] = recepyRepository.findById(l).get();
                    //i++;
                }
                /* Create HTML using Thymeleaf template Engine */

            WebContext context = new WebContext(request, response, servletContext);
            String nameRecepy = recipe.get().getName();
            String ingredients = recipe.get().getIngredients();
            String description = recipe.get().getDescription();
            Long idRecipe = recipe.get().getId();
            context.setVariable("name", nameRecepy);
            context.setVariable("ingredients", ingredients);
            context.setVariable("description", description);
            context.setVariable("id", idRecipe);
            String recipeHtml = templateEngine.process("USR_ClientRecipePDF", context);
            /* Setup Source and target I/O streams */

            ByteArrayOutputStream target = new ByteArrayOutputStream();
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setBaseUri("http://localhost:3306");
            /* Call convert method */
            HtmlConverter.convertToPdf(recipeHtml, target, converterProperties);

            /* extract output as bytes */
            byte[] bytes = target.toByteArray();


            /* Send the response as downloadable PDF */
            String recipeName="recipe "+nameRecepy+".pdf";
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= "+recipeName)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(bytes);

        }
        return "redirect:/viewRecipe";
    }

}
