package base;

import java.util.Comparator;

public class DoctorComparator implements Comparator<Doctor> {
    @Override
    public int compare(Doctor o1, Doctor o2) {
        return o1.getSurName().compareTo(o2.getSurName());
    }
}
