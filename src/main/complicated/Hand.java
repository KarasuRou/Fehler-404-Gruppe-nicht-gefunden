package main.complicated;

/**
 * Contains all possibility for: "Schere, Stein, Papier, Echse, Spock" - in German
 */
public enum Hand {
    SCHERE,
    STEIN,
    PAPIER,
    ECHSE,
    SPOCK;

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

    public boolean isWinner(int enemyHand){
        return isWinner(this, enemyHand);
    }

    public String getSentence(int enemyHand) {
        return getSentence(this, enemyHand);
    }

    /**
     * 0: SCHERE<br/>
     * 1: STEIN<br/>
     * 2: PAPIER<br/>
     * 3: ECHSE<br/>
     * 4: SPOCK<br/><br/>
     * <b>Returns null if <i>id</i> is over 4 or under 0!</b>
     * @return {@linkplain Hand}-enum
     */
    public static Hand getHandByInt(int id){
        switch (id) {
            case 0:
                return Hand.SCHERE;
            case 1:
                return Hand.STEIN;
            case 2:
                return Hand.PAPIER;
            case 3:
                return Hand.ECHSE;
            case 4:
                return Hand.SPOCK;
        }
        return null;
    }

    public static boolean isWinner(Hand thisHand, int enemyHand){
        return isWinner(thisHand, getHandByInt(enemyHand));
    }

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

    public static String getSentence(Hand playerHand, int enemyHand){
        return getSentence(playerHand, getHandByInt(enemyHand));
    }

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
