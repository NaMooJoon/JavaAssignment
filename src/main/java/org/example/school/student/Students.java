package org.example.school.student;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.example.school.student.constants.StudentType;
import org.example.school.student.sort.SortByGradeComparator;

public class Students {

    private final List<Student> students;

    public Students(List<Student> students) {
        this.students = students;
    }

    public int getSize() {
        return students.size();
    }

    public Student getStudentAt(int idx) {
        return students.get(idx);
    }

    public List<Student> getStudentsOfFemale() {
        return students.stream()
                .filter(Student::isFemale)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsOfMale() {
        return students.stream()
                .filter(Student::isMale)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByClassNumber(int classNum) {
        return students.stream()
                .filter(st -> st.getClassNumber() == classNum)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByType(StudentType type) {
        return students.stream()
                .filter(st -> st.getType() == type)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsWithSameName() {
        List<Student> ret = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            String name1 = students.get(i).getName();
            for (int j = i + 1; j < students.size(); j++) {
                String name2 = students.get(j).getName();
                if (name1.equals(name2)) {
                    ret.add(students.get(i));
                    ret.add(students.get(j));
                }
            }
        }
        return ret;
    }

    public void sortByGrade() {
        SortByGradeComparator sorter = new SortByGradeComparator();
        sort(students, sorter);
    }

    @Override
    public String toString() {
        String s = "[";
        for (Student student : students) {
            s += " " + student.getName();
        }
        s += "]";
        return s;
    }
}
