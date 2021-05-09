package com.cmpe202;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

abstract class CreditCardFileWriter {

    public CreditCardFileWriter(String fileName) {
        this.fileName = fileName;
        try {
            fw = new FileWriter(fileName);
        } catch(FileNotFoundException e) {

        } catch (IOException e) {
        }
    }

    abstract void write(List<CreditCard> cards);

    protected String fileName;
    protected FileWriter fw;

}
