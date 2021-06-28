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

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO){
        return personService.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        personService.delete(id);
    }
}