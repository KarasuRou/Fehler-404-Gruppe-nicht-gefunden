package main.complicated;

import main.Output;

public class ComplicatedProgram {

    public ComplicatedProgram(){}

    public static void start(int handNumber, int randomNumber) {
        Hand playerHand = Hand.getHandByInt(handNumber);
        String result;
        result = playerHand.getSentence(randomNumber);
        Output.write(result);
    }
}
