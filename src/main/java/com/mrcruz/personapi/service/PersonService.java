package com.mrcruz.personapi.service;

import com.mrcruz.personapi.dto.PersonDTO;
import com.mrcruz.personapi.entity.Person;
import com.mrcruz.personapi.mapper.PersonMapper;
import com.mrcruz.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        return mapper.toDTO(personRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Person not found with id: " + id)));
    }

    public void delete(Long id) {
        findById(id);

        personRepository.deleteById(id);
    }

    public PersonDTO update(Long id, PersonDTO personDTO) {
        findById(id);
        personDTO.setId(id);
        return mapper.toDTO(personRepository.save(mapper.toModel(personDTO)));
    }
}
