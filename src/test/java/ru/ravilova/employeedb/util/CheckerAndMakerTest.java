package ru.ravilova.employeedb.util;

import org.junit.Test;
import ru.ravilova.employeedb.dto.SignIdDto;

import java.util.UUID;

import static org.junit.Assert.*;

public class CheckerAndMakerTest {

    private SignMaker signMaker = new MakerImpl();
    private SignChecker signChecker = new CheckerImpl();

    @Test
    public void checkMadeSignIsTrue(){
        String id = UUID.randomUUID().toString();
        String signature = signMaker.make(id);
        SignIdDto signIdDto = new SignIdDto(id, signature);
        assertTrue(signChecker.check(signIdDto));
    }

    @Test
    public void checkMadeAndEditedSignIsFalse(){
        String id = UUID.randomUUID().toString();
        StringBuilder signBuilder = new StringBuilder(signMaker.make(id));
        signBuilder.setCharAt(signBuilder.length()/2, (char) (signBuilder.charAt(signBuilder.length()/2)+1));
        SignIdDto signIdDto = new SignIdDto(id, signBuilder.toString());
        assertFalse(signChecker.check(signIdDto));
    }

    @Test
    public void checkMadeSignAndEditedIdIsFalse(){
        String id = UUID.randomUUID().toString();
        String signature = signMaker.make(id);
        StringBuilder idBuilder = new StringBuilder(id);
        idBuilder.setCharAt(idBuilder.length()/2, (char) (idBuilder.charAt(idBuilder.length()/2)+1));
        SignIdDto signIdDto = new SignIdDto(idBuilder.toString(), signature);
        assertFalse(signChecker.check(signIdDto));
    }

    public void signIsNotEqualsToId(){
        String id = UUID.randomUUID().toString();
        String signature = signMaker.make(id);
        assertFalse(id.equals(signature));
    }

}