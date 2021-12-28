package ru.job4j.list;

import java.util.List;

/**
 * @author mikha
 * @version 1.0
 * @since 19.12.2021
 *
 * Продолжим модифицировать список, познакомимся с методами для удаления элементов в списке и замены элемента по индексу.
 * Для этого предназначены методы set() и remove():
 *
 * E remove(int index) - удаляет элемент из списка по индексу index, при этом метод возвращает удаленный элемент.
 *
 * E set(int index, E e) - заменяет значение элемента, который имеет индекс index, значением e.
 * При этом метод возвращает старое значение элемента с индексом index.
 *
 * Задание:  метод принимает в качестве параметров список и индекс элемента который необходимо заменить.
 * необходимо дописать метод так, чтобы сначала удалялся последний элемент в списке, а потом этим элементом
 * заменить элемент по индексу, который пришел в параметрах метода. Необходимо учесть, что извне могут передать индекс,
 * который превышает значение размера списка. Чтобы этого избежать - необходимо добавить проверку валидности входных параметров.
 *
 */
public class RepositionElement {
    /**
     *
     * @param list - список
     * @param index - индекс
     * @return - возврат результата
     */
    public static List<String> changePosition(List<String> list, int index) {
        String check = list.remove(list.size() - 1);
        if (index <= list.size()) {
            list.set(index, check);
        }

        return list;
    }
}