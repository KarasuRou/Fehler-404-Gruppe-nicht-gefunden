package main;

import java.util.Scanner;

public class Launcher {

    final static double mws = 0.18; // percent

    public static void main(String[] args){
        double firstProduct, secondProduct, thirdProduct, fourthProduct, fifthProduct, sumOfProduct, mwsAmount;

        System.out.println("Bitte geben sie 5 Werte im Folgenden Format ein (5,5):");
        Scanner scanner = new Scanner(System.in);

        System.out.print("1 Produkt > ");
        firstProduct = scanner.nextDouble();
        System.out.print("2 Produkt > ");
        secondProduct = scanner.nextDouble();
        System.out.print("3 Produkt > ");
        thirdProduct = scanner.nextDouble();
        System.out.print("4 Produkt > ");
        fourthProduct = scanner.nextDouble();
        System.out.print("5 Produkt > ");
        fifthProduct = scanner.nextDouble();

        sumOfProduct = firstProduct + secondProduct + thirdProduct + fourthProduct + fifthProduct;
        mwsAmount = sumOfProduct * mws;

        System.out.println("\r\n\r\nSumme aller Produkte: " + sumOfProduct + "€\r\n" +
                "Anteil Mehrwertsteuer: " + mwsAmount + "€\r\n" +
                "Anzahl der Produkte: 5");

    }
}
