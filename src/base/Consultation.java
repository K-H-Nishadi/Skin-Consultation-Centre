package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Consultation {

    private int cost;

    private Doctor new_Doctor;

    private Date new_date;

    private int timeslot;
    private Patient new_Patient;

    private String imagePath;



    private String notes;
    static ArrayList <Consultation> consultations = new ArrayList<>();

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Doctor getNew_Doctor() {
        return new_Doctor;
    }

    public void setNew_Doctor(Doctor new_Doctor) {
        this.new_Doctor = new_Doctor;
    }

    public Patient getNew_Patient() {
        return new_Patient;
    }

    public void setNew_Patient(Patient new_Patient) {
        this.new_Patient = new_Patient;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDob(String dob) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.new_date = formatter.parse(dob);
    }
    public Date getNew_date() {
        return new_date;
    }

    public void setNew_date(Date new_date) {
        this.new_date = new_date;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public Consultation(Patient patient,
                        Doctor doctor, String notes,
                        Date bookingDate, int cost, int timeslot, String imagePath) {

        this.new_Doctor = doctor;
        this.notes = notes;
        this.new_date = bookingDate;
        this.cost = cost;
        this.timeslot = timeslot;
        this.new_Patient = patient;
        this.imagePath = imagePath;

        consultations.add(this);
        Patient.getPatients().add(getNew_Patient());

    }
}
