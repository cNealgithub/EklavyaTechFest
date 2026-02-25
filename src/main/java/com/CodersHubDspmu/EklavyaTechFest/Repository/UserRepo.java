package com.CodersHubDspmu.EklavyaTechFest.Repository;

import com.CodersHubDspmu.EklavyaTechFest.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
}
