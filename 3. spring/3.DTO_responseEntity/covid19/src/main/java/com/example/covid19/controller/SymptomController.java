package com.example.covid19.controller;

import com.example.covid19.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SymptomController {
    SymptomService symptomService = new SymptomService();




}
