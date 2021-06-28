package com.mrcruz.personapi.service;

import com.mrcruz.personapi.dto.PersonDTO;
import com.mrcruz.personapi.entity.Person;
import com.mrcruz.personapi.mapper.PersonMapper;
import com.mrcruz.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper mapper = PersonMapper.INSTANCE;

    public PersonDTO save(PersonDTO dto){
        Person person = personRepository.save(mapper.toModel(dto));
        return mapper.toDTO(person);
    }

    public List<PersonDTO> findAll(){
        return personRepository.findAll()
                .stream()
                .map((person) -> mapper.toDTO(person))
                .collect(Collectors.toList());
    }
}
