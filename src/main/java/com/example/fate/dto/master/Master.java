package com.example.fate.dto.master;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.StringUtils;

public class Master {
    
    @Size(min = 2)
    private String name;
    @Email
    @NotEmpty
    private String email;
    private LocalDate birthDate;
    /**
     * for summon
     */
    @NotEmpty
    private String medium;
    
    public Master() {
        
    }
    
    public Master(String name) {
        this.name = name;
    }
    
    public Master(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
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
