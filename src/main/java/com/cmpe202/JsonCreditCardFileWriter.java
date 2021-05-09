package com.cmpe202;

import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.List;

public class JsonCreditCardFileWriter extends CreditCardFileWriter {
    public JsonCreditCardFileWriter(String fileName) {
        super(fileName);
        if (fw != null) {
            writer = new JsonWriter(fw);
            writer.setIndent("\t");
        }
    }

    @Override
    public void write(List<CreditCard> cards) {
        try {
            writer.beginArray();
            for (CreditCard c : cards) {
                writer.beginObject();
                writer.name("CardNumber").value(c.getCardNumber());
                writer.name("CardType").value(c.getCardType().name());
                writer.name("Error").value(c.getCardType() != CreditCardType.INVALID ? "None" : "InvalidCardNumber");
                writer.endObject();
            }
            writer.endArray();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JsonWriter writer;
}
