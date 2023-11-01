package org.example;

public enum SubjectPositions {
    Math(1),
    Science(2),
    Japanese(3),
    Geography(4);



    public final int position;

    SubjectPositions( int position) {
        this.position = position;
    }
}
