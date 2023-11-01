package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Student {
    public final String majorAbbreviation;
    public final HashMap<Subjects, Integer> subjectGrades;
    public final Division studentDivision;
    public Student(String majorAbbreviation, HashMap<Subjects, Integer> subjectGrades){
        this.majorAbbreviation = majorAbbreviation;

        if(subjectGrades.size() < Subjects.values().length)
            throw new IllegalArgumentException("This student is missing certain subject grades");

        this.subjectGrades = subjectGrades;

        List<Division> divisionList = Arrays.stream(Division.values()).toList();
        Division studentsDivision = divisionList.stream()
                .filter(division -> division.divisionAbbreviation.equals(majorAbbreviation))
                .findFirst()
                .orElse(null);

        if(studentsDivision == null)
            throw new IllegalArgumentException("This student's abbreviation does not match any division's abbreviation");

        this.studentDivision = studentsDivision;
    }

    public int studentTotalGrade(){
        return this.subjectGrades.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    public int studentMajorGrade(){

        int sum = 0;
        for(Subjects subject : this.studentDivision.divisionSubjects){
            sum += this.subjectGrades.get(subject);
        }

        return sum;
    }
}