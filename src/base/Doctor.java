package base;

import java.util.Date;

public class Doctor extends Person{

    private int ID;
    private String medicalLicenceNumber;
    private String specialization;

    private static int availableDoctors;

    public Doctor(int id,String firstname, String surName, Date dob, String mobileNumber, String medicalLicenceNumber, String specialization) {
        super(firstname,surName, dob, mobileNumber);
        this.ID = id;
        this.medicalLicenceNumber =  medicalLicenceNumber;
        this.specialization = specialization;
        Doctor.availableDoctors++;
    }

    public Doctor(){

    }


    public static int getAvailableDoctors() {
        return availableDoctors;
    }

    public static void setAvailableDoctors() {

        Doctor.availableDoctors--;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = String.valueOf(medicalLicenceNumber);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return
                "Doctor's ID = " + ID +
                super.toString()+
                "\nMedical Licence Number = " + medicalLicenceNumber +
                "\nSpecialization = " + specialization+"\n";
    }
}
