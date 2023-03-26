package com.nutri.backend.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Recepy;
import com.nutri.backend.model.Triplet;
import com.nutri.backend.model.User;
import com.nutri.backend.service.RecepyService;
import com.nutri.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/recepies")
public class RecepyRestController {

    @Autowired
    private RecepyService recepyService;

    @Autowired
    private UserService userService;

    @Operation(summary = "Get recepies in app")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found recepies",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Recepy.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @JsonView(Recepy.RecepyBasic.class)
    @GetMapping("")
    public ResponseEntity<List<Recepy>> getRecepies() {
       return new ResponseEntity<>(recepyService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Post recepies in app")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Recepy.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error creating",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            )
    })
    @JsonView(Recepy.RecepyBasic.class)
    @PostMapping("/")
    public ResponseEntity<Recepy> postRecepies(@RequestBody Recepy recepy) {
        try{
            recepyService.save(recepy);
            URI location = fromCurrentRequest().path("forms/{id}")
                    .buildAndExpand(recepy.getId()).toUri();
            return ResponseEntity.created(location).body(recepy);
        }catch (EmptyResultDataAccessException e){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    }

    @Operation(summary = "Post image recepies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Recepy.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error creating",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            )
    })
    @JsonView(Recepy.RecepyBasic.class)
    @PostMapping(value = "/image",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadMyImage(@RequestParam MultipartFile imageFile,@RequestParam long id) throws IOException {
            Recepy recAux=recepyService.findById(id).orElseThrow();
            try{
                URI location = fromCurrentRequest().build().toUri();
                recAux.setImage(location.toString());
                recAux.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
                recepyService.save(recAux);
                return ResponseEntity.created(location).body(recAux);
            }catch (EmptyResultDataAccessException e){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    }

    @Operation(summary = "Get Client Recepies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Recepy.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            )

    })
    @JsonView(Recepy.RecepyBasic.class)
    @GetMapping("/me")
    public ResponseEntity<List<Recepy>> getClientRecepies(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        User user = userService.findByEmail(principal.getName()).orElseThrow();
        List<Recepy> recepies = new ArrayList<>();
        Optional<Diet> diet = Optional.ofNullable(user.getDiet());

        if (diet.isPresent()) {
            try {
                Triplet[] diet1 = diet.get().getWeek();
                for (Triplet aux : diet1) {
                    Recepy recepy = recepyService.findByName((String) aux.Breakfast).orElseThrow();
                    if (!recepies.contains(recepy))
                        recepies.add(recepy);
                    Recepy recepy1 = recepyService.findByName((String) aux.Lunch).orElseThrow();
                    if (!recepies.contains(recepy1))
                        recepies.add(recepy1);
                    Recepy recepy2 = recepyService.findByName((String) aux.Dinner).orElseThrow();
                    if (!recepies.contains(recepy2))
                        recepies.add(recepy2);
                }
            }catch (EmptyResultDataAccessException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
            return new ResponseEntity<>(recepies, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

}
