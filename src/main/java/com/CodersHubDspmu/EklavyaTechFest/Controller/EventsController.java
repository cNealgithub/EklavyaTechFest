package com.CodersHubDspmu.EklavyaTechFest.Controller;

import com.CodersHubDspmu.EklavyaTechFest.DTO.EventRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.EventResponseDTO;
import com.CodersHubDspmu.EklavyaTechFest.Service.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventsController {

    private final EventsService eventsService;

    @GetMapping("/list")
    public ResponseEntity<List<EventResponseDTO>> eventList(){
        return ResponseEntity.ok(eventsService.getAllEvents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> findByEventId(@PathVariable long id){
        return ResponseEntity.ok(eventsService.getByid(id));
    }
}
