package Material_211210;

import bildanalyse.Bildwerkzeug;
import bildanalyse.Farbbild;
import bildanalyse.Pixel;

public class Bildbearbeitung
{
    private final Bildwerkzeug bildwerkzeug ;
    
    public Bildbearbeitung()
    {
        bildwerkzeug = new Bildwerkzeug();
    }
    
    public void kopiere() {
        String path = "C:\\Users\\Rouven\\Schule\\Fehler-404-Gruppe-nicht-gefunden\\src\\Material_211210\\Beispiel\\";
        String[] possibilities = {"blau.jpg", "rot.jpg", "alpha.jpg", "gruen.jpg"};
        Pixel[] pixelNeu = new Pixel[1];
        int hohe = 0, breite = 0;

        for (int i = 0; i < possibilities.length; i++) {
            Farbbild farbbild = bildwerkzeug.leseJPG(path + possibilities[i]);
            Pixel[] pixel = farbbild.gibAllePixel();
            if (i==0)
                pixelNeu = new Pixel[pixel.length];
            for (int j = 0; j < pixel.length; j++) {
                try {
                    switch (i) {
                        case 0:
                            breite = farbbild.gibBreite();
                            hohe = farbbild.gibHoehe();
                            pixelNeu[j] = pixel[j];
                            break;
                        case 1:
                            pixelNeu[j].setzeRot(pixel[j].gibRot());
                            break;
                        case 2:
                            pixelNeu[j].setzeAlpha(pixel[j].gibAlpha());
                            break;
                        case 3:
                            pixelNeu[j].setzeGruen(pixel[j].gibGruen());
                        default:
                            break;
                    }
                } catch (Exception ignored) {
                }
            }
            bildwerkzeug.schreibeJPG("Bild-neu-"+possibilities[i], farbbild);
            System.out.println("\"Bild-neu-"+possibilities[i]+"\" wurde geschrieben");
        }
        Farbbild farbbild = new Farbbild(breite, hohe);
        farbbild.setzeAllePixel(pixelNeu);
        System.out.println("Setze Neue Pixel");
        new Bildwerkzeug().schreibeJPG("Bild-neu.jpg", farbbild);
        System.out.println("\"Bild-neu.jpg\" wurde geschrieben");
    }
}
