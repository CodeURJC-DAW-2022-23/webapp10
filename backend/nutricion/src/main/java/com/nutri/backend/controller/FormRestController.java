package com.nutri.backend.controller;

import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Form;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.service.DietService;
import com.nutri.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/forms")
public class FormRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private DietService dietService;

    //GET PERSONAL FORM
    @Operation(summary = "Get user logged in the application")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Form created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Form.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })

    @GetMapping("/me")
    public ResponseEntity<Form> getPersonalForm(HttpServletRequest request) {
        User user = userService.findByEmail(request.getUserPrincipal().getName()).orElseThrow();
        try {
            return new ResponseEntity<>(user.getForm(), HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //POST A FORM
    @Operation(summary = "Get user logged in the application")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Form created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Form.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })

    @PostMapping("/")
    public ResponseEntity<Form> createForm(@RequestBody Form form, HttpServletRequest request) {
        try {
            Principal principal = request.getUserPrincipal();
            formRepository.save(form);
            if (principal != null && request.isUserInRole("client")) {
                User user = userService.findByEmail(request.getUserPrincipal().getName()).orElseThrow();
                user.setForm(form);
                String dietType = dietService.dietAlgorithm(form);
                List<Optional<Diet>> diets = dietService.findAllDietsByType(dietType);
                Collections.shuffle(diets);
                user.setDiet(diets.get(0).orElseThrow());
                userService.save(user);
            }
            URI location = fromCurrentRequest().path("forms/{id}")
                    .buildAndExpand(form.getId()).toUri();
            return ResponseEntity.created(location).body(form);

        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
