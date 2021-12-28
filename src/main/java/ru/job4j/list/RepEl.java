package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class RepEl {

    public static List<String> changePosition(List<String> list, int index) {
        String res = list.remove(list.size() - 1);
        if (list.size() >= index) {
            list.set(index, res);
        }
        return list;
    }
}
