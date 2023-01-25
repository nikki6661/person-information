package com.telia.personalinformation.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalInformationEntityResponseDto implements Serializable {
    @NotNull(message = "Personal Number is mandatory")
    private Long personalNumber;
    @NotBlank(message = "First Name is mandatory and cannot be blank")
    private String firstName;
    @NotBlank(message = "Name is mandatory and cannot be blank")
    private String lastName;
    @NotNull(message = "Date of birth cannot be empty")
    private String dateOfBirth;
    @Email(message = "Please Use a valid Email Address")
    private String emailAddress;
}
