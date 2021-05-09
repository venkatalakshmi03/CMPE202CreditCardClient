package com.cmpe202;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class XMLCreditCardFileReaderTest {
    private static Path workingDir = Path.of("", "src/test/resources");


    @Test
    void emptyFileNameRead() {
        XMLCreditCardFileReader r = new XMLCreditCardFileReader("");
        List<Record> records = readRecords(r);
        assertThat(records.size(), is(0));
    }

    @Test
    void validFileNameRead() {
        Path file = this.workingDir.resolve("sample.xml");
        XMLCreditCardFileReader r = new XMLCreditCardFileReader(file.toString());
        List<Record> records = readRecords(r);
        assertThat(records.size(), is(4));
        assertThat(records.get(0).getCardNumber(), is("541000000000000000"));
        assertThat(records.get(0).getExpirationDate(), is("3/20/2030"));
        assertThat(records.get(0).getNameOfCardholder(), is("Alice"));
    }

    private static List<Record> readRecords(XMLCreditCardFileReader r) {
        List<Record> records = new ArrayList<>();
        while (r.hasNext()) {
            Record rd = r.next();
            if (rd != null) {
                records.add(rd);
            }
        }
        return records;
    }

}