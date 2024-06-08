package base;

import GUi_part.Home;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{

    private static Doctor[] listOfDoctors = new Doctor[10];

    public static Doctor[] getListOfDoctors() {
        return listOfDoctors;
    }

    public static ArrayList<Consultation>consultationArrayList = new ArrayList<>();

    //--
    public void display() throws IOException, ParseException {
        while (true) {
            Scanner input01 = new Scanner(System.in);
            System.out.println("___________________________________________________");
            System.out.println("|| You're Welcome to Skin Consultation Center ||");
            System.out.println("");
            System.out.println("1. Add Doctor to the system");
            System.out.println("2. Delete Doctor from the system");
            System.out.println("3. Print all details");
            System.out.println("4. Save Data in to the file");
            System.out.println("5. Load Data from file");
            System.out.println("6. Open GUI");
            System.out.println("0. Exit");
            System.out.println("");
            System.out.print("Enter your choice: ");
            System.out.println("");

            int num = input01.nextInt();

            if (num == 1) {
                createDoctor();
            } else if (num == 2) {
                deleteDoctor();
            } else if (num == 3) {
                printListOfDoctors();
            } else if (num == 4) {
                saveToFile();
            }else if (num == 5) {
                readFile();
            }else if (num == 6) {
                new Home();
            }else if (num == 0) {
                break;
            }
        }
    }

    @Override
    public void createDoctor() throws IOException, ParseException {

        if (Doctor.getAvailableDoctors() == 10) {
            System.out.println("Doctor list is full");

        } else {
            Doctor doctor = new Doctor();

            BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Doctor's name: ");
            String doctorFirstName = input1.readLine().trim();
            doctor.setFirstName(doctorFirstName);

            System.out.print("Enter the Doctor's surname: ");
            String doctorSurname = input1.readLine().trim();
            doctor.setSurName(doctorSurname);

            while (true){
                try {
                    System.out.print("Enter the Doctor's DOB (dd/mm/yyyy): ");
                    String dob = input1.readLine().trim();
                    doctor.setDob(dob);
                    break;
                } catch (ParseException e){
                    System.out.println(e.toString());
                    System.out.println("----Wrong input. Enter again----");
                }
            }
            System.out.print("Enter Address: ");
            String address = input1.readLine().trim();
            doctor.setAddress(address);

            System.out.print("Enter the Doctor's Mobile Number: ");
            String mobileNumber = input1.readLine().trim();
            doctor.setMobileNumber(mobileNumber);

            System.out.print("Enter the Doctor's Medical Licence Number: ");
            String medicalLicenceNumber = (input1.readLine().trim());
            doctor.setMedicalLicenceNumber(medicalLicenceNumber);

            System.out.print("Enter the Doctor's Specialization: ");
            String specialization = input1.readLine().trim();
            doctor.setSpecialization(specialization);



            for (int i = 0; i < 10; i++) {
                if (listOfDoctors[i] == null) {
                    listOfDoctors[i] = doctor;
                    doctor.setID(i+1);
                    break;
                }
            }

        }
    }

    @Override
    public void deleteDoctor() throws IOException {
        BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Medical Licence Number: ");
        String medicalLicenceNumber = (input1.readLine().trim());
        int isDeleted=0;
        for (int i = 0; i < 10; i++) {
            if(medicalLicenceNumber.equals(listOfDoctors[i].getMedicalLicenceNumber())){
                listOfDoctors[i] = null;
                System.out.println("Doctor is Deleted");
                isDeleted=1;
                break;
            }
        }
        if(isDeleted == 0) System.out.println("----No user Available----");
    }

    @Override
    public void printListOfDoctors() {
        for (int i = 0; i < 10; i++) {
            if(listOfDoctors[i] != null){
                System.out.println(listOfDoctors[i].toString());
            }
        }
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter file = new FileWriter("DoctorList.txt");
        BufferedWriter writer = new BufferedWriter(file);

        for (int i = 0; i < 10; i++) {
            if(listOfDoctors[i] != null ){
                writer.write(listOfDoctors[i].toString());
                writer.write("\n");
                System.out.println(listOfDoctors[i].toString());
                System.out.println("--Saved to File---");
            }
        }
        writer.write("End Line");
        writer.close();
    }
    public static void readFile() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader("DoctorList.txt"));

        String doctorID=null, firstName=null, surName=null, DOB=null, mobile=null, address=null, licenceNum=null, specialization=null;

        int i = 0,j=0;
        while (true) {
            String line = reader.readLine();
            if (line.equals("End Line")) break;
            i++;
            if (i % 9 == 1) {
                doctorID = line.split("=")[1].trim();
            } else if (i % 9 == 2) {
                firstName = line.split("=")[1].trim();
            } else if (i % 9 == 3) {
                surName = line.split("=")[1].trim();
            } else if (i % 9 == 4) {
                DOB = line.split("=")[1].trim();
            } else if (i % 9 == 5) {
                mobile = line.split("=")[1].trim();
            } else if (i % 9 == 6) {
                address = line.split("=")[1].trim();
            } else if (i % 9 == 7) {
                licenceNum = line.split("=")[1].trim();
            } else if (i % 9 == 8) {
                specialization = line.split("=")[1].trim();
            }else if (i % 9 == 0) {
                int doctorID1=Integer.parseInt(doctorID);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date1 = formatter.parse(DOB);

                Doctor doc = new Doctor(doctorID1,firstName, surName, date1, mobile, licenceNum,specialization);
                listOfDoctors[j] = doc;
                j++;
            }
        }
    }

    public static void setListOfDoctors(Doctor[] listOfDoctors) {
        WestminsterSkinConsultationManager.listOfDoctors = listOfDoctors;
    }
}
