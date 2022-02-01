package main.easy;

import main.Output;

public class EasyProgram {

    private EasyProgram(){}

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

        if (isWinner(hand, randomNumber)) {
            Output.write(ownHand + " gewinnt gegen " + enemyHand + "!");
        } else if (ownHand.equals(enemyHand)){
            Output.write(ownHand + " hat gleichstand mit " + enemyHand + "!");
        } else {
            Output.write(ownHand + " verliert gegen " + enemyHand + "!");
        }
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
}
