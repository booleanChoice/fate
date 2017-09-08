package com.example.fate.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fate.entry.master.Master;
import com.example.fate.entry.servent.Archer;
import com.example.fate.entry.servent.Saber;
import com.example.fate.entry.servent.Servent;

@Service
public class TestService {
    public List<Servent> summonServents(Master master) {
        if (master == null)
            return null;
        master.spell("I am " + master.getName() + ", I summon you to be my Servent !");
        Saber saber = new Saber();
        saber.setName("Arturia Pendragon");
        Archer archer = new Archer();
        archer.setName("EMIYA");
        List<Servent> res = Arrays.asList(saber, archer);
        return res;
    }
}
