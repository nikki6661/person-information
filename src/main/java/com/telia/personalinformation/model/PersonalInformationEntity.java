package com.telia.personalinformation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="personalInformation")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PersonalInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personalNumber", nullable = false)
    private Long personalNumber;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "dateOfBirth", nullable = false)
    private String dateOfBirth;

    @Column(name = "emailAddress", nullable = false)
    private String emailAddress;

}
