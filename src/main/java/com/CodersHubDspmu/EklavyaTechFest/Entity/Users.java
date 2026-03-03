package com.CodersHubDspmu.EklavyaTechFest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String gender;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String universityName;
    @Column(nullable = false)
    private int semester;
    @Column(nullable = false)
    private String department;
    @Column(unique = true, nullable = false)
    private String phoneNo;
    @Column(unique = true, nullable = false)
    private String whatsAppNumber;
    @Column(nullable = false)
    private String fullAddress;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Registrations> registrations;

}
