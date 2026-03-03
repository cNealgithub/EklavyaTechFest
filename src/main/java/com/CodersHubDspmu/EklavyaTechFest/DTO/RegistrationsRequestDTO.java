package com.CodersHubDspmu.EklavyaTechFest.DTO;

import com.CodersHubDspmu.EklavyaTechFest.Entity.Events;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationsRequestDTO {

    private String firstName;
    private String lastName;
    private String gender;
    private String universityName;
    private int semester;
    private String department;
    private String phoneNo;
    private String whatsAppNumber;
    private String fullAddress;
    private Events event;
    //Hackathon - > 1
    private Map<String, Object> eventData;
    private String userEmail;
}
