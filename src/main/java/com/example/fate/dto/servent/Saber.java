package com.example.fate.dto.servent;

import org.springframework.stereotype.Component;

//@Component("arthur")
@Component
public class Saber extends Servent {
    
    public Saber() {
        this.health = 100.00;
        this.mana = 100.00;
    }
    
    public Saber(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.health = 100.00;
        this.mana = 100.00;
    }
    
    protected Saber(String name, Integer age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.health = 100.00;
        this.mana = 100.00;
    }
    
    @Override
    public void attack() {
        // TODO Auto-generated method stub
        
    }

}
