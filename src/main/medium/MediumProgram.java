package main.medium;

import main.Output;

/**
 * Diese Klasse ist nur zum Starten der "mittelschweren" Variante, für SSP-ES (Stein-Papier-Schere-Echse-Spock).
 * @author Rouven Tjalf Rosploch
 * @version 1.00, 02.02.2022
 */
public class MediumProgram {

    private MediumProgram(){}

    /**
     * Startet die Klasse
     * @param hand ID des Spielers von der Hand
     * @param enemy ID des Gegners von der Hand
     */
    public static void start(int hand, int enemy){
        /*
         * 0: SCHERE
         * 1: STEIN
         * 2: PAPIER
         * 3: ECHSE
         * 4: SPOCK
         */
        String ownHand = getHand(hand);
        String enemyHand = getHand(enemy);
        String answer;
        if (isWinner(hand, enemy)) {
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

    /**
     * Überprüft, ob der Spieler der Gewinner ist
     * @param own ID der eigenen Hand
     * @param enemy ID der Gegner Hand
     * @return boolean – Gewonnen (true) oder nicht (false)
     */
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

    /**
     * 0: SCHERE<br/>
     * 1: STEIN<br/>
     * 2: PAPIER<br/>
     * 3: ECHSE<br/>
     * 4: SPOCK<br/><br/>
     * <b>Gibt {@code null} zurück, wenn {@code id} über 4 oder unter 0!</b>
     * @param id Die Hand-ID – Beschreibung oben
     * @return {@linkplain String} – Name der Hand
     */
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
        return sent;
    }
}
