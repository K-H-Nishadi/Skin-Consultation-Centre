package GUi_part;

import base.Consultation;
import base.WestminsterSkinConsultationManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultationTable extends JFrame implements ActionListener {
    JTable table;
    JButton button,viewButton;


    private ArrayList<Consultation>Consultation_list= WestminsterSkinConsultationManager.consultationArrayList;

    public ConsultationTable() {
        this.setTitle("View Consultation");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().setLayout(null);
        this.setBounds(300, 50, 400, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Object[] columns = {"Patient Name", "Doctor Name", "Date", "Time", "Cost","Note"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        Object[] rowData = new Object[7];

        for (Consultation consultation : Consultation_list) {
            rowData[0] = consultation.getNew_Patient().getFirstName();
            rowData[1] = consultation.getNew_Doctor().getSurName();
            rowData[2] = consultation.getNew_date();
            rowData[3] = consultation.getTimeslot();
            rowData[4] = consultation.getCost();
            rowData[5] = consultation.getNotes();

            model.addRow(rowData);

        }
        table = new JTable();
        table.setModel(model);


        table.setRowHeight(30);
        table.setBounds(0,0,400,240);


        button = new JButton();
        button.setText("Back");
        button.setBounds(300,240,80,20);
        button.addActionListener(this);

        viewButton = new JButton();
        viewButton.setText("View Image");
        viewButton.setBounds(170,240,110,20);
        viewButton.addActionListener(this);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,400,240);

        this.add(sp);
        this.add(button);
        this.add(viewButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button){
            this.dispose();
            new Home();
        }
        if(e.getSource()== viewButton){
            this.dispose();
            int i = table.getSelectedRow();
            new ViewImage(i);
            //new Show_Image();
        }
    }
}
