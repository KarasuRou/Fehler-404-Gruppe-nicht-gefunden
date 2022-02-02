package main;

import main.complicated.ComplicatedProgram;
import main.easy.EasyProgram;
import main.medium.MediumProgram;

import java.util.Random;
import java.util.Scanner;

/**
 * Diese Klasse bietet viele Methoden an um
 * @author Rouven Tjalf Rosploch
 * @version 1.00, 02.02.2022
 */
public class Fehler_404_Gruppe_Nicht_gefunden {

    private final static String OUTPUT_NAME = "Launcher";
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Output.write("Application Starting!", "SYSTEM");
        createShutdownHook();

        chooseProgramComplexityAndStartProgram();

        System.exit(0);
    }

    private static void chooseProgramComplexityAndStartProgram(){
        int complexProgram = getComplexProgram();
        int hand = getHand();
        int randomNumber = new Random().nextInt(5); // 5 Hand possibilities
        if (hand >= 0 && hand <= 4) {
            switch (complexProgram) {
                case 0:
                    EasyProgram.start(hand, randomNumber);
                    break;
                case 1:
                    MediumProgram.start(hand, randomNumber);
                    break;
                case 2:
                    ComplicatedProgram.start(hand, randomNumber);
                    break;
                default:
                    Output.write("Invalid complexity! Restarting initialization-progress!", OUTPUT_NAME);
                    chooseProgramComplexityAndStartProgram();
                    break;

            }
        } else {
            Output.write("Invalid hand! Restarting initialization-progress!", OUTPUT_NAME);
            chooseProgramComplexityAndStartProgram();
        }
    }

    private static int getComplexProgram(){
        int chosen = -1;
        do {
            Output.write("\r\n" +
                            "Choose Complexity:\r\n" +
                            "1: Easy        (Einfach)\r\n" +
                            "2: Medium      (Mittel)\r\n" +
                            "3: Complicated (Kompliziert)"
                    , OUTPUT_NAME);
            System.out.print("> ");
            String input = scanner.nextLine();
            try {
                chosen = Integer.parseInt(input) - 1;
                if (chosen < 0 || chosen > 2) {
                    chosen = -1;
                    Output.errorWrite("You're input: \"" + input + "\" is not valid!", OUTPUT_NAME);
                }
            } catch (Exception ignored) {
                if (input.contains("1") || input.contains("Ea")|| input.contains("Ei")) {
                    chosen = 0;
                } else if (input.contains("2") || input.contains("Me") || input.contains("Mi")) {
                    chosen = 1;
                } else if (input.contains("3") || input.contains("Co")|| input.contains("Ko")) {
                    chosen = 2;
                } else {
                    Output.errorWrite("You're input: \"" + input + "\" is not valid!", OUTPUT_NAME);
                }
            }
        } while (chosen == -1);
        return chosen;
    }

    private static int getHand(){
        int chosen = -1;
        do {
            Output.write("\r\n" +
                            "Choose your Hand:\r\n" +
                            "1: Scissor (Schere)\r\n" +
                            "2: Rock    (Stein)\r\n" +
                            "3: Paper   (Papier)\r\n" +
                            "4: Lizard  (Echse)\r\n" +
                            "5: Spock   (Spock)"
                    , OUTPUT_NAME);
            System.out.print("> ");
            String input = scanner.nextLine();
            try {
                chosen = Integer.parseInt(input) - 1;
                if (chosen < 0 || chosen > 4) {
                    chosen = -1;
                    Output.errorWrite("You're input: \"" + input + "\" is not valid!", OUTPUT_NAME);
                }
            } catch (Exception ignored) {
                if (input.contains("1") || input.contains("Sc")) {
                    chosen = 0;
                } else if (input.contains("2") || input.contains("Ro") || input.contains("St")) {
                    chosen = 1;
                } else if (input.contains("3") || input.contains("Pap")) {
                    chosen = 2;
                } else if (input.contains("4") || input.contains("Li") || input.contains("Ec")) {
                    chosen = 3;
                } else if (input.contains("5") || input.contains("Sp")) {
                    chosen = 4;
                } else {
                    Output.errorWrite("You're input: \"" + input + "\" is not valid!", OUTPUT_NAME);
                }
            }
        } while (chosen == -1);
        return chosen;
    }

    private static void createShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Output.write("Application Stopping...", "SYSTEM");
                scanner.close();
                Output.close();
            } catch (Exception exception) {
                Output.exceptionWrite(exception);
            }
        }));
    }
}
