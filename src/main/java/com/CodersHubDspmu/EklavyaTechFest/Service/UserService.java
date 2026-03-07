package com.CodersHubDspmu.EklavyaTechFest.Service;

import com.CodersHubDspmu.EklavyaTechFest.DTO.UserRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.UserResponseDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface UserService {
     UserResponseDTO create(UserRequestDTO userRequestDTO);

     List<UserResponseDTO> getAllUsers();

     UserResponseDTO findUserById(long id);

     UserResponseDTO findUserByEmail(String email);

     UserResponseDTO patchUpdateUser(long id, Map<String, Object> updates);

    void deleteUserById(long id);
}
