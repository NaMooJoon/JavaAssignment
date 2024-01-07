package org.example.school.student;

import java.util.List;

public class ClassAssignment {

    private int numberOfClass;
    private Students wholeStudent;

    private ClassAssignment() {}

    public static Builder builder() {
        return new Builder();
    }

    public void assignClassNumberToEachStudents() {
        wholeStudent.sortByGrade();
        List<Student> female = wholeStudent.getStudentsOfFemale();
        List<Student> male = wholeStudent.getStudentsOfMale();

        int startClass = 1;
        int dir = 1;
        assignClassForFairGradeDistribution(female, startClass, dir);

        startClass = numberOfClass;
        dir = -1;
        assignClassForFairGradeDistribution(male, startClass, dir);
    }

    private void assignClassForFairGradeDistribution(List<Student> male, int assignedClass, int dir) {
        for (Student st : male) {
            st.setClassNumber(assignedClass);
            assignedClass += dir;
            if (assignedClass > numberOfClass) {
                assignedClass = numberOfClass;
                dir = -1;
            }
            if (assignedClass < 1) {
                assignedClass = 1;
                dir = 1;
            }
        }
    }

    public static class Builder {

        private ClassAssignment classAssignment = new ClassAssignment();

        public Builder numberOfClass(int numberOfClass) {
            classAssignment.numberOfClass = numberOfClass;
            return this;
        }

        public Builder wholeStudent(Students wholeStudent) {
            classAssignment.wholeStudent = wholeStudent;
            return this;
        }

        public ClassAssignment build() {
            return classAssignment;
        }

    }
}
