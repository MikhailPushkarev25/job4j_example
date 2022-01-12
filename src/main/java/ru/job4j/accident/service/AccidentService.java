package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccidentService {

    private final AccidentRepository acc;
    private final AccidentTypeRepository accType;
    private final RuleRepository rule;

    public AccidentService(AccidentRepository acc,
                           AccidentTypeRepository accType,
                           RuleRepository rule) {
        this.acc = acc;
        this.accType = accType;
        this.rule = rule;
    }

    @Transactional
    public Collection<Accident> findAllAccident() {
        return (Collection<Accident>) acc.findAll();
    }

    @Transactional
    public Collection<AccidentType> findAllAccidentType() {
        return (Collection<AccidentType>) accType.findAll();
    }

    @Transactional
    public Collection<Rule> findAllRule() {
        return (Collection<Rule>) rule.findAll();
    }

    @Transactional
    public void saveAccident(Accident accident, String[] str) {
        if (str != null) {
            Set<Rule> rules = new HashSet<>();
            for (String id : str) {
                rules.add(findByIdRule(Integer.parseInt(id)));
            }
            accident.setRules(rules);
        }
        acc.save(accident);
    }

    @Transactional
    public Accident findById(int id) {
        return acc.findAccidentById(id);
    }

    @Transactional
    public AccidentType findByIdType(int id) {
        return accType.findById(id).orElse(null);
    }

    @Transactional
    public Rule findByIdRule(int id) {
        return rule.findById(id).orElse(null);
    }
}
