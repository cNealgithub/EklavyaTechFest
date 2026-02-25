package com.CodersHubDspmu.EklavyaTechFest.Service.IMPL;

import com.CodersHubDspmu.EklavyaTechFest.DTO.EventRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.EventResponseDTO;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Events;
import com.CodersHubDspmu.EklavyaTechFest.Repository.EventsRepo;
import com.CodersHubDspmu.EklavyaTechFest.Repository.UserRepo;
import com.CodersHubDspmu.EklavyaTechFest.Service.EventsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

    private final EventsRepo eventsRepo;
    private final ModelMapper modelMapper;

    @Override
    public EventResponseDTO create(EventRequestDTO eventRequestDTO) {
        Events event  = Events.builder()
                .name(eventRequestDTO.getName())
                .category(eventRequestDTO.getCategory())
                .max_registration(eventRequestDTO.getMax_registration())
                .build();
        event = eventsRepo.save(event);
        return modelMapper.map(event, EventResponseDTO.class);
    }

    @Override
    public List<EventResponseDTO> getAllEvents() {
        return eventsRepo.findAll().stream()
                .map(Events -> modelMapper.map(Events, EventResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventResponseDTO getByid(long id) {
        Events event = eventsRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id: "+id));
        return modelMapper.map(event, EventResponseDTO.class);
    }
}
