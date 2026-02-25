package com.CodersHubDspmu.EklavyaTechFest.Service;

import com.CodersHubDspmu.EklavyaTechFest.DTO.EventRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.EventResponseDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface EventsService {
     EventResponseDTO create(EventRequestDTO eventRequestDTO);

     List<EventResponseDTO> getAllEvents();

     EventResponseDTO getByid(long id);
}
