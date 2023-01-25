package com.telia.personalinformation.controller;

import com.telia.personalinformation.exception.PersonEntityNotFoundException;
import com.telia.personalinformation.model.PersonalInformationEntity;
import com.telia.personalinformation.model.dto.request.PersonalInformationEntityRequestDto;
import com.telia.personalinformation.model.dto.response.PersonalInformationEntityResponseDto;
import com.telia.personalinformation.service.PersonalInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Validated
public class PersonalInformationController {

    private final PersonalInformationService service;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonalInformationController(PersonalInformationService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public PersonalInformationEntityResponseDto createUser(@Valid @RequestBody PersonalInformationEntityRequestDto person) {
        PersonalInformationEntity personEntity = modelMapper.map(person, PersonalInformationEntity.class);
        PersonalInformationEntity response = service.createUser(personEntity);
        return modelMapper.map(response, PersonalInformationEntityResponseDto.class);
    }

    @DeleteMapping("/delete/{personalNumber}")
    public ResponseEntity<String> deleteUser(@Valid @PathVariable @NotNull(message = "Personal Number is mandatory") Long personalNumber) {
        service.deleteUserByID(personalNumber);
        return new ResponseEntity<>("deleted succesfully", HttpStatus.OK);
    }

    @PutMapping("/update/{personalNumber}")
    public PersonalInformationEntityResponseDto updateUser(@RequestBody PersonalInformationEntityRequestDto person, @PathVariable @NotNull(message = "Personal Number is mandatory") Long personalNumber) {
        PersonalInformationEntity personEntity = modelMapper.map(person, PersonalInformationEntity.class);
        PersonalInformationEntity response = service.updateUser(personEntity, personalNumber);
        return modelMapper.map(response, PersonalInformationEntityResponseDto.class);
    }

    @GetMapping
    public List<PersonalInformationEntityResponseDto> getAllUsers(@Valid Pageable pageable) {
        Page<PersonalInformationEntity> response = service.findAllUsers(pageable);
        return response.getContent().stream().map(personalInformationEntity -> modelMapper.map(personalInformationEntity, PersonalInformationEntityResponseDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{personalNumber}")
    public PersonalInformationEntityResponseDto getUserById(@Valid @PathVariable @NotNull(message = "Personal Number is mandatory") Long personalNumber) {
        var response = service.findByPersonNumber(personalNumber);
        return response.map(personalInformationEntity -> modelMapper.map(personalInformationEntity, PersonalInformationEntityResponseDto.class)).orElseThrow(() -> new PersonEntityNotFoundException(personalNumber));
    }

}
