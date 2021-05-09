package com.cmpe202;


import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.util.List;

public class XMLCreditCardFileWriter extends CreditCardFileWriter {
    public XMLCreditCardFileWriter(String fileName) {
        super(fileName);
        factory = XMLOutputFactory.newInstance();
        eventFactory = XMLEventFactory.newInstance();
    }

    @Override
    public void write(List<CreditCard> cards) {
        Characters newLine = eventFactory.createCharacters("\n");
        Characters tab = eventFactory.createCharacters("\t");
        XMLEventWriter writer = null;
        if (fw == null) return;
        try {
            writer = factory.createXMLEventWriter(fw);
            XMLEvent event = eventFactory.createStartDocument();
            writer.add(event);
            writer.add(newLine);
            writer.flush();
            event = eventFactory.createStartElement("", "", "root");
            writer.add(event);
            writer.add(newLine);
            writer.flush();
            for (CreditCard c : cards) {
                writer.add(tab);
                event = eventFactory.createStartElement(
                        "", "", "row");
                writer.add(event);
                event = eventFactory.createAttribute
                        ("CardNumber", c.getCardNumber());
                writer.add(event);
                event = eventFactory.createAttribute
                        ("CardType", c.getCardType().name());
                writer.add(event);
                event = eventFactory.createAttribute
                        ("Error", c.getCardType() != CreditCardType.INVALID ? "None" : "InvalidCardNumber");
                writer.add(event);
                event = eventFactory.createEndElement(
                        "", "", "row");
                writer.add(event);
                writer.add(newLine);
                writer.flush();
            }
            event = eventFactory.createEndElement("", "", "root");
            writer.add(event);
            writer.add(newLine);
            writer.flush();
            writer.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private XMLOutputFactory factory;
    private XMLEventFactory eventFactory;
}
