package base;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        WestminsterSkinConsultationManager.readFile();
        WestminsterSkinConsultationManager a = new WestminsterSkinConsultationManager();
        a.display();
        //a.saveToFile();
    }
}