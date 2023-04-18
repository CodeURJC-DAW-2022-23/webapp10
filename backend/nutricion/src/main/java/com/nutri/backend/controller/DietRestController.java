package com.nutri.backend.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Recepy;
import com.nutri.backend.model.Triplet;
import com.nutri.backend.model.User;
import com.nutri.backend.service.DietService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.security.Principal;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/diets")
public class DietRestController {
    @Autowired
    private DietService dietService;

    @Operation(summary = "Get Diets in app")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found diets",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Diet.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @JsonView(Diet.DietBasic.class)
    @GetMapping("")
    public ResponseEntity<List<Diet>> getDiets() {
        return new ResponseEntity<>(dietService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Post Diet")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            )
    })
    @JsonView(Diet.DietBasic.class)
    @PostMapping("/")
    public ResponseEntity<Diet> postDiet(@RequestBody Diet diet) {
        try{
            Diet dietNew=new Diet();
            dietNew.setName(diet.getName());
            dietNew.setDietRefactoredAPI(diet.getDietRefactored());
            dietNew.setWeek(diet.getWeek());
            dietNew.setType(diet.getType());
            dietService.save(dietNew);
            URI location = fromCurrentRequest().path("diets/{id}")
                    .buildAndExpand(diet.getId()).toUri();
            return ResponseEntity.created(location).body(diet);
        }catch (EmptyResultDataAccessException e){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    }

    @Operation(summary = "Delete Diet ")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Diet.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid ids supplied",
                    content = @Content
            )
    })
    @DeleteMapping("")
    public ResponseEntity<List<User>> deleteListOfWorkers(@RequestParam List<Long> ids) {
        if(ids != null) {
            for (Long l : ids) {
                if(dietService.findById(l).isPresent()) {
                    dietService.delete(l);
                }
            }
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
