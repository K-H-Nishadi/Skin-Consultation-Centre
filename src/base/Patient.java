package base;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person{

    private int patientId;
    public static ArrayList<Patient> patients = new ArrayList<>();
    public Patient(String name, String lastname, String mobileNumber, int patientId, Date dob) {
        super(name,lastname, dob, mobileNumber);
        this.patientId = patientId;
    }

    public Patient(String firstName, String surName, Date dateOfBirth, String mobileNumber, String address) {

    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }


    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public static void setPatients(ArrayList<Patient> patients) {
        Patient.patients = patients;
    }
}
