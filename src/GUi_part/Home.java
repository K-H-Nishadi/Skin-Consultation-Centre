package GUi_part;
import base.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

public class Home extends JFrame implements ActionListener {

    JButton view_Consultant, add_Consultant, view_Doctor, exit;

    public Home() {

        JPanel jPanel = new JPanel();
        add(jPanel);

        JLabel backGround = new JLabel();
        backGround.setSize(700,400);
        Image image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/GUi_part/images/image Skincare.jpeg"))).getImage();
        Image imageSize = image.getScaledInstance(backGround.getWidth(),backGround.getHeight(),Image.SCALE_SMOOTH);
        backGround.setIcon(new ImageIcon(imageSize));



        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints gContains = new GridBagConstraints();



        view_Consultant = new JButton("View Consultation");
        add_Consultant = new JButton("Add Consultation");
        view_Doctor = new JButton("View Doctor");
        exit = new JButton("Exit");



        gContains.insets = new Insets(1, 1, 1, 1);
        gContains.gridwidth = 7;
        gContains.gridx = 0;
        gContains.gridy = 0;
        jPanel.add(backGround, gContains);

        gContains.fill = GridBagConstraints.HORIZONTAL;

        gContains.insets = new Insets(1, 1, 1, 350);
        gContains.gridx = 0;
        gContains.gridy = 1;
        jPanel.add(view_Consultant, gContains);

        gContains.gridx = 0;
        gContains.gridy = 2;
        jPanel.add(add_Consultant, gContains);

        gContains.insets = new Insets(0, 350, 1, 1);
        gContains.gridx = 1;
        gContains.gridy = 1;
        jPanel.add(view_Doctor, gContains);

        gContains.gridx = 1;
        gContains.gridy = 2;
        jPanel.add(exit, gContains);


        view_Consultant.addActionListener(this);
        add_Consultant.addActionListener(this);
        view_Doctor.addActionListener(this);
        exit.addActionListener(this);

        pack();
        this.setTitle("Westminster Skin Consultation Manager");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_Consultant) {
            new AddConsultation();
            this.dispose();

        } else if (e.getSource() == view_Consultant) {
            new ConsultationTable();
            this.dispose();

        }else if(e.getSource() == view_Doctor){
            new TableDoctor();
            this.dispose();

        }else if (e.getSource() == exit) this.dispose();
    }
}
