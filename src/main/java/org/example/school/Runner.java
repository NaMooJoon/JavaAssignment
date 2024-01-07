package org.example.school;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.school.student.ClassAssignment;
import org.example.school.student.Student;
import org.example.school.student.Students;
import org.example.school.student.constants.StudentType;
import org.example.school.student.inputdata.Reader;
import org.example.school.student.inputdata.ReaderCSV;
import org.example.school.student.inputdata.StudentReader;

public class Runner {
    static final int TOTAL_CLASS = 4;
    static final String FILE_PATH = "./src/main/java/org/example/school/student/inputdata/student-data.csv";

    private Students wholeStudents;
    private ClassAssignment office;

    public Runner() throws IOException {
        Reader reader = new ReaderCSV(FILE_PATH);
        StudentReader studentReader = new StudentReader(reader);
        List<Student> studentList = readStudentData(studentReader);

        wholeStudents = new Students(studentList);
        office = ClassAssignment.builder()
                    .wholeStudent(wholeStudents)
                    .numberOfClass(TOTAL_CLASS)
                    .build();
    }

    void run() {
        printGreeting();
        printAllInformation();

        office.assignClassNumberToEachStudents();

        printHead("Class 1", wholeStudents.getStudentsByClassNumber(1), 5);
        printHead("Class 2", wholeStudents.getStudentsByClassNumber(2), 5);
        printHead("Class 3", wholeStudents.getStudentsByClassNumber(3), 5);
        printHead("Class 4", wholeStudents.getStudentsByClassNumber(4), 5);

    }


    private void printAllInformation() {
        // sorting
        wholeStudents.sortByGrade();
        printHead("After sorting by grade", wholeStudents, 5);

        // sex information
        printHead("Only female", wholeStudents.getStudentsOfFemale(), 5);
        printHead("Only male", wholeStudents.getStudentsOfMale(), 5);

        // type (Normal, black, white) information
        printHead("Only normal students (except for white and black studnet)",
                wholeStudents.getStudentsByType(StudentType.NORMAL), 5);
        printHead("Only Black List students",
                wholeStudents.getStudentsByType(StudentType.BLACK), 5);
        printHead("Only White List students",
                wholeStudents.getStudentsByType(StudentType.WHITE), 5);

        // same name
        printHead("Student List who have same name", wholeStudents.getStudentsWithSameName(), 6);
    }

    private void printGreeting() {
        System.out.println("=================================================");
        System.out.println("       STUDENT CLASS ASSIGNMENT PROGRAM");
        System.out.println("=================================================");
        System.out.println();
    }

    private void printHead(String message, Students students, int size) {
        System.out.println("****************************************************");
        System.out.println(message);
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ": " + students.getStudentAt(i));
        }
        System.out.println();
    }

    private void printHead(String message, List<Student> students, int size) {
        System.out.println("****************************************************");
        System.out.println(message);
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ": " + students.get(i));
        }
        System.out.println();
    }

    private List<Student> readStudentData(StudentReader reader) {
        List<Student> students = new ArrayList<>();
        Student nextStudent;

        while ((nextStudent = reader.nextStudent()) != null) {
            students.add(nextStudent);
        }
        return students;
    }
}
