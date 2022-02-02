package main.easy;

import main.Output;

/**
 * Diese Klasse ist nur zum Starten der "einfachsten" Variante, für SSP-ES (Stein-Papier-Schere-Echse-Spock).
 * @author Rouven Tjalf Rosploch
 * @version 1.00, 02.02.2022
 */
public class EasyProgram {

    private EasyProgram(){}

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

        if (isWinner(hand, enemy)) {
            Output.write(ownHand + " gewinnt gegen " + enemyHand + "!");
        } else if (ownHand.equals(enemyHand)){
            Output.write(ownHand + " hat gleichstand mit " + enemyHand + "!");
        } else {
            Output.write(ownHand + " verliert gegen " + enemyHand + "!");
        }
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
}
