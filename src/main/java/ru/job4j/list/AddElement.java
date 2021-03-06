package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikha
 * @version 1.0
 * Продолжим знакомство с методами, которые можно использовать со списками. Чтобы определить размер списка используется метод size()
 * (он определен в интерфейсе Collection<E>, наследником которого является интерфейс List<E>).
 *
 * int size() - метод возвращает целочисленное значение, и говорит нам о том, сколько элементов находится в списке.
 *
 * Чтобы добавить элемент в список - используется метод add (который также определен в интерфейсе Collection<E>):
 *
 * boolean add(E e) - метод возвращает булево значение, true - если добавление произошло успешно, false - добавление не удалось.
 *
 * Задание: необходимо реализовать метод, который добавляет элемент в список и сообщает нам удалось это или нет, т.е. метод должен вернуть
 * булево значение. Не используйте в методе то, что метод возвращает true или false. Для этого на входе в метод мы копируем список в новый список,
 * добавляем в тот список, который пришел в методе и в конце сравниваем их размеры - если изменился, значит элемент добавился.
 */
public class AddElement {
    /**
     *
     * @param list - список элементов
     * @param str - элемент по которому будем сравнивать список добавления
     * @return - возвращаем результат
     */
    public static boolean AddNewElement(List<String> list, String str) {
        boolean rsl = false;
        List<String> check = new ArrayList<>(list);
        check.add(str);
        if (check.size() != 0) {
            rsl = true;
        }
        return rsl;
    }
}
