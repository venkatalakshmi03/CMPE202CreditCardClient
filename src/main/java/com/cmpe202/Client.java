package com.cmpe202;

public class Client {
    public static void main(String args[]) {
        try {
            CreditCardFileOperator cfo = new CreditCardFileOperator();

            //Read input file name
            String inputFilename = args[0];

            //Read the output file name
            String outputFilename = args[1];

            cfo.operate(inputFilename, outputFilename);
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }
}
