package com.cmpe202;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLCreditCardFileReader extends CreditCardFileReader {
    public XMLCreditCardFileReader(String fileName) {
        super(fileName);
        xmlInputFactory = XMLInputFactory.newInstance();
        try {
            reader = xmlInputFactory.createXMLEventReader(fileReader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    @Override
    Record next() {
        try {
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                RecordBuilder r = new RecordBuilder();
                if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("row")) {
                    while (reader.hasNext()) {
                        event = reader.nextEvent();
                        if (event.isStartElement()) {
                            StartElement startElement = event.asStartElement();
                            switch (startElement.getName().getLocalPart()) {
                                case "CardNumber":
                                    event = reader.nextEvent();
                                    r.setCardNumber(event.asCharacters().getData());
                                    break;
                                case "ExpirationDate":
                                    event = reader.nextEvent();
                                    r.setExpirationDate(event.asCharacters().getData());
                                    break;
                                case "NameOfCardholder":
                                    event = reader.nextEvent();
                                    r.setNameOfCardholder(event.asCharacters().getData());
                                    return r.createRecord();
                            }
                        }
                    }
                }
            }
            return null;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    boolean hasNext() {
        return reader.hasNext();
    }


    private XMLInputFactory xmlInputFactory;
    private XMLEventReader reader;
}
