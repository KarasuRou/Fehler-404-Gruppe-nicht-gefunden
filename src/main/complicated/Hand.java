package main.complicated;

/**
 * Bietet alle Möglichkeiten für: "Stein-Papier-Schere-Echse-Spock", als {@code enum}.
 * @author Rouven Tjalf Rosploch
 * @version 1.00, 02.02.2022
 */
public enum Hand {
    SCHERE,
    STEIN,
    PAPIER,
    ECHSE,
    SPOCK;

    /**
     * Erhält den Namen des enums
     * @return {@linkplain Hand} – ASD
     */
    public String getString(){
        switch (this) {
            case SCHERE:
                return "Schere";
            case STEIN:
                return "Stein";
            case PAPIER:
                return "Papier";
            case ECHSE:
                return "Echse";
            case SPOCK:
                return "Spock";
        }
        return this.toString();
    }

    /**
     * @see #isWinner(Hand, Hand)
     */
    public boolean isWinner(int enemyHand){
        return isWinner(this, enemyHand);
    }

    /**
     * @see #getSentence(Hand, int)
     */
    public String getSentence(int enemyHand) {
        return getSentence(this, enemyHand);
    }

    /**
     * 0: SCHERE<br/>
     * 1: STEIN<br/>
     * 2: PAPIER<br/>
     * 3: ECHSE<br/>
     * 4: SPOCK<br/><br/>
     * <b>Gibt {@code null} zurück, wenn {@code id} über 4 oder unter 0!</b>
     * @param id Die Hand-ID – Beschreibung oben
     * @return {@linkplain Hand} – enum
     */
    public static Hand getHandByInt(int id){
        switch (id) {
            case 0:
                return SCHERE;
            case 1:
                return STEIN;
            case 2:
                return PAPIER;
            case 3:
                return ECHSE;
            case 4:
                return SPOCK;
        }
        return null;
    }

    /**
     * @see #isWinner(Hand, Hand)
     */
    public static boolean isWinner(Hand thisHand, int enemyHand){
        return isWinner(thisHand, getHandByInt(enemyHand));
    }

    /**
     * Überprüft, ob das enum-Hand-Objekt der Gewinner ist
     * @param enemyHand ID der Gegner-Hand. Siehe für mehr infos bei: {@linkplain #getHandByInt(int)}
     * @return boolean – Gewonnen (true) oder nicht (false)
     */
    public static boolean isWinner(Hand thisHand, Hand enemyHand){
        switch (thisHand) {
            case SCHERE:
                return enemyHand == PAPIER || enemyHand == ECHSE;
            case STEIN:
                return enemyHand == SCHERE || enemyHand == ECHSE;
            case PAPIER:
                return enemyHand == STEIN || enemyHand == SPOCK;
            case ECHSE:
                return enemyHand == SPOCK || enemyHand == PAPIER;
            case SPOCK:
                return enemyHand == SCHERE || enemyHand == STEIN;
        }
        return false;
    }

    /**
     * @see #getSentence(Hand, Hand)
     */
    public static String getSentence(Hand playerHand, int enemyHand){
        return getSentence(playerHand, getHandByInt(enemyHand));
    }

    /**
     * Gibt einen Satz zurück, der widerspiegelt, ob das enum-Hand-Objekt gewonnen/verloren hat und wie es gewonnen/verloren hat
     * @param enemyHand ID der Gegner-Hand. Siehe für mehr infos bei: {@linkplain #getHandByInt(int)}
     * @return String - Gewonnen/verloren Satz mit Beschreibung
     */
    public static String getSentence(Hand playerHand, Hand enemyHand){
        String sentence;
        String detailSentence;
        if (isWinner(playerHand, enemyHand)) {
            sentence = " gewinnt gegen ";
            detailSentence = sentence(playerHand, enemyHand);
        } else if(playerHand.getString().equals(enemyHand.getString())){
            sentence = " hat gleichstand mit ";
            detailSentence = "Ops... ";
        } else {
            sentence = " verliert gegen ";
            detailSentence = sentence(enemyHand, playerHand);
        }
        sentence = "("+playerHand.getString() + sentence + enemyHand.getString() + "!)";
        return detailSentence + sentence;
    }

    // Teil des Satzes der in #getSentence(Hand, Hand) verwendet wird
    private static String sentence(Hand playerHand, Hand enemyHand) {
        String sent = playerHand.getString() + " ", errorMessage = "ERROR";
        switch (playerHand) {
            case SCHERE:
                if (enemyHand == PAPIER) {
                    sent += "schneidet";
                } else if (enemyHand == ECHSE) {
                    sent += "köpft";
                } else {
                    sent = errorMessage;
                }
                break;
            case STEIN:
                if (enemyHand == SCHERE) {
                    sent += "schleift";
                } else if (enemyHand == ECHSE) {
                    sent += "zerquetscht";
                } else {
                    sent = errorMessage;
                }
                break;
            case PAPIER:
                if (enemyHand == SPOCK) {
                    sent += "widerlegt";
                } else if (enemyHand == STEIN){
                    sent += "bedeckt";
                } else {
                    sent = errorMessage;
                }
                break;
            case ECHSE:
                if (enemyHand == SPOCK) {
                    sent += "vergiftet";
                } else if (enemyHand == PAPIER) {
                    sent += "frisst";
                } else {
                    sent = errorMessage;
                }
                break;
            case SPOCK:
                if (enemyHand == SCHERE) {
                    sent += "zertrümmert";
                } else if (enemyHand == STEIN) {
                    sent += "verdampft";
                } else {
                    sent = errorMessage;
                }
                break;
            default:
                return errorMessage;
        }
        if (!sent.equals(errorMessage)) {
            sent += " " + enemyHand.getString() + " ";
        }
//        return sentence(enemyHand, playerHand);
        return sent;
    }
}
