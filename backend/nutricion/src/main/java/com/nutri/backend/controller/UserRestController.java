package com.nutri.backend.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.nutri.backend.model.Diet;
import com.nutri.backend.model.User;
import com.nutri.backend.service.DietService;
import com.nutri.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.security.Principal;
import java.util.*;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private DietService dietService;

    //GET functions
    //GET log monitor
    @Operation(summary = "Get user logged in the application")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the user",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @JsonView(User.WorkerLog.class)
    @GetMapping("/me")
    public ResponseEntity<User> userLoged(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            return ResponseEntity.ok(userService.findByEmail(principal.getName()).orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //GET users
    @Operation(summary = "Get all users by type")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the users",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @JsonView({User.WorkerLog.class})
    @GetMapping("")
    public ResponseEntity<List<User>> getWorkers(@RequestParam String type) {
        return new ResponseEntity<>(userService.findByUserType(type),HttpStatus.OK);
    }

    //GET User with id
    @Operation(summary = "Get a user by id")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the user",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation=User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid id supplied",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "monitor not found",
                    content = @Content
            )
    })

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        Optional<User> op = userService.findById(id);
        if (op.isPresent()) {
            User user = op.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Admin statistics
    @Operation(summary = "Get admin statistics users")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @GetMapping("/admin/stats/users")
    public ResponseEntity<HashMap<Integer,Integer>> getAdminStatsUsers(){
        return new ResponseEntity<>(userService.statisticsUserByMont(), HttpStatus.OK);
    }

    @Operation(summary = "Get admin statistics diets")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @GetMapping("/admin/stats/diets")
    public ResponseEntity<HashMap<String,Integer>> getAdminStatsDiets(){
        return new ResponseEntity(userService.statisticsDiets(), HttpStatus.OK);
    }

    @Operation(summary = "Get admin statistics earns")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @GetMapping("/admin/stats/earns")
    public ResponseEntity<HashMap<Integer,Integer>> getAdminStatsEans(){
        return new ResponseEntity<>(userService.statisticsEarnsByMonth(), HttpStatus.OK);
    }

    @Operation(summary = "Get admin statistics all diets")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })
    @GetMapping("/admin/stats/diets/all")
    public ResponseEntity<Integer> getAdminDiets(){
        return new ResponseEntity(dietService.numOfDiets(), HttpStatus.OK);
    }







    //POST functions

    //POST members
    @Operation(summary = "Post a new worker")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation=User.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            )
    })

    @PostMapping("/workers/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createMember(@RequestBody User user) {
        if (user.getUserType().equals("worker")) {
            Calendar c1 = Calendar.getInstance();
            int month =c1.get(Calendar.MONTH) ;
            user.setEntryDate(month);
            //setUserImage(user, "");
            user.setEncodedPassword(passwordEncoder.encode(user.getEncodedPassword()));
            URI location = fromCurrentRequest().path("/workers/{id}")
                    .buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(location).body(user);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    // private void setUserImage(User user, String path){
    //    try {
    //        Resource image = new ClassPathResource(path);
    //
    //    } catch(Exception e){
    // }


    //DELETE functions


    //UPDATE functions
}
