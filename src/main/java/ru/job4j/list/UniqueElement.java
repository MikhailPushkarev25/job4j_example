package ru.job4j.list;

import java.util.List;

/**
 * @author mikha
 * @version 1.0
 * Рассмотрим очень интересные методы, которые позволяют найти индекс определенного элемента. Первый метод indexOf(E e):
 *
 *  int indexOf(E e) - метод возвращает индекс элемента E при его первом вхождении в список. Если элемент не найден - метод возвращает -1.
 *
 * Что же делать если мы хотим найти индекс элемента при его последнем вхождении (т.е. у нас в коллекции есть дубликаты)?
 * Нет никаких проблем, можно использовать lastIndexOf(E e):
 *
 * int lastIndexOf(E e) - метод возвращает индекс элемента E при его последнем вхождении в список. Если элемент не найден - метод возвращает -1.
 *
 * Необходимо указать, что эти методы реализованы с помощью цикла for(), поэтому применять эти методы внутри циклов, которые перебирают список,
 * нежелательно, поскольку так мы будем проходить по одному и тому же списку дважды.
 *
 * Задание: метод принимает список и элемент который мы ищем в списке. Необходимо определить, является ли этот элемент уникальным в этом списке.
 * Для это необходимо найти первый и последний индекс вхождения элемента. Если равны - значит элемент уникальный. Необходимо предусмотреть ситуацию,
 * что такого элемента нет вообще в коллекции, в этом случае также нужно вернуть false.
 */
public class UniqueElement {
    /**
     *
     * @param list - список элементов
     * @param str - элемент
     * @return - возврат
     */
    public static boolean checkList(List<String> list, String str) {
        boolean rsl = false;
        int result = list.indexOf(str);
        int last = list.lastIndexOf(str);
        if (result != -1 && last == result) {
            list.add(str);
            rsl = true;
        }
        return rsl;
    }
}
