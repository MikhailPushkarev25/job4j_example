package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccidentService {

    private AccidentMem mem;

    public AccidentService(AccidentMem mem) {
        this.mem = mem;
    }

    public Collection<Accident> findAllAccident() {
        return mem.findAllAccident();
    }

    public Collection<AccidentType> findAllAccidentType() {
        return mem.findAllAccidentType();
    }

    public Collection<Rule> findAllRule() {
        return mem.findAllRule();
    }

    public void saveAccident(Accident accident, String[] str) {
        accident.setType(findByIdAccidentType(accident.getType().getId()));
        Set<Rule> rules = new HashSet<>();
        for (String line : str) {
            rules.add(findByIdRule(Integer.parseInt(line)));
        }
        accident.setRules(rules);
        mem.saveAccident(accident);
    }

    public void saveAccidentType(AccidentType accidentType) {
        mem.saveType(accidentType);
    }

    public void saveRules(Rule rule) {
        mem.saveRule(rule);
    }

    public Accident findById(int id) {
        return mem.findById(id);
    }

    public AccidentType findByIdAccidentType(int id) {
        return mem.findBiIdAccidentType(id);
    }

    public Rule findByIdRule(int id) {
        return mem.findByIdRule(id);
    }
}
