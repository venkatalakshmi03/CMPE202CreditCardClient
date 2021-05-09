package com.cmpe202;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.util.List;

public class CSVCreditCardFileWriter extends CreditCardFileWriter {
    public CSVCreditCardFileWriter(String fileName) {
        super(fileName);
        if (fw != null) writer = new CSVWriter(fw);
    }

    @Override
    public void write(List<CreditCard> cards) {
        String[] header = new String[]{"CardNumber,CardType,Error"};
        writer.writeNext(header);
        for(CreditCard c: cards) {
            writer.writeNext(serializeCard(c));
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String[] serializeCard(CreditCard card) {
        String[] res = new String[3];
        res[0] = card.getCardNumber();
        res[1] = card.getCardType().name();
        res[2] = card.getCardType() != CreditCardType.INVALID ? "None" : "InvalidCardNumber";
        return res;
    }

    private CSVWriter writer;

}
