package GUi_part;

import base.Doctor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ViewDoctorModel extends AbstractTableModel {
    private final String[] columnNames = {"Name", "M.Licence number", "Specialization"};
    private ArrayList <Doctor> myList;

    public ViewDoctorModel(ArrayList <Doctor> bkList) {
        myList = bkList;
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return myList.size();
    }
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
          //  Doctor doctor = myList.get(row);
            temp = myList.get(row).getFirstName() +"  "+ myList.get(row).getSurName();
        }
        else if (col == 1) {
            temp = myList.get(row).getMedicalLicenceNumber();
        }
        else if (col == 2) {
            temp = new String(myList.get(row).getSpecialization());
        }
        return temp;
    }
    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col) {
        return String.class;

    }
}



