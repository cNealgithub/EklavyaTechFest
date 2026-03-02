package com.CodersHubDspmu.EklavyaTechFest.Repository;

import com.CodersHubDspmu.EklavyaTechFest.Entity.Events;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Registrations;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationsRepo extends JpaRepository<Registrations, Long> {
    boolean existsByUserAndEvent(Users user, Events events);

    List<Registrations> findByUserEmail(String userEmail);
}
