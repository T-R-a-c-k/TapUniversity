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

        HashMap<Integer, Integer> gradeHashMap = new HashMap<>();

        for (int i = 0; i < grades.size(); i++)
            gradeHashMap.put(i, grades.get(i));

        Student s = new Student(abbreviation, gradeHashMap);

        assert passingCalculator.studentPassed(s);
    }

    @Test
    public void studentFails() {
        String abbreviation = Division.Science.divisionAbbreviation;
        List<Integer> failing_grades = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0)
        );

        HashMap<Integer, Integer> gradeHashMap = new HashMap<>();

        for (int i = 0; i < failing_grades.size(); i++)
            gradeHashMap.put(i, failing_grades.get(i));

        Student s = new Student(abbreviation, gradeHashMap);

        assert !passingCalculator.studentPassed(s);
    }

    @Test
    public void studentsPass() {
        String abbreviation = Division.Science.divisionAbbreviation;
        List<Integer> grades = new ArrayList<>(
                Arrays.asList(70, 78, 82, 57, 74)
        );

        HashMap<Integer, Integer> gradeHashMap = new HashMap<>();

        for (int i = 0; i < grades.size(); i++)
            gradeHashMap.put(i, grades.get(i));

        Student s = new Student(abbreviation, gradeHashMap);

        List<Student> students = new ArrayList<>();
        students.add(s);
        students.add(s);
        students.add(s);

        assert passingCalculator.numberOfStudentsPassed(students) == students.size();
    }

    @Test
    public void threeStudentsOfTwentyPass(){
        List<String> values = new ArrayList<>();
        values.add("l 100 67 39 85 87");
        values.add("s 38 75 75 45 90");
        values.add("l 43 95 7 35 49");
        values.add("l 82 77 74 35 44");
        values.add("s 96 80 92 58 84");
        values.add("l 23 60 44 27 3");
        values.add("l 42 24 52 23 63");
        values.add("s 44 78 98 51 10");
        values.add("l 93 38 73 88 12");
        values.add("l 34 29 43 48 61");
        values.add("l 83 33 97 3 59");
        values.add("l 24 84 22 35 33");
        values.add("s 81 42 80 34 87");
        values.add("l 8 87 82 80 100");
        values.add("l 48 75 75 3 50");
        values.add("l 93 76 25 71 31");
        values.add("s 60 92 64 66 11");
        values.add("l 61 47 6 21 83");
        values.add("l 68 1 47 81 78");
        values.add("l 8 72 54 20 25");

        List<Student> students = InputUtil.listToStudentList(values);
        assert passingCalculator.numberOfStudentsPassed(students) == 3;
    }
    @Test
    public void twoStudentsOfFivePass(){
        List<String> values = new ArrayList<>();

        values.add("s 70 78 82 57 74");
        values.add("l 68 81 81 60 78");
        values.add("s 63 76 55 80 75");
        values.add("s 90 100 96 10 10");
        values.add("l 88 78 81 97 93");

        List<Student> students = InputUtil.listToStudentList(values);
        assert passingCalculator.numberOfStudentsPassed(students) == 2;
    }

    @Test
    public void twoStudentOfTenPasses_usesDifferentScoring(){
        overallPassingGrade = 1200;
        passingCalculator = new PassingCalculator(overallPassingGrade);

        List<String> values = new ArrayList<>();
        values.add("s 70 78 82 57 74 69 83 91 56 65 73 77 88 90 85");
        values.add("l 68 81 81 60 78 63 76 74 71 75 80 79 72 69 85");
        values.add("s 63 76 55 80 75 72 68 62 79 74 80 61 90 84 77");
        values.add("s 90 100 96 10 10 45 78 86 72 89 96 81 95 75 60");
        values.add("l 88 78 81 97 93 76 81 75 62 64 80 88 91 94 87");
        values.add("s 70 78 82 57 74 69 83 91 56 65 73 77 88 90 85");
        values.add("l 68 81 81 60 78 63 76 74 71 75 80 79 72 69 85");
        values.add("s 63 76 55 80 75 72 68 62 79 74 80 61 90 84 77");
        values.add("s 90 100 96 10 10 45 78 86 72 89 96 81 95 75 60");
        values.add("l 88 78 81 97 93 76 81 75 62 64 80 88 91 94 87");

        List<Student> students = InputUtil.listToStudentList(values);
        assert passingCalculator.numberOfStudentsPassed(students) == 2;
    }
}