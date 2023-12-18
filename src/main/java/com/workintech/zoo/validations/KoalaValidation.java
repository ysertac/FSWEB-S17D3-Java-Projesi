package com.workintech.zoo.validations;

import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

public class KoalaValidation {
    public static void isIdValid(Integer id) {
        if (id == null || id <= 0) {
            throw new ZooException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }
}
