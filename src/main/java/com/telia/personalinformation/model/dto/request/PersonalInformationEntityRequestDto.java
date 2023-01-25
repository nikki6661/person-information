package com.telia.personalinformation.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonalInformationEntityRequestDto implements Serializable {
    @NotBlank(message = "First Name is mandatory and cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory and cannot be blank")
    private String lastName;
    @NotNull(message = "Date of birth cannot be empty")
    private String dateOfBirth;
    @Email(message = "Please Use a valid Email Address")
    private String emailAddress;
}
