package org.example;

import java.util.List;

public class PassingCalculator {
    private final int overallPassingGrade;
    public PassingCalculator(int overallPassingGrade){
        this.overallPassingGrade = overallPassingGrade;
    }

    public boolean studentPassed(Student student) {
        return student.studentMajorGrade() >= student.studentDivision.divisionPassingGrade &&
                student.studentTotalGrade() >= this.overallPassingGrade;
    }

    public int numberOfStudentsPassed(List<Student> students){
        return  (int) students.stream()
                .filter(this::studentPassed)
                .count();

    }
}
