## Tap University Test Solution

This MD aims to highlight my thought process in regards to the test case provided from Tap. 

## Table of Contents

- [Main.java](#mainjava)
- [InputUtil.java](#inpututiljava)
- [SubjectPositions.java](#SubjectPositions)
- [PassingCalculator.java](#passingcalculatorjava)
- [Student.java](#studentjava)
- [Division.java](#divisionjava)
- [Maintainability](#Maintainability)
- [Scalability](#Scalability)

## Main.java

Simple driver code that uses `InputUtil` so `Student` objects could be created and passed to the `PassingCalculator` to solve the case.
No logic is placed in this file.

## InputUtil.java

`InputUtil` contains the methods used to allow for command line input and to take a list of strings and return a `Student`(s) object.
The goal was to make the actual classes which process data (`PassingCalculator`, `Student`) as agnostic to the way input data is formatted.
This allows for those classes to be able to plugged into anywhere in the system.

## SubjectPositions.java

Originally just an enum containing the 5 input subjects but the test case asks for up to 100 so this has been refactored into a simple subject name holding its position in the list.
As we cant just sum up all the values to pass this case, there needs to be some means to remember the position of a subject for a specific grade.
In this example, the `Division` needs to know about, science, math, Japanese and geography's places. Thus unfortunately meaning `SubjectPosition` dictates where that subject is located in the list rather than having input dictate subject itself.
If the input came in the form of `subjectName : grade`, this would not be needed. 

## PassingCalculator.java

`PassingCalculator` simply contains methods to compare if a `Student`(s) grades for a major (ie Math / Science) are above the `Division`'s required grade and the overall required grade to pass.
If some form of change to how grades are calculated the implementation can be easily changing within the studentPassed function.
Takes in an integer as an overall minimum grade that students must achieve to pass.

## Student.java

The main information carrying class of the program. Designed to hold all the grades, retrieve grades in total or per subject of major and hold the `Division`.
Aims to make finding the grades of a `Division` as fast as possible by mapping `SubjectPosition` to a grade integer hash map.
Takes in a string abbreviation and hashmap of subjects to integers.


## Division.java

Contains the String abbreviation, integer passing grade and `SubjectPositions`(s) that are within a division.
The main goal with using an enum over a class was to allow easy inumeration over the fields that are located within the division.
If the case required having many more divisions, it would not have been as simple to throw all of the data into a single enum type.
The automation could be easily achieved by taking in whatever (most likely specific division based input) and switching from enum to class.

## Maintainability

Overall I believe the code to be self documenting and to be straightforward enough to not need comments anywhere. Tests accompany this to ensure any iteration following this will still pass the problem statement.

## Scalability

This portion I believe to be most likely the most lacking in the project. 
If scalability was to measured in SRE (site reliability engineering), many functions choice run time maybe be better optimized with different collections and changing how certain exceptions are checked (currently all grades have to be the same length so theres an iteration over them an additional time)
Many exceptions are also thrown but the system doesn't gracefully fail.
The other option that seems most obvious would be to apply some form of divide and conquer strategy for summation of the grades. I do however believe that given the problem statement, this is most likely a premature optmization and I would much rather be told explicitly this needs to change.
