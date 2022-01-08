package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(4);
    private static final AtomicInteger TYPE_ID = new AtomicInteger(4);

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final Map<Integer, AccidentType> types = new ConcurrentHashMap<>();

    private AccidentMem() {
        AccidentType type = AccidentType.of(1, "Две машины");
        AccidentType type1 = AccidentType.of(2, "Машина и человек");
        AccidentType type2 = AccidentType.of(3, "Машина и велосипед");
        AccidentType type3 = AccidentType.of(4, "Машина и пешеход");

        accidents.put(1, new Accident(1, "Mikhail", "Превысил скорость", "Пр-кт Ленина дом 4", type));
        accidents.put(2, new Accident(2, "Roman", "Не пропустил пешехода", "г.Нижний Новгород, ул. Бурденко д3", type1));
        accidents.put(3, new Accident(
                3, "Ksenia", "Проехала на красный свет", "г.Нижний Новгород, ул.Адмирала Макакрова д4", type2));
        accidents.put(4, new Accident(
                4, "Nikolay", "Осуществил наезд на стоп линию", "г.Нижний Новгород, ул.Голубева д 10", type3));

        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
        types.put(4, AccidentType.of(4, "Машина и пешеход"));
    }

    public Collection<Accident> findAllAccident() {
        return accidents.values();
    }

    public Collection<AccidentType> findAllAccidentType() {
        return types.values();
    }

    public void saveAccident(Accident accident) {
        accident.setId(ACCIDENT_ID.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public void saveType(AccidentType accidentType) {
        accidentType.setId(TYPE_ID.incrementAndGet());
        types.put(accidentType.getId(), accidentType);
    }

   public Accident findById(int id) {
        return accidents.get(id);
   }

   public AccidentType findBiIdAccidentType(int id) {
        return types.get(id);
   }
}
