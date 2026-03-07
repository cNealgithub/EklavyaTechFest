package com.CodersHubDspmu.EklavyaTechFest.Service.IMPL;

import com.CodersHubDspmu.EklavyaTechFest.DTO.UserRequestDTO;
import com.CodersHubDspmu.EklavyaTechFest.DTO.UserResponseDTO;
import com.CodersHubDspmu.EklavyaTechFest.Entity.Users;
import com.CodersHubDspmu.EklavyaTechFest.Repository.UserRepo;
import com.CodersHubDspmu.EklavyaTechFest.Service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo repo;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        Users users = Users.builder()
                .firstName(userRequestDTO.getFirstName())
                .lastName(userRequestDTO.getLastName())
                .email(userRequestDTO.getEmail())
                .phoneNo(userRequestDTO.getPhoneNo())
                .universityName(userRequestDTO.getUniversityName())
                .fullAddress(userRequestDTO.getFullAddress())
                .build();
        users = repo.save(users);
        return modelMapper.map(users, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return repo.findAll().stream()
                .map(Users -> modelMapper.map(Users, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO findUserById(long id) {
        Users user = repo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO findUserByEmail(String email) {
        Optional<Users> user = repo.findByEmail(email);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO patchUpdateUser(long id, Map<String, Object> updates) {
        Users user = repo.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Entity not found with id: "+id));
        updates.forEach((field, value) ->{
                switch (field) {
                    case "firstName":
                        user.setFirstName((String) value);
                        break;
                    case "lastName" :
                        user.setLastName((String) value);
                        break;
                    case "gender" :
                        user.setGender((String) value);
                        break;
                    case "universityName" :
                        user.setUniversityName((String) value);
                        break;
                    case "semester" :
                        user.setSemester(Integer.parseInt((String) value));
                        break;
                    case "department" :
                        user.setDepartment((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input");
                }
                });
        Users savedUser = repo.save(user);
        return modelMapper.map(savedUser, UserResponseDTO.class);
    }

    @Override
    public void deleteUserById(long id) {
        if(!repo.existsById(id)){
            throw new EntityNotFoundException("User not found with id: "+id);
        }
        repo.deleteById(id);
    }

}
