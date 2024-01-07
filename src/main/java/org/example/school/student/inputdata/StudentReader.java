package org.example.school.student.inputdata;

import java.io.IOException;
import org.example.school.student.Student;
import org.example.school.student.constants.StudentType;

public class StudentReader {

    Reader reader;

    public StudentReader(Reader reader) throws IOException {
        this.reader = reader;
    }

    public Student nextStudent() {
        String[] line = reader.nextRead();
        if (line != null && line.length >= 5) {
            String name = line[0];
            String sex = line[1];
            String grade = line[2];
            String type = line[3];
            String classNum = line[4] == ""? "0" : line[4];

            return Student.builder()
                    .name(name)
                    .isMale(sex.equals("male"))
                    .grade(Integer.parseInt(grade))
                    .type(StudentType.of(type))
                    .classNumber(Integer.parseInt(classNum))
                    .build();
        }
        return null;
    }
}
