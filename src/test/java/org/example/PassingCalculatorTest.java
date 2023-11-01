package org.example;


import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class PassingCalculatorTest {
    static int overallPassingGrade;
    static PassingCalculator passingCalculator = null;

    @BeforeClass
    public static void init() {
        overallPassingGrade = 350;
        passingCalculator = new PassingCalculator(overallPassingGrade);
    }

    @Test
    public void studentPasses() {
        String abbreviation = Division.Science.divisionAbbreviation;
        List<Integer> grades = new ArrayList<>(
                Arrays.asList(70, 78, 82, 57, 74)
        );

        HashMap<Subjects, Integer> gradeHashMap = new HashMap<>();

        for (int i = 0; i < grades.size(); i++)
            gradeHashMap.put(Subjects.values()[i], grades.get(i));

        Student s = new Student(abbreviation, gradeHashMap);

        assert passingCalculator.studentPassed(s);
    }

    @Test
    public void studentFails() {
        String abbreviation = Division.Science.divisionAbbreviation;
        List<Integer> failing_grades = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0)
        );

        HashMap<Subjects, Integer> gradeHashMap = new HashMap<>();

        for (int i = 0; i < failing_grades.size(); i++)
            gradeHashMap.put(Subjects.values()[i], failing_grades.get(i));

        Student s = new Student(abbreviation, gradeHashMap);

        assert !passingCalculator.studentPassed(s);
    }

    @Test
    public void studentsPass() {
        String abbreviation = Division.Science.divisionAbbreviation;
        List<Integer> grades = new ArrayList<>(
                Arrays.asList(70, 78, 82, 57, 74)
        );

        HashMap<Subjects, Integer> gradeHashMap = new HashMap<>();

        grades.forEach(grade -> gradeHashMap.put(
                Subjects.values()[grades.indexOf(grade)], grade));

        Student s = new Student(abbreviation, gradeHashMap);

        List<Student> students = new ArrayList<>();
        students.add(s);
        students.add(s);
        students.add(s);

        assert passingCalculator.numberOfStudentsPassed(students) == students.size();
    }
}