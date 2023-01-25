package com.telia.personalinformation.config;

import com.telia.personalinformation.model.PersonalInformationEntity;
import com.telia.personalinformation.model.dto.request.PersonalInformationEntityRequestDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
