package com.CodersHubDspmu.EklavyaTechFest.Service;

import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsResponseDTO;

import java.util.List;

public interface RegistrationsService {
     String addRegistration(RegistrationsRequestDTO registrationsRequestDTO);

     List<RegistrationsResponseDTO> getAllUsers();

     RegistrationsResponseDTO findRegistrationById(long id);

     List<RegistrationsResponseDTO> findRegistrationByUserEmail(String userEmail);
}
