package com.CodersHubDspmu.EklavyaTechFest.DTO;

import com.CodersHubDspmu.EklavyaTechFest.Entity.Events;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationsResponseDTO {
    private long id;
    private String status;
    private Users user;
    private LocalDateTime registeredOn;
    private Events event;
    private Map<String, Object> eventData;
}
