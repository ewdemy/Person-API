package com.mrcruz.personapi.mapper;

import com.mrcruz.personapi.dto.PersonDTO;
import com.mrcruz.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
