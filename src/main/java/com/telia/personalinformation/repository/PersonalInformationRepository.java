package com.telia.personalinformation.repository;

import com.telia.personalinformation.model.PersonalInformationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformationEntity, Long>
{


}
