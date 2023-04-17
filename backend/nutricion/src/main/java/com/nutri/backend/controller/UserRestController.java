package com.nutri.backend.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Recepy;
import com.nutri.backend.model.Triplet;
import com.nutri.backend.model.User;
import com.nutri.backend.service.DietService;
import com.nutri.backend.service.RecepyService;
import com.nutri.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.sql.SQLException;
import java.util.*;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
import static org.springframework.web.util.UriComponentsBuilder.newInstance;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private DietService dietService;

    @Autowired
    private RecepyService recepyService;

    //GET functions
    //GET log user
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
    @Operation(summary = "Get pages users by type")
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
    public ResponseEntity<List<User>> getUsersByType(@RequestParam String type,@RequestParam int page) {
        Page<User> client = userService.findPageClient(page, type);
        List<User> users = client.toList();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(summary = "Get pages users by type")
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
    @JsonView({User.ClientLog.class})
    @PutMapping("/me/")
    public ResponseEntity<Optional<User>> updateUser(HttpServletRequest request,@RequestBody User updated){
        Principal principal = request.getUserPrincipal();
        User user = userService.findByEmail(principal.getName()).orElseThrow();
        if (!updated.getName().equals("")){
            user.setName(updated.getName());
        }if (!updated.getSurname().equals("")){
            user.setSurname(updated.getSurname());
        }if (!updated.getEmail().equals("")){
            user.setEmail(updated.getEmail());
        }if (!updated.getEncodedPassword().equals("")){
          String pass= passwordEncoder.encode(updated.getEncodedPassword());
            user.setEncodedPassword(pass);
        }
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }




    //GET User with id
    @Operation(summary = "Get a user by id")

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
    @JsonView(User.WorkerLog.class)
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
    public ResponseEntity<HashMap<Integer, Integer>> getAdminStatsUsers() {
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
    public ResponseEntity<HashMap<String, Integer>> getAdminStatsDiets() {
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
    public ResponseEntity<HashMap<Integer, Integer>> getAdminStatsEans() {
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
    public ResponseEntity<Integer> getAdminDiets() {
        return new ResponseEntity(dietService.numOfDiets(), HttpStatus.OK);
    }

    //User GET methods
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
    @GetMapping("/me/recepies")
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
    @Operation(summary = "Get Client Diet")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Diet.class)
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
    @JsonView(Diet.DietBasic.class)
    @GetMapping("/me/diets")
    public ResponseEntity<Diet> getClientDiet(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        User user = userService.findByEmail(principal.getName()).orElseThrow();
        Diet diet = dietService.findByName(user.getDiet().getName()).orElseThrow();
            try {
                return new ResponseEntity<>(diet,HttpStatus.OK);
            } catch (EmptyResultDataAccessException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @Operation(summary = "Get Client Stats")
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
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            )

    })
    @JsonView(User.ClientInfo.class)
    @GetMapping("/me/stats")
    public ResponseEntity<List<HashMap<String,Integer>>> getClientStats(HttpServletRequest request) {
        try {
            return new ResponseEntity(userService.statisticsRecepiesDownloaded(request),HttpStatus.OK);

        }catch (EmptyResultDataAccessException e){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
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
                            schema = @Schema(implementation = User.class)
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
            int month = c1.get(Calendar.MONTH);
            user.setEntryDate(month);
            //setUserImage(user, "");
            user.setEncodedPassword(passwordEncoder.encode(user.getEncodedPassword()));
            userService.save(user);
            URI location = fromCurrentRequest().path("/workers/{id}")
                    .buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(location).body(user);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Post a new client")

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
    @PostMapping("/client/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createMemberClient(@RequestBody User user) {
        if (user.getUserType().equals("client")) {
            Calendar c1 = Calendar.getInstance();
            int month = c1.get(Calendar.MONTH);
            user.setEntryDate(month);
            setUserImage(user, new ClassPathResource("static/images/undraw_profile.jpg").getPath());
            user.setEncodedPassword(passwordEncoder.encode(user.getEncodedPassword()));
            userService.save(user);
            URI location = fromCurrentRequest().path("/client/{id}")
                    .buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(location).body(user);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    private void setUserImage(User user, String classpathResource){
        try {
            Resource image = new ClassPathResource(classpathResource);
            user.setImage("Default");
            user.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
        } catch(Exception e){

        }
    }

    //DELETE functions
    @Operation(summary = "Delete users ")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
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
                if(userService.findById(l).isPresent()) {
                    userService.delete(l);
                }
            }
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @Operation(summary = "Get user image")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the exercise",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClientController.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })

    @GetMapping("/me/image")
    public ResponseEntity<Object> downloadImage(HttpServletRequest request) throws SQLException {
        Principal principal = request.getUserPrincipal();
        User client = userService.findByEmail(principal.getName()).orElseThrow();

        if (client.hasImage()) {

            Resource file = new InputStreamResource(client.getImageFile().getBinaryStream());

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .contentLength(client.getImageFile().length()).body(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "POST a user image")

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
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid id supplied",
                    content = @Content
            )
    })

    @PostMapping("/me/image")
    public ResponseEntity<Object> uploadMyImage(HttpServletRequest request, @RequestParam MultipartFile imageFile) throws IOException {
        Principal principal = request.getUserPrincipal();

        if (principal != null) {
            User client = userService.findByEmail(principal.getName()).orElseThrow();

            URI location = fromCurrentRequest().build().toUri();
            client.setImage(location.toString());
            client.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            userService.save(client);

            return ResponseEntity.created(location).build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}

