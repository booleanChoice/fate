package com.example.fate.entry.servent;

public class NoblePhantasm {
    enum Level {
        EX, AP, APP, A, B, C, D, E
    }
    
    private String name;
    private Level leve;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Level getLeve() {
        return leve;
    }
    public void setLeve(Level leve) {
        this.leve = leve;
    }
}
