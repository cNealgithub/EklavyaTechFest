package com.CodersHubDspmu.EklavyaTechFest.Service;

import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsResponseDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface RegistrationsService {
     String addRegistration(RegistrationsRequestDTO registrationsRequestDTO);

     List<RegistrationsResponseDTO> getAllUsers();

     RegistrationsResponseDTO findRegistrationById(long id);
}
