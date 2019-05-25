package ru.ravilova.employeedb.util;

import org.springframework.stereotype.Component;


@Component
public class MakerImpl implements SignMaker {
    @Override
    public String make(String id) {
        //TODO implementation
        return "sign" + id;
    }
}
