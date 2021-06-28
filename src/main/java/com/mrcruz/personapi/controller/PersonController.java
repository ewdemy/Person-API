package com.mrcruz.personapi.controller;

import com.mrcruz.personapi.dto.PersonDTO;
import com.mrcruz.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO save(@RequestBody @Valid PersonDTO personDto){
        return personService.save(personDto);
    }

    @GetMapping
    public List<PersonDTO> getAll(){
        return personService.findAll();
    }
}