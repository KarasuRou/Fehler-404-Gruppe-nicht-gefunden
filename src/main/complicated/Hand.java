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

    /**
     * 0: SCHERE<br/>
     * 1: STEIN<br/>
     * 2: PAPIER<br/>
     * 3: ECHSE<br/>
     * 4: SPOCK<br/><br/>
     * <b>Returns null if <i>id</i> is over 4 or under 0!</b>
     * @return {@linkplain Hand}-enum
     */
    Hand getHandByInt(int id){
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
}
