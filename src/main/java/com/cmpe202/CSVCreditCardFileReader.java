package com.cmpe202;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class CSVCreditCardFileReader extends CreditCardFileReader {

    public CSVCreditCardFileReader(String fileName) {
        super(fileName);
        if (fileReader != null) {
            reader = new CSVReaderBuilder(fileReader).
                    withCSVParser(new CSVParserBuilder().withSeparator('\t').build()).build();
            if (hasNext()) {
                try {
                    reader.readNext();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CsvValidationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    Record next() {
        try {
            String[] read = reader.readNext();
            if (read.length != 3 || read[0].isBlank() || !Character.isDigit(read[0].charAt(0))) {
                return null;
            }
            return new RecordBuilder().setCardNumber(read[0].trim()).setExpirationDate(read[1].trim()).setNameOfCardholder(read[2].trim()).createRecord();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    boolean hasNext() {
        try {
            return reader.peek() != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private CSVReader reader;
}
