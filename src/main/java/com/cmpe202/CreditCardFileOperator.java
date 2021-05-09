package com.cmpe202;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class CreditCardFileOperator {

    void operate(String inputFileName, String outputFileName) {
        CreditCardFileReader reader = null;
        CreditCardFileWriter writer = null;
        Optional<String> inputExtension = getExtension(inputFileName);
        if (inputExtension.isPresent()) {
            switch (inputExtension.get().toLowerCase(Locale.ROOT)) {
                case "csv":
                    reader = new CSVCreditCardFileReader(inputFileName);
                    break;
                case "json":
                    reader = new JsonCreditCardFileReader(inputFileName);
                    break;
                case "xml":
                    reader = new XMLCreditCardFileReader(inputFileName);
                    break;
            }
        }
        Optional<String> outputExtension = getExtension(outputFileName);
        String outFileExtn = outputExtension.isPresent() ? outputExtension.get().toLowerCase(Locale.ROOT) : "";
        if (!(outFileExtn.equals("csv") || outFileExtn.equals("json") || outFileExtn.equals("xml"))) {
            outFileExtn = inputExtension.isPresent() ? inputExtension.get().toLowerCase(Locale.ROOT) : "";
        }
        switch (outFileExtn) {
            case "csv":
                writer = new CSVCreditCardFileWriter(outputFileName);
                break;
            case "json":
                writer = new JsonCreditCardFileWriter(outputFileName);
                break;
            case "xml":
                writer = new XMLCreditCardFileWriter(outputFileName);
                break;
        }
        if (reader != null && writer != null) {
            List<CreditCard> cards = new ArrayList<>();
            CreditCardFactoryImpl creditCardFactory = new CreditCardFactoryImpl();
            while (reader.hasNext()) {
                Record r = reader.next();
                if (r != null) {
                    cards.add(creditCardFactory.create(r));
                }
            }
            writer.write(cards);
        }
    }


    private Optional<String> getExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }


}
