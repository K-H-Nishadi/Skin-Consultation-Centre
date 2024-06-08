package GUi_part;

import base.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewImage extends JFrame implements ActionListener {

    JButton backButton;

    public ViewImage(int i){
        String decryptedPath = "";
        AESEncryptionDecryption encryptionDecryption = new AESEncryptionDecryption();
        String encryptedPath = WestminsterSkinConsultationManager.consultationArrayList.get(i).getImagePath();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setTitle("Details");
        this.setBounds(440,150,400,400);

        JLabel label1 = new JLabel();
        label1.setBounds(30,20,300,300);
        if (encryptedPath.equals("")){
            label1.setText("No image found");
        }else {
            decryptedPath = encryptionDecryption.decrypt(encryptedPath,"secrete");
            Image image = new ImageIcon(decryptedPath).getImage();
            Image imageSize = image.getScaledInstance(label1.getWidth(),label1.getHeight(),Image.SCALE_SMOOTH);
            label1.setIcon(new ImageIcon(imageSize));
        }

        backButton = new JButton();
        backButton.setBounds(270,330,100,25);
        backButton.setText("Back");
        backButton.addActionListener(this);
        this.getContentPane().add(backButton);

        this.getContentPane().add(label1);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            this.dispose();
            new ConsultationTable();
        }
    }
}
