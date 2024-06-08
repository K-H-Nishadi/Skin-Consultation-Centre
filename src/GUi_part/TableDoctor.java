package GUi_part;

import base.Doctor;
import base.DoctorComparator;
import base.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TableDoctor extends JFrame implements ActionListener {

JButton btnback;
    public TableDoctor(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        Doctor[] currentDoctors = WestminsterSkinConsultationManager.getListOfDoctors();
        for (int i = 0; i < currentDoctors.length; i++) {
            if (currentDoctors[i]!=null) doctors.add(currentDoctors[i]);
        }
        doctors.sort(new DoctorComparator());

        ViewDoctorModel model = new ViewDoctorModel(doctors);
        JTable grid = new JTable(model);
        btnback= new JButton("Back");
        JPanel jpannel2 = new JPanel();
        add(jpannel2);

        jpannel2.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

        con.insets = new Insets(10,10,0,10);

        con.gridx = 1;
        con.gridy = 0;
        jpannel2.add(grid.getTableHeader(), con);

        con.gridx = 1;
        con.gridy = 1;
        jpannel2.add(grid, con);

        con.insets = new Insets(20,170,10,20);

        con.gridx = 1;
        con.gridy = 2;
        jpannel2.add(btnback, con);

        pack();
        setVisible(true);
        jpannel2.setBackground(Color.lightGray);
        btnback.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnback){
            this.dispose();
            new Home();
        }
    }
}
