package ru.ravilova.employeedb.util;

import ru.ravilova.employeedb.dto.SignIdDto;

public interface SignChecker {

    boolean check(SignIdDto signIdDto);

}
