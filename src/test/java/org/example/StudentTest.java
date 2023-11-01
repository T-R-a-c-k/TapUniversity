package org.example;


import org.junit.Test;

import java.util.*;

public class StudentTest {
    @Test
    public void studentOverallGradeIsProperlyCalculated(){
        String abbreviation = Division.Science.divisionAbbreviation;
        List<Integer> grades = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );

        HashMap<Subjects, Integer> gradeHashMap = new HashMap<>();

        for(int i = 0; i < grades.size(); i++)
            gradeHashMap.put(Subjects.values()[i], grades.get(i));

        Student s = new Student(abbreviation, gradeHashMap);
        assert s.majorAbbreviation.equals(abbreviation);
        assert Objects.equals(s.subjectGrades.get(Subjects.Math), gradeHashMap.get(Subjects.Math));
        assert Objects.equals(s.studentTotalGrade(), grades.stream().reduce(0, Integer::sum));
        assert s.studentMajorGrade() == s.subjectGrades.get(Subjects.Math) + s.subjectGrades.get(Subjects.Science);
    }

    @Test(expected = IllegalArgumentException.class)
    public void studentAbbreviationIsNotInDivisions(){
        String fake_abbreviation = "something that surely wont work";
        List<Integer> grades = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );
        HashMap<Subjects, Integer> gradeHashMap = new HashMap<>();

        for(int i = 0; i < grades.size(); i++)
            gradeHashMap.put(Subjects.values()[i], grades.get(i));

        Student s = new Student(fake_abbreviation, gradeHashMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void studentGradesAreNotSameLengthAsSubjects(){
        String abbreviation = Division.Science.divisionAbbreviation;
        List<Integer> bad_grades = new ArrayList<>(
                Arrays.asList(1,2,3)
        );

        HashMap<Subjects, Integer> gradeHashMap = new HashMap<>();

        bad_grades.forEach(grade -> gradeHashMap.put(
                Subjects.values()[bad_grades.indexOf(grade)], grade));

        Student s = new Student(abbreviation, gradeHashMap);
    }
}