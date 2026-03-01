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
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public String addRegistration(RegistrationsRequestDTO registrationsRequestDTO) {

        long eventId = registrationsRequestDTO.getEvent().getId();
        String email = registrationsRequestDTO.getUserEmail();

        Users user = userRepo.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User Not registered with email "+registrationsRequestDTO.getUserEmail()));
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
                .build();
        registrationsRepo.save(registration);
        return "Registered successfully";
    }

    @Override
    public List<RegistrationsResponseDTO> getAllUsers() {

        return registrationsRepo.findAll().stream()
                .map(registrations -> modelMapper.map(registrations, RegistrationsResponseDTO.class))
                .collect(Collectors.toList());
    }
}
