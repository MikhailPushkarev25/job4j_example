package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartUI {

    @Autowired
    private Store store;
//    private ConsoleInput input;
//
//    public StartUI(ConsoleInput input) {
//        this.input = input;
//    }


    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String str : store.getAll()) {
            System.out.println(str);
        }
    }

//    public void scan(String info) {
//        input.askStr(info);
//    }
}
