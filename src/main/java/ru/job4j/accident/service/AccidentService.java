package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;

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

    public void saveAccident(Accident accident) {
        accident.setType(findByIdAccidentType(accident.getType().getId()));
        mem.saveAccident(accident);
    }

    public void saveAccidentType(AccidentType accidentType) {
        mem.saveType(accidentType);
    }

    public Accident findById(int id) {
        return mem.findById(id);
    }

    public AccidentType findByIdAccidentType(int id) {
        return mem.findBiIdAccidentType(id);
    }
}
