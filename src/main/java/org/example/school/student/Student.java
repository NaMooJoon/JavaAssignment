package org.example.school.student;

import org.example.school.student.constants.StudentType;

public class Student {

    private String name;
    private boolean isMale;
    private int grade;
    private StudentType type;
    private int classNumber;


    private Student() {}

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public boolean isFemale() {
        return !isMale;
    }

    public int getGrade() {
        return grade;
    }

    public StudentType getType() {
        return type;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Student student = new Student();

        public Builder name(String name) {
            student.name = name;
            return this;
        }

        public Builder isMale(boolean isMale) {
            student.isMale = isMale;
            return this;
        }

        public Builder grade(int grade) {
            student.grade = grade;
            return this;
        }

        public Builder type(StudentType type) {
            student.type = type;
            return this;
        }

        public Builder classNumber(int classNumber) {
            student.classNumber = classNumber;
            return this;
        }

        public Student build() {
            return student;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", grade=" + grade +
                ", type=" + type +
                ", classNumber=" + classNumber +
                '}';
    }
}