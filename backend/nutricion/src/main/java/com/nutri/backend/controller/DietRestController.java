package com.nutri.backend.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.nutri.backend.model.Diet;
import com.nutri.backend.service.DietService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

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

}
