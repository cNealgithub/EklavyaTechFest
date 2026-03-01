package com.CodersHubDspmu.EklavyaTechFest.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDTO {
    private String name;
    private String category;
    private Integer max_registration;
}
