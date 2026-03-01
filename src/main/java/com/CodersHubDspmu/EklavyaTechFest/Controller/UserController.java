package com.CodersHubDspmu.EklavyaTechFest.Controller;

import com.CodersHubDspmu.EklavyaTechFest.DTO.UserRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.UserResponseDTO;
import com.CodersHubDspmu.EklavyaTechFest.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/OnBoard")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userRequestDTO));
    }
    @GetMapping("/userList")
    public ResponseEntity<List<UserResponseDTO>> allUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> userById(@PathVariable long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<UserResponseDTO> userByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }
}
