package com.CodersHubDspmu.EklavyaTechFest.Controller;

import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsResponseDTO;
import com.CodersHubDspmu.EklavyaTechFest.Service.RegistrationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registers")
@RequiredArgsConstructor
public class RegistrationsController {

    public final RegistrationsService registrationsService;

    @PostMapping("/create")
    public ResponseEntity<String> register(@RequestBody RegistrationsRequestDTO registrationsRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationsService.addRegistration(registrationsRequestDTO));
    }
    @GetMapping("/List")
    public ResponseEntity<List<RegistrationsResponseDTO>> allRegistrations(){
        return ResponseEntity.ok(registrationsService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationsResponseDTO> registrationById(@PathVariable long id){
        return ResponseEntity.ok(registrationsService.findRegistrationById(id));
    }
}
