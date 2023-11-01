package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InputUtil {
    private static Student stringToStudent(String current){
        int abbreviationAndSpace = 2;
        if(current.length() < abbreviationAndSpace)
            throw new IllegalArgumentException("The current input does not contain more than the abbreviation");

        String studentMajor = String.valueOf(current.charAt(0));
        String newCurrent = current.substring(abbreviationAndSpace);
        List<String> studentGradesString = Arrays.asList(newCurrent.split(" "));
        List<Integer> studentGradesInt = studentGradesString.stream().mapToInt(Integer::parseInt).boxed().toList();

        HashMap<Subjects, Integer> gradeHashMap = new HashMap<>();

        for(int i = 0; i < studentGradesInt.size(); i++)
            gradeHashMap.put(Subjects.values()[i], studentGradesInt.get(i));

        return new Student(studentMajor, gradeHashMap);
    }
    public static List<Student> cmdInputToStudentList(){
        List<Student> students = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            int lines = Integer.parseInt(reader.readLine().trim());

            for(int i = 0; i < lines; i++){
                String currentInput = reader.readLine();
                students.add(stringToStudent(currentInput));
            }

        } catch (IOException e){
            System.out.println("Could not read in contents");
        }
        return students;
    }

    public static List<Student> listToStudentList(List<String> studentStrings){
        List<Student> students = new ArrayList<>();
        studentStrings.forEach(studentString -> students.add(stringToStudent(studentString)));
        return students;
    }
}
