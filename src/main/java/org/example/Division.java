package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public enum Division {
    Science("s",
            new ArrayList<>(
                    Arrays.asList(Subjects.Math, Subjects.Science)
            ),
            160),
    Humanity("l",
            new ArrayList<>(
                    Arrays.asList(Subjects.Japanese, Subjects.Geography)
            ),
            160);

    public final String divisionAbbreviation;
    public final ArrayList<Subjects> divisionSubjects;
    public final int divisionPassingGrade;

    Division(String divisionAbbreviation, ArrayList<Subjects> divisionSubjects, int divisionPassingGrade) {
        this.divisionAbbreviation = divisionAbbreviation;
        this.divisionSubjects = divisionSubjects;
        this.divisionPassingGrade = divisionPassingGrade;
    }
}
