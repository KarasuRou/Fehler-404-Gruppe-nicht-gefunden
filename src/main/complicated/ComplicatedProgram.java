package main.complicated;

import main.Output;

/**
 * Diese Klasse ist nur zum Starten der "kompliziertesten" Variante, für SSP-ES (Stein-Papier-Schere-Echse-Spock).
 * @author Rouven Tjalf Rosploch
 * @version 1.00, 02.02.2022
 */
public class ComplicatedProgram {

    public ComplicatedProgram(){}

    /**
     * Startet die Klasse mit dem {@linkplain Hand}-enum-Objekt
     * @param handNumber ID des Spielers von der Hand
     * @param enemy ID des Gegners von der Hand
     */
    public static void start(int handNumber, int enemy) {
        Hand playerHand = Hand.getHandByInt(handNumber);
        String result = playerHand.getSentence(enemy);
        Output.write(result);
    }
}
