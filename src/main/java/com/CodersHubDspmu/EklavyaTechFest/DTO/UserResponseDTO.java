package com.CodersHubDspmu.EklavyaTechFest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String universityName;
    private int semester;
    private String department;
    private String phoneNo;
    private String whatsAppNumber;
    private String fullAddress;
}
