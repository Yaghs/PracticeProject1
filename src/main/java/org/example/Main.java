package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // create a small program that takes in the number of students
        //and their grades and calculates their average and ends the loop based on the command "end"
        //do something for the scenario if the student name is "end"

        double AverageGrade = 0.0;
        int TotalGrades = 0;
        int studentGrade = 0;
        int StudentNumber = 0;
        String letterGrade;

        String End = "end";
        String studentName;

        Scanner studentNameInput = new Scanner(System.in);
        Scanner gradeInput = new Scanner(System.in);
        System.out.println("Welcome, To end the program, simply type end");


        while(true){
            System.out.println("Enter the student name:  ");

            studentName = studentNameInput.nextLine();



            if(End.equalsIgnoreCase(studentName)){
                if(StudentNumber > 0) {
                    AverageGrade = (double) TotalGrades / StudentNumber;
                    System.out.println("Average Grade is " + AverageGradeLetter(AverageGrade));
                    break;
                }

                if(StudentNumber == 0){
                    System.out.println("There was no data given, have a nice day");
                    break;
                }
            }

            if(studentName.matches(".*\\\\d.*")){
                System.out.println("Please enter a valid name(no digits please)");
                continue;
            }

            System.out.println("Enter the student grade:  ");


            while(!gradeInput.hasNextInt()){
                System.out.println("Please enter a valid grade(no words or letters please)");
                gradeInput.next();
            }
            studentGrade = gradeInput.nextInt();
            TotalGrades += studentGrade;
            StudentNumber++;
            gradeResult(studentName, studentGrade, StudentNumber);
        }
        studentNameInput.close();
        gradeInput.close();
    }
    public static void gradeResult(String studentName, int studentGrade, int studentNumber) {
        String letterGrade;
        if (studentGrade >= 91) {
            letterGrade = "A";
        } else if (studentGrade >= 80) {
            letterGrade = "B";
        } else if (studentGrade >= 70) {
            letterGrade = "C";
        } else if (studentGrade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        System.out.println("Student Name: " + studentName + ", Grade: " + studentGrade + ", Letter Grade: " + letterGrade + ", Student Number: " + studentNumber);
    }

    public static String AverageGradeLetter(double gradeAverage){
        String letterGrade;
        if (gradeAverage >= 91) {
            letterGrade = "A";
        } else if (gradeAverage >= 80) {
            letterGrade = "B";
        } else if (gradeAverage >= 70) {
            letterGrade = "C";
        } else if (gradeAverage >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }
    }
