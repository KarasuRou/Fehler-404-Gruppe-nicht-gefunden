package main;

import java.util.Scanner;

public class Launcher {

    private final static double mws = 0.18;
    private final static double[] products = new double[5];

    public static void main(String[] args){
        double sumOfProduct, mwsAmount;

        System.out.println("Bitte geben Sie 5 Werte im Folgenden Format ein (5,5):");
        Scanner scanner = new Scanner(System.in);

        getProducts(scanner);
        scanner.close();

        sumOfProduct = calculateSum();
        mwsAmount = calculateMWS(sumOfProduct);

        outputSumAndMWS(sumOfProduct, mwsAmount);
    }

    private static void getProducts(Scanner scanner) {
        for (int i = 0; i < products.length; i++) {
            System.out.print((i + 1) + " Produkt > ");
            products[i] = scanner.nextDouble();
        }
    }

    private static double calculateSum() {
        double result = 0;
        for (double product : products) {
            result += product;
        }
        return result;
    }

    private static double calculateMWS(double sumOfProduct) {
        return (sumOfProduct * mws);
    }

    private static void outputSumAndMWS(double sumOfProduct, double mwsAmount) {
        System.out.printf("\r\n\r\nSumme: %.2f EUR\r\n" +
                "Anteil Mehrwertsteuer: %.2f EUR\r\n" +
                "Anzahl der Produkte: 5", sumOfProduct, mwsAmount);
    }
}
