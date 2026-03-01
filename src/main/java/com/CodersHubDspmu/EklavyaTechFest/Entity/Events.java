package com.CodersHubDspmu.EklavyaTechFest.Entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private Integer max_registration;
//    @OneToMany(mappedBy = "event")
//    private List<Registrations> registrations;
}
