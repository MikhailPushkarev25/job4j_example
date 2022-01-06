package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(4);

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private AccidentMem() {
        accidents.put(1, new Accident(1, "Mikhail", "Превысил скорость", "Пр-кт Ленина дом 4"));
        accidents.put(2, new Accident(2, "Roman", "Не пропустил пешехода", "г.Нижний Новгород, ул. Бурденко д3"));
        accidents.put(3, new Accident(
                3, "Ksenia", "Проехала на красный свет", "г.Нижний Новгород, ул.Адмирала Макакрова д4"));
        accidents.put(4, new Accident(
                4, "Nikolay", "Осуществил наезд на стоп линию", "г.Нижний Новгород, ул.Голубева д 10"));
    }

    public Collection<Accident> findAllAccident() {
        return accidents.values();
    }

    public void saveAccident(Accident accident) {
        accident.setId(ACCIDENT_ID.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }
}
