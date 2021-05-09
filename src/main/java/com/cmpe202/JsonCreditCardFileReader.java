package com.cmpe202;

import com.google.gson.stream.JsonReader;

import java.io.IOException;

public class JsonCreditCardFileReader extends CreditCardFileReader {
    public JsonCreditCardFileReader(String fileName) {
        super(fileName);
        if (fileReader != null) {
            reader = new JsonReader(fileReader);
            try {
                reader.beginArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    Record next() {
        RecordBuilder rb = new RecordBuilder();
        try {
            reader.beginObject();
            while (hasNext()) {
                switch (reader.nextName()) {
                    case "CardNumber":
                        rb.setCardNumber(String.valueOf(reader.nextLong()));
                        break;
                    case "ExpirationDate":
                        rb.setExpirationDate(String.valueOf(reader.nextString()));
                        break;
                    case "NameOfCardholder":
                        rb.setNameOfCardholder(String.valueOf(reader.nextString()));
                        break;
                    default:
                        reader.skipValue();
                }
            }
            reader.endObject();
            return rb.createRecord();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    boolean hasNext() {
        if (reader == null) return false;
        try {
            return reader.hasNext();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private JsonReader reader;
}
