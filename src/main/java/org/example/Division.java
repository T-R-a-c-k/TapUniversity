package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public enum Division {
    Science("s",
            new ArrayList<>(
                    Arrays.asList(SubjectPositions.Math, SubjectPositions.Science)
            ),
            160),
    Humanity("l",
            new ArrayList<>(
                    Arrays.asList(SubjectPositions.Japanese, SubjectPositions.Geography)
            ),
            160);

    public final String divisionAbbreviation;
    public final ArrayList<SubjectPositions> divisionSubjectsPositions;
    public final int divisionPassingGrade;

    Division(String divisionAbbreviation, ArrayList<SubjectPositions> divisionSubjects, int divisionPassingGrade) {
        this.divisionAbbreviation = divisionAbbreviation;
        this.divisionSubjectsPositions = divisionSubjects;
        this.divisionPassingGrade = divisionPassingGrade;
    }
}
