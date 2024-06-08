package base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface SkinConsultationManager{

    void createDoctor() throws IOException, ParseException;

    void deleteDoctor() throws IOException;

    void printListOfDoctors();

    void saveToFile() throws IOException;
}
