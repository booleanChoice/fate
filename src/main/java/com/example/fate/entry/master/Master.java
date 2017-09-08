package com.example.fate.entry.master;

import org.springframework.util.StringUtils;

public class Master {
    
    private String name;
    private Integer age;
    
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
        System.out.println("Master" + this.name + "attack !");
    }
    
}
