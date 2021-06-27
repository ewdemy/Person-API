package com.mrcruz.personapi.service;

import com.mrcruz.personapi.dto.PersonDTO;
import com.mrcruz.personapi.mapper.PersonMapper;
import com.mrcruz.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper mapper = PersonMapper.INSTANCE;

    public PersonDTO save(PersonDTO dto){
        return mapper.toDTO(personRepository.save(mapper.toModel(dto)));
    }

    public List<PersonDTO> findAll(){
        return personRepository.findAll()
                .stream()
                .map((person) -> mapper.toDTO(person))
                .collect(Collectors.toList());
    }
}
