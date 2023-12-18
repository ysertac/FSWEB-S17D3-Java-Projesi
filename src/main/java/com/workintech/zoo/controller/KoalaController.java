package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.validations.KangorooValidation;
import com.workintech.zoo.validations.KoalaValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Koala> findAll() {
        return this.koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala find(@PathVariable("id") Integer id) {
        KoalaValidation.isIdValid(id);
        return koalas.get(id);
    }

    @PostMapping
    public Koala create(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable("id") Integer id, @RequestBody Koala koala) {
        koala.setId(id);
        koalas.replace(id, koala);
        return koalas.get(koala.getId());
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable("id") Integer id) {
        return koalas.remove(id);
    }
}
