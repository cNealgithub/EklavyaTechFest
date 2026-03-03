package com.CodersHubDspmu.EklavyaTechFest.Service.IMPL;

import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.RegistrationsResponseDTO;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Events;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Registrations;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Users;
import com.CodersHubDspmu.EklavyaTechFest.Repository.EventsRepo;
import com.CodersHubDspmu.EklavyaTechFest.Repository.RegistrationsRepo;
import com.CodersHubDspmu.EklavyaTechFest.Repository.UserRepo;
import com.CodersHubDspmu.EklavyaTechFest.Service.RegistrationsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistrationsServiceImpl implements RegistrationsService {

    private final RegistrationsRepo registrationsRepo;
    private final UserRepo userRepo;
    private final EventsRepo eventsRepo;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public RegistrationsResponseDTO addRegistration(RegistrationsRequestDTO registrationsRequestDTO) {

        long eventId = registrationsRequestDTO.getEvent().getId();
        String email = registrationsRequestDTO.getUserEmail();

        Users user = userRepo.findByEmail(email)
               .orElseGet(()-> {
                           Users newUser = Users.builder()
                                   .firstName(registrationsRequestDTO.getFirstName())
                                   .lastName(registrationsRequestDTO.getLastName())
                                   .gender(registrationsRequestDTO.getGender())
                                   .email(email)
                                   .fullAddress(registrationsRequestDTO.getFullAddress())
                                   .phoneNo(registrationsRequestDTO.getPhoneNo())
                                   .whatsAppNumber(registrationsRequestDTO.getWhatsAppNumber())
                                   .universityName(registrationsRequestDTO.getUniversityName())
                                   .semester(registrationsRequestDTO.getSemester())
                                   .department(registrationsRequestDTO.getDepartment())
                                   .build();
                           return userRepo.save(newUser);
                       });
//
        Events events = eventsRepo.findById(eventId)
                .orElseThrow(()-> new RuntimeException("Invalid event selection"));
        if (registrationsRepo.existsByUserAndEvent(user, events)) {
            throw new RuntimeException("You are already registered for this event!");
        }
        Registrations registration = Registrations.builder()
                .user(user)
                .event(events)
                .eventData(registrationsRequestDTO.getEventData())
                .status("Approved")
                .registeredOn(LocalDateTime.now())
                .build();
        registrationsRepo.save(registration);
        return modelMapper.map(registration, RegistrationsResponseDTO.class);
    }

    @Override
    public List<RegistrationsResponseDTO> getAllUsers() {

        return registrationsRepo.findAll().stream()
                .map(registrations -> modelMapper.map(registrations, RegistrationsResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RegistrationsResponseDTO findRegistrationById(long id) {
        Registrations registration = registrationsRepo.findById(id).
                orElseThrow(()-> new RuntimeException("Registration not found with id: "+id));
        return modelMapper.map(registration, RegistrationsResponseDTO.class);
    }

    @Override
    public List<RegistrationsResponseDTO> findRegistrationByUserEmail(String userEmail) {
        List<Registrations> registrationsList = registrationsRepo.findByUserEmail(userEmail);
        if(registrationsList.isEmpty()){
            throw new RuntimeException("No Registration find associated to email: "+userEmail);
        }
        return registrationsList.stream()
                .map(registrations -> modelMapper.map(registrations,RegistrationsResponseDTO.class))
                .collect(Collectors.toList());
    }
}
