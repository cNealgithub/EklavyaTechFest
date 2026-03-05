package com.CodersHubDspmu.EklavyaTechFest.Service;

import com.CodersHubDspmu.EklavyaTechFest.DTO.EventRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.EventResponseDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface EventsService {
     EventResponseDTO create(EventRequestDTO eventRequestDTO);

     List<EventResponseDTO> getAllEvents();

     EventResponseDTO getByid(long id);

     EventResponseDTO patchUpdate(long id, Map<String, Object> updates);

    void removeEventById(long id);
}
