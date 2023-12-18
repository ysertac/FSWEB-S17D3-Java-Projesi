package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangoroo;
import com.workintech.zoo.validations.KangorooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangoroos")
public class KangorooController {
    private Map<Integer, Kangoroo> kangoroos;

    @PostConstruct
    public void init() {
        kangoroos = new HashMap<>();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Kangoroo> findAll() {
        return this.kangoroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangoroo find(@PathVariable("id") Integer id) {
        KangorooValidation.isIdValid(id);
        return kangoroos.get(id);
    }

    @PostMapping
    public Kangoroo create(@RequestBody Kangoroo kangoroo) {
        kangoroos.put(kangoroo.getId(), kangoroo);
        return kangoroos.get(kangoroo.getId());
    }

    @PutMapping("/{id}")
    public Kangoroo update(@PathVariable("id") Integer id, @RequestBody Kangoroo kangoroo) {
        kangoroo.setId(id);
        kangoroos.replace(id, kangoroo);
        return kangoroos.get(kangoroo.getId());
    }

    @DeleteMapping("/{id}")
    public Kangoroo delete(@PathVariable("id") Integer id) {
        return kangoroos.remove(id);
    }
}
