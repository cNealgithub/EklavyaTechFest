package com.CodersHubDspmu.EklavyaTechFest.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Registrations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;
    @CreatedDate
    private LocalDateTime registeredOn;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Events event;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String, Object> eventData;

}
