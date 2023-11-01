package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Student {
    public final String majorAbbreviation;
    public final HashMap<Integer, Integer> subjectGrades;
    public final Division studentDivision;
    public Student(String majorAbbreviation, HashMap<Integer, Integer> subjectGrades){
        this.majorAbbreviation = majorAbbreviation;
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
        for(SubjectPositions subject : this.studentDivision.divisionSubjectsPositions){
            sum += this.subjectGrades.get(subject.position);
        }

        return sum;
    }
}