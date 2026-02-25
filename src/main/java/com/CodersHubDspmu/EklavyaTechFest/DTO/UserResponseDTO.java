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
    private String email;
    private String universityName;
    private String phoneNo;
    private String fullAddress;
}
