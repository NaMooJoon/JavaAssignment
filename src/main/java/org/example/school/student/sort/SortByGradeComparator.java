package org.example.school.student.sort;

import java.util.Comparator;
import org.example.school.student.Student;

public class SortByGradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGrade() == o2.getGrade()) {
            return o2.getName().compareTo(o1.getName());
        }
        return o1.getGrade() - o2.getGrade();
    }
}
