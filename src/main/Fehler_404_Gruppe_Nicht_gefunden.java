package main;

public class Fehler_404_Gruppe_Nicht_gefunden {

    private final static String OUTPUT_NAME = "Launcher";

    public static void main(String[] args){
        Output.write("Application Starting!", "SYSTEM");
        createShutdownHook();

        chooseProgramComplexityAndStartProgram();

        System.exit(0);
    }

    private static void chooseProgramComplexityAndStartProgram(){

    }

    private static void createShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Output.write("Application Stopping...", "SYSTEM");
                Output.close();
            } catch (Exception exception) {
                Output.exceptionWrite(exception);
            }
        }));
    }
}
