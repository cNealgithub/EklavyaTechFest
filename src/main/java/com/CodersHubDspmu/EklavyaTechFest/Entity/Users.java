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
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String universityName;
    @Column(unique = true, nullable = false)
    private String phoneNo;
    @Column(nullable = false)
    private String fullAddress;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Registrations> registrations;

}
