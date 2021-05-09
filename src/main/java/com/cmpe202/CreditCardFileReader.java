package com.cmpe202;

import java.io.FileNotFoundException;
import java.io.FileReader;

abstract class CreditCardFileReader {

    public CreditCardFileReader(String fileName) {
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
        }
    }

    Record next() {
        return null;
    }

    boolean hasNext() {
        return false;
    }

    protected FileReader fileReader;
}
