package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccidentMem {

    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(4);
    private static final AtomicInteger TYPE_ID = new AtomicInteger(4);
    private static final AtomicInteger RULE_ID = new AtomicInteger(4);

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final Map<Integer, AccidentType> types = new ConcurrentHashMap<>();
    private final Map<Integer, Rule> ruleSet = new ConcurrentHashMap<>();

    private AccidentMem() {
        AccidentType type = AccidentType.of("Две машины");
        AccidentType type1 = AccidentType.of("Машина и человек");
        AccidentType type2 = AccidentType.of("Машина и велосипед");
        AccidentType type3 = AccidentType.of("Машина и пешеход");

        Set<Rule> rules = Set.of(Rule.of("list 1"));
        Set<Rule> rules1 = Set.of(Rule.of("list 2"));
        Set<Rule> rules2 = Set.of(Rule.of("list 3"));
        Set<Rule> rules3 = Set.of(Rule.of("list 4"));

        accidents.put(1, new Accident(1, "Mikhail", "Превысил скорость", "Пр-кт Ленина дом 4", type, rules));
        accidents.put(2, new Accident(2, "Roman", "Не пропустил пешехода", "г.Нижний Новгород, ул. Бурденко д3", type1, rules1));
        accidents.put(3, new Accident(3,
                "Ksenia", "Проехала на красный свет", "г.Нижний Новгород, ул.Адмирала Макакрова д4", type2, rules2));
        accidents.put(4, new Accident(4,
               "Nikolay", "Осуществил наезд на стоп линию", "г.Нижний Новгород, ул.Голубева д 10", type3, rules3));

        types.put(1, AccidentType.of("Две машины"));
        types.put(2, AccidentType.of("Машина и человек"));
        types.put(3, AccidentType.of("Машина и велосипед"));
        types.put(4, AccidentType.of("Машина и пешеход"));

        ruleSet.put(1, Rule.of("list 1"));
        ruleSet.put(2, Rule.of("list 2"));
        ruleSet.put(3, Rule.of("list 3"));
        ruleSet.put(4, Rule.of("list 4"));
    }

    public Collection<Accident> findAllAccident() {
        return accidents.values();
    }

    public Collection<AccidentType> findAllAccidentType() {
        return types.values();
    }

    public Collection<Rule> findAllRule() {
        return ruleSet.values();
    }

    public void saveAccident(Accident accident) {
        accident.setId(ACCIDENT_ID.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public void saveType(AccidentType accidentType) {
        accidentType.setId(TYPE_ID.incrementAndGet());
        types.put(accidentType.getId(), accidentType);
    }

    public void saveRule(Rule rule) {
        rule.setId(RULE_ID.incrementAndGet());
        ruleSet.put(rule.getId(), rule);
    }

   public Accident findById(int id) {
        return accidents.get(id);
   }

   public AccidentType findBiIdAccidentType(int id) {
        return types.get(id);
   }

   public Rule findByIdRule(int id) {
        return ruleSet.get(id);
   }
}
