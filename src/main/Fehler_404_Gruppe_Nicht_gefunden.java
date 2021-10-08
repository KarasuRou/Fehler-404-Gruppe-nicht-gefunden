package main;

import java.util.Scanner;

public class Fehler_404_Gruppe_Nicht_gefunden {

    public static void main(String[] args){
        double sumOfProduct, mwsAmount, mws = 0.19;

        System.out.println("Bitte geben Sie 5 Werte im Folgenden Format ein (5,5):");
        Scanner scanner = new Scanner(System.in);

        sumOfProduct = getProductPrice(
                scanner
        );
        scanner.close();


        mwsAmount = calculateMWS(sumOfProduct, mws);

        outputSumAndMWS(sumOfProduct, mwsAmount);
    }

    private static double getProductPrice(Scanner scanner) {
        System.out.print("1 Produkt > ");
        double firstProduct = scanner.nextDouble();
        System.out.print("2 Produkt > ");
        double secondProduct = scanner.nextDouble();
        System.out.print("3 Produkt > ");
        double thirdProduct = scanner.nextDouble();
        System.out.print("4 Produkt > ");
        double fourthProduct = scanner.nextDouble();
        System.out.print("5 Produkt > ");
        double fifthProduct = scanner.nextDouble();
        return calculateSum(firstProduct, secondProduct, thirdProduct, fourthProduct, fifthProduct);
    }

    private static double calculateSum(double firstProduct, double secondProduct, double thirdProduct, double fourthProduct, double fifthProduct) {
        return firstProduct + secondProduct + thirdProduct + fourthProduct + fifthProduct;
    }

    private static double calculateMWS(double sumOfProduct, double mws) {
        return (sumOfProduct * mws);
    }

    private static void outputSumAndMWS(double sumOfProduct, double mwsAmount) {
        System.out.printf("\r\n\r\nSumme: %.2f EUR\r\n" +
                "Anteil Mehrwertsteuer: %.2f EUR\r\n" +
                "Anzahl der Produkte: 5", sumOfProduct, mwsAmount);
    }
}
