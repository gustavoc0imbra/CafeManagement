package org.meucafe.facades;

import org.meucafe.Order;

import java.io.*;

public class OrderInvoiceGenerator {
    private static BufferedWriter writer;

    public static void generateInvoice(Order order) {
        try {
            File outputFile = new File("invoice"+order.hashCode()+".txt");
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(order.formattedOutput());
            writer.close();
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
