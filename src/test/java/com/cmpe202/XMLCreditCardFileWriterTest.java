package com.cmpe202;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class XMLCreditCardFileWriterTest {

    private static Path workingDir = Path.of("", "src/test/resources");

    @AfterEach
    void tearDown() {
        Path file = this.workingDir.resolve("output.xml");
        try {
            Files.deleteIfExists(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void emptyFileNameWrite() {
        CSVCreditCardFileWriter w = new CSVCreditCardFileWriter("");
        w.write(new ArrayList<>());
    }

    @Test
    void validFileNameWrite() {
        Path file = this.workingDir.resolve("output.xml");
        XMLCreditCardFileWriter w = new XMLCreditCardFileWriter(file.toString());
        List<CreditCard> cards = new ArrayList<>();
        cards.add(new CreditCard("2334", "07/27", "Adam"));
        w.write(cards);
        assertThat(Files.exists(file), is(true));
        List<String> res = readLineByLine(file.toString());
        assertThat(res.size(), is(4));
        assertThat(res.get(0), is("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
        assertThat(res.get(1), is("<root>"));
        assertThat(res.get(2), is("\t<row CardNumber=\"2334\" CardType=\"INVALID\" Error=\"InvalidCardNumber\"></row>"));
        assertThat(res.get(3), is("</root>"));
    }


    private static List<String> readLineByLine(String filePath) {
        List<String> result = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> result.add(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}