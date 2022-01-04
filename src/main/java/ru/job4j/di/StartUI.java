package ru.job4j.di;

public class StartUI {

    private Store store;
    private ConsoleInput input;

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void add(String value, String info) {
        store.add(value);
        input.askStr(info);
    }

    public void print() {
        for (String str : store.getAll()) {
            System.out.println(str);
        }
    }
}
