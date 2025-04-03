package com.tablejoin.controller;

import com.tablejoin.entity.Lead;
import com.tablejoin.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/com")
public class MainController {
    @Autowired
    LeadRepository leadRepository;
    @GetMapping("/login")
    public String init(){
        return "logged in";
    }
    @PostMapping("/register")
    public String register(@RequestBody Lead lead){
        leadRepository.save(lead);
        return lead.getName()+ " registered";
    }
    @PostMapping("/registerall")
    public String registerall(@RequestBody List<Lead> leads){
        leadRepository.saveAll(leads);
        return leads.get(0).getName()+ " registered";
    }
    @GetMapping("/leads")
    public List<Lead> getAllLeads(){
        return leadRepository.findAll();
    }
}
