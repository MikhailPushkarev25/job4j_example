package ru.job4j.di;

import org.springframework.stereotype.Component;

@Component
public class StartUI {

    private Store store;
//    private ConsoleInput input;
//
//    public StartUI(ConsoleInput input) {
//        this.input = input;
//    }

    public StartUI(Store store) {
        this.store = store;
    }

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
