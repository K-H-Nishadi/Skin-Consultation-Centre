package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private String firstName;
    private String surName;
    private Date dob;
    private String mobileNumber;
    private String address;


    public Person(String firstname, String surName, Date dob, String mobileNumber) {
        this.firstName = firstname;
        this.surName = surName;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
    }
    //check blank or not
    public static boolean name_Validate(String firstName, String surName){
        if(firstName.equals("")||surName.equals("")){
            return false;
        }else{
            return true;
        }
    }
    public static Date dob_Validation(String dob) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
            return format.parse(dob);

        }catch (ParseException e){
            return null;
        }
    }
    public static boolean mobile_Number_Validate(String mobileNumber){
        if(mobileNumber.equals(" ")){
            return false;
        }else{
            return true;
        }
    }
    public static boolean address_Validate(String address){
        if(address.equals("")){
            return false;
        }else{
            return true;
        }
    }
    public Person(){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setDob(String dob) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.dob = formatter.parse(dob);


    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = String.valueOf(mobileNumber);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "\nFirst Name = " + firstName +
                "\nSur Name = " + surName +
                "\nDate Of Berth = " + formatter.format(dob) +
                "\nMobile Number = " + mobileNumber +
                "\nAddress = " + address ;
    }
}
