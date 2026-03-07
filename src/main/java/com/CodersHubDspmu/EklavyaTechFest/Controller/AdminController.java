package com.CodersHubDspmu.EklavyaTechFest.Controller;

import com.CodersHubDspmu.EklavyaTechFest.DTO.*;
import com.CodersHubDspmu.EklavyaTechFest.Service.EventsService;
import com.CodersHubDspmu.EklavyaTechFest.Service.RegistrationsService;
import com.CodersHubDspmu.EklavyaTechFest.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Admin/core")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final EventsService eventsService;
    private final RegistrationsService registrationsService;

    //event related CRUD
    @GetMapping("/allEvents")
    public ResponseEntity<List<EventResponseDTO>> adminGetsAllEvents(){
        return ResponseEntity.ok(eventsService.getAllEvents());
    }
    @PostMapping("/addEvent")
    public ResponseEntity<EventResponseDTO> adminCreatesEvent(@RequestBody EventRequestDTO eventRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventsService.create(eventRequestDTO));
    }
    @PatchMapping("/updateEvent/{id}")
    public ResponseEntity<EventResponseDTO> adminUpdatesEvent(@PathVariable long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.status(HttpStatus.OK).body(eventsService.patchUpdate(id, updates));
    }
    @DeleteMapping("/removeEvent/{id}")
    public ResponseEntity<Void> adminDeletesEvent(@PathVariable long id){
        eventsService.removeEventById(id);
        return ResponseEntity.noContent().build();
    }
    // User related CRUD
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponseDTO>> adminGetsAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("/addUser")
    public ResponseEntity<UserResponseDTO> adminAddsUser(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userRequestDTO));
    }
    @PatchMapping("/updateUser/{id}")
    public ResponseEntity<UserResponseDTO> adminUpdatesUser(@PathVariable long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(userService.patchUpdateUser(id, updates));
    }
    @DeleteMapping("/removeUser/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    //Registration related CRUD
    @GetMapping("/registrationsList")
    public ResponseEntity<List<RegistrationsResponseDTO>> adminGetsAllRegistrations(){
        return ResponseEntity.ok(registrationsService.getAllUsers());
    }
    @GetMapping("/registered/{id}")
    public ResponseEntity<RegistrationsResponseDTO> adminFindsRegistrationById(@PathVariable long id){
        return ResponseEntity.ok(registrationsService.findRegistrationById(id));
    }
    @GetMapping("/registered/{email}")
    public ResponseEntity<List<RegistrationsResponseDTO>> adminFindsRegistrationByEmail(@PathVariable String email){
        return ResponseEntity.ok(registrationsService.findRegistrationByUserEmail(email));
    }
    //updating registration will be in hold till fronted is ready for it
}
