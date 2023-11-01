package org.example;

import java.util.List;
public class Main {

    public static void main(String[] args) {
        final int totalPassingGrade = 350;
        List<Student> students = InputUtil.cmdInputToStudentList();
        PassingCalculator passingCalculator = new PassingCalculator(totalPassingGrade);
        System.out.println(passingCalculator.numberOfStudentsPassed(students));
    }
}