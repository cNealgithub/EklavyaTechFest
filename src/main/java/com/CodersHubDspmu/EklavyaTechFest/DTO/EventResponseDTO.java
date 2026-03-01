package com.CodersHubDspmu.EklavyaTechFest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventResponseDTO {
    private long id;
    private String name;
    private String category;
    private Integer max_registration;
}
