package com.yep.metodoshttp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class HttpRestController {
    @GetMapping(path = "add")
    public String addPerson(@RequestParam int id,
                          @RequestParam String name,
                          @RequestParam int age) {
        Person person = new Person(id, name, age);
        return person.toString();
    }
}
