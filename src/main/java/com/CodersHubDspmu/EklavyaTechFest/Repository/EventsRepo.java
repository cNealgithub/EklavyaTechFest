package com.CodersHubDspmu.EklavyaTechFest.Repository;

import com.CodersHubDspmu.EklavyaTechFest.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepo extends JpaRepository<Events, Long> {
}
