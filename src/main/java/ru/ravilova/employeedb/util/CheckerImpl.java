package ru.ravilova.employeedb.util;

import org.springframework.stereotype.Component;
import ru.ravilova.employeedb.dto.SignIdDto;

@Component
public class CheckerImpl implements SignChecker {
    @Override
    public boolean check(SignIdDto signIdDto) {
        //TODO implementation
        return true;
    }
}
