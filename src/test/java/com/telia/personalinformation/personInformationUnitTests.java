package com.telia.personalinformation;

import com.telia.personalinformation.model.PersonalInformationEntity;
import com.telia.personalinformation.repository.PersonalInformationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

/**
 * This class is used to showcase Unit testing capability. Here Junit test cases are written for each method. Different test classes can be written to test various business logics
 */
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class personInformationUnitTests {
    @Autowired
    private PersonalInformationRepository repository;

    @Test
    @Order(1)
    public void saveAndUpdateUserTest() {
        PersonalInformationEntity user = PersonalInformationEntity.builder().firstName("firstName").lastName("LastName").dateOfBirth("23-08-1991").emailAddress("test@gmail.com").build();
        PersonalInformationEntity response = repository.save(user);
        Assertions.assertThat(response.getPersonalNumber()).isNotNull();
        user = PersonalInformationEntity.builder().personalNumber(response.getPersonalNumber()).firstName("newName").build();
        response = repository.save(user);
        Assertions.assertThat(response.getFirstName()).isEqualTo("newName");
    }
}
