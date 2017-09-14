package com.example.fate.dto.servent;

import java.util.List;

public abstract class Servent {
     
    protected String name;
    protected Integer age;
    protected Double health;
    protected Double mana;
    protected List<NoblePhantasm> nps;
    protected String description;
    
    protected Servent() {
        this.health = 100.00;
        this.mana = 100.00;
    }
    
    protected Servent(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.health = 100.00;
        this.mana = 100.00;
    }
    
    protected Servent(String name, Integer age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.health = 100.00;
        this.mana = 100.00;
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

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Double getMana() {
        return mana;
    }

    public void setMana(Double mana) {
        this.mana = mana;
    }

    public List<NoblePhantasm> getNps() {
        return nps;
    }

    public void setNps(List<NoblePhantasm> nps) {
        this.nps = nps;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected abstract void attack();
}
