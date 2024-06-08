package GUi_part;

import base.*;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class AddConsultation extends JFrame implements ActionListener {
    JComboBox jComboBox;

    final String secretKey = "secrete";
    AESEncryptionDecryption encryption;

    JComboBox timeSlot_ComboBox;
    JDatePickerImpl datePicker1;

    ArrayList<Consultation> consultationArrayList = WestminsterSkinConsultationManager.consultationArrayList;
    String filePathEncrypt = "";

    ArrayList<Doctor> doctorArrayList = new ArrayList<>();
    JDatePickerImpl datePicker2;

    Doctor[] doctorList = WestminsterSkinConsultationManager.getListOfDoctors();
    JButton booking, back, select,costButton;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11;
    public AddConsultation() {
        JPanel jPanel = new JPanel();
        add(jPanel);
        encryption = new AESEncryptionDecryption();
        for (int i = 0; i < doctorList.length; i++){
            if (doctorList[i] != null)
                doctorArrayList.add(doctorList[i]);
        }
        System.out.println(doctorArrayList.get(0).getFirstName());
        JLabel firstName = new JLabel("First Name",SwingConstants.LEFT);
        JLabel surName = new JLabel("Surname",SwingConstants.LEFT);
        JLabel dateOfBirth = new JLabel("Date of Birth",SwingConstants.LEFT);
        JLabel mobileNumber = new JLabel("Mobile Number",SwingConstants.LEFT);
        JLabel patientId = new JLabel("Patient ID",SwingConstants.LEFT);
        JLabel selectDoctor = new JLabel("Select Doctor",SwingConstants.LEFT);
        JLabel note = new JLabel("Note",SwingConstants.LEFT);
        JLabel timeSlot = new JLabel("Time Slot",SwingConstants.LEFT);
        JLabel dateOfBooking = new JLabel("Date of Booking",SwingConstants.LEFT);
        JLabel upload = new JLabel("Upload",SwingConstants.LEFT);
        //JLabel cost = new JLabel("Cost",SwingConstants.LEFT);
        this.setTitle("Add Consultation");

        booking = new JButton("Submit");
        back = new JButton("Back");
        costButton = new JButton("Get Cost");
        select = new JButton("Select");
        costButton.addActionListener(this);
        booking.addActionListener(this);
        select.addActionListener(this);

        txt1 = new JTextField(10);
        txt2 = new JTextField(10);

        //https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
        UtilDateModel model1 = new UtilDateModel();
        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1,p1);
        datePicker1 = new JDatePickerImpl(datePanel1,new DateComponentFormatter());

        txt4 = new JTextField(10);
        txt5 = new JTextField(10);

        //txt6
        String[] optionsToChoose = new String[10];
        for(int i = 0; i < doctorArrayList.size(); i++){
            if (doctorArrayList.get(i) != null){
                optionsToChoose[i] = doctorArrayList.get(i).getFirstName();
            }
        }
        jComboBox = new JComboBox<>(optionsToChoose);

        txt7 = new JTextField(10);

        //txt8
        String[] optionsToChoose1 = {"4.00 - 5.00 p.m", "5.00 - 6.00 p.m", "6.00 - 7.00 p.m", "7.00 - 8.00 p.m","8.00 - 9.00 p.m","9.00 - 10.00 p.m"};
        timeSlot_ComboBox = new JComboBox<>(optionsToChoose1);
        timeSlot_ComboBox.addActionListener(this);

        //txt9
        //https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2,p2);
        datePicker2 = new JDatePickerImpl(datePanel2,new DateComponentFormatter());

        txt10 = new JTextField(10);
        txt11 = new JTextField(10);
        txt11.setEnabled(false);


        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;

        // Add label
        gc.insets = new Insets(50,11,11,0);

        gc.gridx = 0;
        gc.gridy = 0;
        jPanel.add(firstName, gc);

        gc.insets = new Insets(0,11,11,0);
        gc.gridx = 0;
        gc.gridy = 1;
        jPanel.add(surName, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        jPanel.add(dateOfBirth, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        jPanel.add(mobileNumber, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        jPanel.add(patientId, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        jPanel.add(patientId, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        jPanel.add(selectDoctor, gc);

        gc.gridx = 0;
        gc.gridy = 7;
        jPanel.add(note, gc);

        gc.gridx = 0;
        gc.gridy = 8;
        jPanel.add(timeSlot, gc);

        gc.gridx = 0;
        gc.gridy = 9;
        jPanel.add(dateOfBooking, gc);

        gc.gridx = 0;
        gc.gridy = 10;
        jPanel.add(upload, gc);

        gc.gridx = 0;
        gc.gridy = 11;
        jPanel.add(costButton, gc);


        //Add Text field
        gc.insets = new Insets(50,11,11,20);
        System.out.println(gc.ipady);
        gc.gridx = 1;
        gc.gridy = 0;
        jPanel.add(txt1, gc);

        gc.insets = new Insets(0,11,11,20);
        gc.gridx = 1;
        gc.gridy = 1;
        jPanel.add(txt2, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        jPanel.add(datePicker1, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        jPanel.add(txt4, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        jPanel.add(txt5, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        jPanel.add(jComboBox, gc);

        gc.gridx = 1;
        gc.gridy = 7;
        jPanel.add(txt7, gc);

        gc.gridx = 1;
        gc.gridy = 8;
        jPanel.add(timeSlot_ComboBox, gc);

        gc.gridx = 1;
        gc.gridy = 9;
        jPanel.add(datePicker2, gc);

//        gc.insets = new Insets(0,0,0,0);
//        gc.gridx = 1;
//        gc.gridy = 10;
//        jPanel.add(txt10, gc);

        gc.gridx = 1;
        gc.gridy = 10;
        jPanel.add(select, gc);

        gc.gridx = 1;
        gc.gridy = 11;
        jPanel.add(txt11, gc);

        //Add Button
        gc.insets = new Insets(10,11,11,10);
        gc.gridx = 0;
        gc.gridy = 30;
        jPanel.add(booking, gc);

        gc.insets = new Insets(10,150,11,20);
        gc.gridx = 1;
        gc.gridy = 30;
        jPanel.add(back, gc);

        pack();
        setVisible(true);
        jPanel.setBackground(Color.LIGHT_GRAY);

        back.addActionListener(this);
    }

    public void saveDetails(){
        String firstName = "";
        String lastName = "";
        String dob = "";
        String mobileNumber = "";
        String patientId = "";
        String cost = "";
        String dateOfBooking = "";

        boolean isempty = false;

        if(txt1.getText().equals("")){
            firstName = "First Name";
            isempty = true;
        }
        if(txt2.getText().equals("")){
            lastName = "Last Name";
            isempty = true;
        }
        if(datePicker1.getModel().getValue() == null){
            dob = "Date of Birth";
            isempty = true;
        }
        if(txt4.getText().equals("")){
            mobileNumber = "Mobile Number";
            isempty = true;
        }
        if(txt5.getText().equals("")){
            patientId = "Patient ID";
            isempty = true;
        }
        if(txt11.getText().equals("")){
            cost = "Cost";
            isempty = true;
        }
        if(datePicker2.getModel().getValue() == null){
            dateOfBooking = "Date of Booking";
            isempty = true;
        }
        if(isempty){
            JOptionPane.showMessageDialog(null, "Please Enter following Fields:- " + " \n" + firstName + " \n" +
                    lastName + " \n" + dob +" \n" + mobileNumber + " \n" +patientId + " \n" +cost + " \n" +dateOfBooking );
        }


        /*
        boolean collect = false;
        String firstName = this.txt1.getText();
        String surName = this.txt2.getText();
        String dateOfBirth =this.txt3.getText();
        String mobileNumber = this.txt4.getText();
        //String address = this.txt6.getText();
        String note = this.txt7.getText();

        if(Person.name_Validate(firstName,surName)){
            if(Person.dob_Validation(dateOfBirth) != null){
                if(Person.address_Validate(address)){

                } else if (!Person.address_Validate(address)) {
                    JOptionPane.showMessageDialog(this,"Enter the Address");
                }
            }
            else if(Person.dob_Validation(dateOfBirth) == null){
                JOptionPane.showMessageDialog(this,"Incorrect date format");
                 }
                }else if (!Person.name_Validate(firstName,surName)){
                 JOptionPane.showMessageDialog(this,"Please Fill Fields");
                 } else if (Person.mobile_Number_Validate(mobileNumber)) {
                JOptionPane.showMessageDialog(this,"Please Fill Fields");*/
      /*  }

        return collect;*/
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timeSlot_ComboBox){
            Date txtFieldDate = null;
            Date consultationDate = null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            for(Consultation consultation : consultationArrayList){
                if(Objects.equals(consultation.getNew_Doctor().getSurName(), doctorList[jComboBox.getSelectedIndex()].getSurName()) && Objects.equals(consultation.getNew_Doctor().getFirstName(),doctorList[jComboBox.getSelectedIndex()].getFirstName())){
                    if (datePicker2.getModel().getValue() !=null){
                        try {
                            txtFieldDate = formatter.parse(formatter.format(datePicker2.getModel().getValue()));
                            consultationDate = formatter.parse(formatter.format(consultation.getNew_date()));
                        } catch (ParseException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(txtFieldDate.equals(consultationDate)){
                        System.out.println("hello Date");
                        if(timeSlot_ComboBox.getSelectedIndex() == consultation.getTimeslot()){
                            System.out.println("Hello TimeSlot");
                            JOptionPane.showMessageDialog(null,"Dr. "+doctorList[jComboBox.getSelectedIndex()].getSurName() +" is not available on selected time slot\n New doctor Assigned");
                            Doctor doctor = null;
                            try {
                                doctor = selectDoctor(txtFieldDate,timeSlot_ComboBox.getSelectedIndex());
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                            int i = doctorArrayList.indexOf(doctor);
                            jComboBox.setSelectedIndex(i);
                        }
                    }
                }
            }
        }
        else if (e.getSource() == back){
            this.dispose();
            new Home();
        }else if(e.getSource() == costButton){
            boolean isempty = false;
            int patientId = 0;
            if (txt5.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter ID");
                isempty = true;
            }else {
                try{
                    patientId = Integer.parseInt(txt5.getText());
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Please Enter Number for Patient ID");
                    isempty = true;
                }
            }
            if (consultationArrayList.size() == 0 && !isempty) {
                JOptionPane.showMessageDialog(null,"Your Cost is £15 ");
                txt11.setText("15");
            }else{
                boolean isFound = false;
                for(Consultation consultation: consultationArrayList){
                    if (consultation.getNew_Patient().getPatientId() == patientId){
                        isFound = true;
                        break;
                    }
                }
                if (!isempty){
                    if(isFound){
                        JOptionPane.showMessageDialog(null,"Your Cost is £25 ");
                        txt11.setText("25");
                    }else{
                        JOptionPane.showMessageDialog(null,"Your Cost is £15 ");
                        txt11.setText("15");
                    }
                }
            }
        } else if (e.getSource()== booking) {
            saveDetails();
            String firstname = txt1.getText();
            String lastname = txt2.getText();
            Date dob = (Date) datePicker1.getModel().getValue();
            String mobileNumber = txt4.getText();
            int patientId = Integer.parseInt(txt5.getText());
            Doctor doctor = doctorList[jComboBox.getSelectedIndex()];
            String note = encryption.encrypt(txt7.getText(),secretKey);
            int timeSlot = timeSlot_ComboBox.getSelectedIndex();
            Date dateOfBooking= (Date) datePicker2.getModel().getValue();
            String upload = filePathEncrypt;
            int cost = Integer.parseInt(txt11.getText());
            Patient patient = new Patient(firstname,lastname,mobileNumber,patientId,dob);
            Consultation consultation = new Consultation(patient,doctor,note,dateOfBooking,cost,timeSlot,upload);
            WestminsterSkinConsultationManager.consultationArrayList.add(consultation);
            JOptionPane.showMessageDialog(null,"Consultation Added Successfully ! ");
            this.dispose();
            new ConsultationTable();

            //Add image
        } else if (e.getSource()==select) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new ImageFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);

            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();
                filePathEncrypt = encryption.encrypt(filePath, secretKey);
            } else{
                System.out.println("No file selected");
            }
        }
    }
    private Doctor selectDoctor(Date date,int timeSlot) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date consultationDate = null;
        //removing booked doctors from available doctors list
        ArrayList<Doctor> bookedDoctors = new ArrayList<>();
        ArrayList<Doctor> availableDoctors = new ArrayList<>(doctorArrayList);
        for(Consultation consultation:consultationArrayList){
            consultationDate = formatter.parse(formatter.format(consultation.getNew_date()));
            if(consultationDate.equals(date) && consultation.getTimeslot() == timeSlot){
                Doctor doctor1 = consultation.getNew_Doctor();
                bookedDoctors.add(doctor1);
            }
        }
        for (Doctor availableDoctor : availableDoctors){
            for (Doctor bookedDoctor: bookedDoctors){
                if(availableDoctor.getSurName().equals(bookedDoctor.getSurName()) && availableDoctor.getFirstName().equals(bookedDoctor.getFirstName())){
                    availableDoctors.remove(availableDoctor);
                }
            }
        }
        //assigning new doctor from available doctors list
        int doctorIndex = (int)(Math.random()*(availableDoctors.size()-1));
        System.out.println(doctorIndex);
        return availableDoctors.get(doctorIndex);
    }
}