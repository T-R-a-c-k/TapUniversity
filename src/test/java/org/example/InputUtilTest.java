package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InputUtilTest {
    @Test(expected = IllegalArgumentException.class)
    public void gradesMustBeSameLength(){
        List<String> values = new ArrayList<>();

        values.add("s 70 78 82 58");
        values.add("l 68 81 81 60 78");
        values.add("s 63 76 55 80 75");
        values.add("s 90 100 96 10 10");
        values.add("l 88 78 81 97 93");

        List<Student> students = InputUtil.listToStudentList(values);
    }
}