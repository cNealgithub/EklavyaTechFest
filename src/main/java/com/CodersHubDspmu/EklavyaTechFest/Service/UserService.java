package com.CodersHubDspmu.EklavyaTechFest.Service;

import com.CodersHubDspmu.EklavyaTechFest.DTO.UserRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.UserResponseDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface UserService {
     UserResponseDTO create(UserRequestDTO userRequestDTO);

     List<UserResponseDTO> getAllUsers();

     UserResponseDTO findUserById(long id);
}
