package com.CodersHubDspmu.EklavyaTechFest.DTO;

import com.CodersHubDspmu.EklavyaTechFest.Entity.Events;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationsRequestDTO {

    private Events event;
    //Hackathon - > 1
    private Map<String, Object> eventData;
    private String userEmail;
}
