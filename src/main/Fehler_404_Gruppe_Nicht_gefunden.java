package main;

import Material_211210.Bildbearbeitung;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Fehler_404_Gruppe_Nicht_gefunden {

    private static final double CONSUMER_VAT = 0.19, BASIC_VAT = 0.07;
    private static int products = 0;
    private static double basicVatPrice = 0, consumerVatPrice = 0;

    public static void main(String[] args){
//       startKassenProgramm();
        Bildbearbeitung bildbearbeitung = new Bildbearbeitung();
        bildbearbeitung.kopiere();
        System.exit(0);

    }

    private static void startKassenProgramm() {
        double productSum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Das Programm mit einem ENTER beenden.\r\n");

        try {
            do {
                productSum += getProductPrice(scanner);
            } while (true);
        } catch (Exception ignored) {}
        finally {products--;}

        scanner.close();

        outputSumAndMWS(productSum);
    }

    private static double getProductPrice(Scanner scanner) throws Exception {
        double temporarilyProduct;
        if (productIsBasicProduct(scanner)) {
            System.out.println("Bitte geben Sie den Werte des Grundbedarfsprodukts im folgenden Format ein (5.5 oder 4):");
            temporarilyProduct = getProduct(scanner);
            basicVatPrice += getBasicVat(temporarilyProduct);
        } else {
            System.out.println("Bitte geben Sie den Werte des Konsumgüterprodukts im folgenden Format ein (5.5 oder 4):");
            temporarilyProduct = getProduct(scanner);
            consumerVatPrice += getConsumerVat(temporarilyProduct);
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

    private static double getProduct(Scanner scanner) throws Exception {
        System.out.printf("%d Produkt > ", products);
        String product;
        if (!(product = scanner.nextLine()).equals("")) {
            if (Pattern.matches("[a-zA-Z]", product)) {
                System.err.println("Die Eingabe war fehlerhaft!!\r\n");
                products--;
                return 0;
            } else {
                return Double.parseDouble(product);
            }
        } else {
            throw new Exception("ENDE");
        }
    }

    private static boolean productIsBasicProduct(Scanner scanner) throws Exception {
        System.out.printf("Ist das %d Produkt ein:\r\n1: Grundbedarfsprodukt\r\n2: Konsumgüterprodukt\r\n> ", ++products);
        String choice = scanner.nextLine();
        if (choice.equals("")) {
            throw new Exception("ENDE");
        }
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
