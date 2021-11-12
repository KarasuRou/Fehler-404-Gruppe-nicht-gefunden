package main;

import java.util.Scanner;

public class Fehler_404_Gruppe_Nicht_gefunden {

    private static final double CONSUMER_VAT = 0.19, BASIC_VAT = 0.07;
    private static int products = 0;
    private static double basicVatPrice = 0, consumerVatPrice = 0;

    public static void main(String[] args){
        double productSum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie viele Produkte werden angegeben?\r\n> ");
        int productCount = scanner.nextInt();
        System.out.println("\r\n");
        for (int i = 0; i < productCount; i++) {
            productSum += getProductPrice(scanner);
        }

        scanner.close();

        outputSumAndMWS(productSum);
    }
    private static double getProductPrice(Scanner scanner) {
        double temporarilyProduct;
        if (productIsBasicProduct(scanner)) {
            temporarilyProduct = getBasicProduct(scanner);
            basicVatPrice += getBasicVat(temporarilyProduct);
        } else {
            temporarilyProduct = getConsumerProduct(scanner);
            consumerVatPrice += getConsumerVat(temporarilyProduct);
            System.out.println(consumerVatPrice);
        }
        System.out.println();
        return temporarilyProduct;
    }

    private static double getConsumerVat(double product) {
        return product * CONSUMER_VAT;
    }

    private static double getBasicVat(double product) {
        return product * BASIC_VAT;
    }

    private static double getConsumerProduct(Scanner scanner) {
        System.out.println("Bitte geben Sie den Werte des Konsumgüterprodukts im folgenden Format ein (5,5 oder 4):");
        System.out.printf("%d Produkt > ", products);
        return scanner.nextDouble();
    }

    private static double getBasicProduct(Scanner scanner) {
        System.out.println("Bitte geben Sie den Werte des Grundbedarfsprodukts im folgenden Format ein (5,5 oder 4):");
        System.out.printf("%d Produkt > ", products);
        return scanner.nextDouble();
    }

    private static boolean productIsBasicProduct(Scanner scanner) {
        System.out.printf("Ist das %d Produkt ein:\r\n1: Grundbedarfsprodukt\r\n2: Konsumgüterprodukt\r\n> ", ++products);
        String choice = scanner.next();
        System.out.println(choice);
        return choice.contains("1") ||
                (choice.contains("Grund") || choice.contains("grund")) ||
                choice.contains("bedarf");
    }

    private static void outputSumAndMWS(double sumOfProduct) {
        System.out.printf("\r\n\r\nSumme: %.2f EUR\r\n" +
                "Anteil Mehrwertsteuer (Grundbedarf %d%%): %.2f EUR\r\n" +
                "Anteil Mehrwertsteuer (Konsumgüter %d%%): %.2f EUR\r\n" +
                "Anzahl der Produkte: %d", sumOfProduct, ((int) (BASIC_VAT * 100)), basicVatPrice, ((int) (CONSUMER_VAT * 100)), consumerVatPrice, products);
    }
}
