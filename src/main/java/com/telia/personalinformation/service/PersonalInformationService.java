package com.telia.personalinformation.service;

import com.telia.personalinformation.exception.PersonEntityNotFoundException;
import com.telia.personalinformation.model.PersonalInformationEntity;
import com.telia.personalinformation.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PersonalInformationService {

    private final PersonalInformationRepository repository;
    private final EntityManager manager ;

    @Autowired
    public PersonalInformationService(EntityManager manager,PersonalInformationRepository repository) {

        this.manager=manager;
        this.repository = repository;
    }

    public PersonalInformationEntity createUser(PersonalInformationEntity person) {

        return repository.save(person);
    }

    public void deleteUserByID(Long personalNumber)
    {
        if (repository.existsById(personalNumber)) {
            repository.deleteById(personalNumber);
        } else {
            throw new PersonEntityNotFoundException(personalNumber);
        }
    }

    public PersonalInformationEntity updateUser(PersonalInformationEntity person, Long personalNumber) {
        if (repository.existsById(personalNumber)) {
            person.setPersonalNumber(personalNumber);
            return repository.save(person);
        } else {
            throw new PersonEntityNotFoundException(personalNumber);
        }

    }

    public Page<PersonalInformationEntity> findAllUsers(Pageable pageable){

        return repository.findAll(pageable);
    }

    public Optional<PersonalInformationEntity> findByPersonNumber(Long personalNumber) {
        return repository.findById(personalNumber);
    }
}

