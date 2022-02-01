package main.medium;

import main.Output;

public class MediumProgram {

    private MediumProgram(){}

    public static void start(int hand, int randomNumber){
        /*
         * 0: SCHERE
         * 1: STEIN
         * 2: PAPIER
         * 3: ECHSE
         * 4: SPOCK
         */
        String ownHand = getHand(hand);
        String enemyHand = getHand(randomNumber);
        String answer;
        if (isWinner(hand, randomNumber)) {
            answer = ownHand + " gewinnt gegen " + enemyHand + "! (xyz!)";
            answer = answer.replace("xyz", replaceSentence(ownHand, enemyHand));
        } else if (ownHand.equals(enemyHand)){
            answer = ownHand + " hat gleichstand mit " + enemyHand + "!";
        } else {
            answer = ownHand + " verliert gegen " + enemyHand + "! (xyz!)";
            answer = answer.replace("xyz", replaceSentence(enemyHand, ownHand));
        }
        Output.write(answer);
    }

    private static boolean isWinner(int own, int enemy) {
        /*
         * 0: SCHERE
         * 1: STEIN
         * 2: PAPIER
         * 3: ECHSE
         * 4: SPOCK
         */
        switch (own) {
            case 0:
                return enemy == 2 || enemy == 3;
            case 1:
                return enemy == 0 || enemy == 3;
            case 2:
                return enemy == 1 || enemy == 4;
            case 3:
                return enemy == 4 || enemy == 2;
            case 4:
                return enemy == 0 || enemy == 1;
        }
        return false;
    }

    private static String getHand(int id) {
        /*
         * 0: SCHERE
         * 1: STEIN
         * 2: PAPIER
         * 3: ECHSE
         * 4: SPOCK
         */
        switch (id) {
            case 0:
                return "Schere";
            case 1:
                return "Stein";
            case 2:
                return "Papier";
            case 3:
                return "Echse";
            case 4:
                return "Spock";
        }
        return null;
    }

    private static String replaceSentence(String ownHand, String enemyHand) {
        /*
         * 0: SCHERE
         * 1: STEIN
         * 2: PAPIER
         * 3: ECHSE
         * 4: SPOCK
         */
        String sent;
        switch (ownHand) {
            case "Schere":
                if (enemyHand.equals("Papier")) {
                    sent = "Schere schneidet Papier";
                } else if (enemyHand.equals("Echse")) {
                    sent = "Schere köpft Echse";
                } else {
                    sent = "ERROR";
                }
                break;
            case "Stein":
                if (enemyHand.equals("Schere")) {
                    sent = "Stein schleift Schere";
                } else if (enemyHand.equals("Echse")) {
                    sent = "Stein zerquetscht Echse";
                } else {
                    sent = "ERROR";
                }
                break;
            case "Papier":
                if (enemyHand.equals("Spock")) {
                    sent = "Papier widerlegt Spock";
                } else if (enemyHand.equals("Stein")){
                    sent = "Papier bedeckt Stein";
                } else {
                    sent = "ERROR";
                }
                break;
            case "Echse":
                if (enemyHand.equals("Spock")) {
                    sent = "Echse vergiftet Spock";
                } else if (enemyHand.equals("Papier")) {
                    sent = "Echse frisst Papier";
                } else {
                    sent = "ERROR";
                }
                break;
            case "Spock":
                if (enemyHand.equals("Schere")) {
                    sent = "Spock zertrümmert Schere";
                } else if (enemyHand.equals("Stein")) {
                    sent = "Spock verdampft Stein";
                } else {
                    sent = "ERROR";
                }
                break;
            default:
                return "ERROR";
        }
        if (!sent.equals("ERROR")) {
            sent += "";
        }
        return sent;
    }
}
