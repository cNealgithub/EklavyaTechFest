package com.CodersHubDspmu.EklavyaTechFest.Controller;

import com.CodersHubDspmu.EklavyaTechFest.DTO.EventRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.EventResponseDTO;
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

}
