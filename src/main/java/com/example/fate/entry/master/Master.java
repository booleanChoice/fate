package com.example.fate.entry.master;

import org.springframework.util.StringUtils;

public class Master {
    
    private String name;
    private Integer age;
    
    public Master() {
        
    }
    
    public Master(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public void attack() {
        if (StringUtils.isEmpty(this.name))
            this.name = "default";
        System.out.println("Master" + this.name + "attacks !");
    }
    
    public void spell(String spell) {
        if (StringUtils.isEmpty(this.name))
            this.name = "default";
        System.out.println("Master" + this.name + "spells :" + spell);
    }
}
