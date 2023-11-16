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
        int studentGrade;
        int StudentNumber = 0;
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
                    System.out.println(AverageGrade);
                    break;
                }

                if(StudentNumber == 0){
                    System.out.println("There was no data given, have a nice day");
                    break;
                }
            }

            System.out.println("Enter the student grade:  ");

            studentGrade = gradeInput.nextInt();
            TotalGrades += studentGrade;
            StudentNumber++;

            System.out.println("Student Name: " + studentName + " Student Grade: " + studentGrade + " Student Number: " + StudentNumber);

        }
        studentNameInput.close();
        gradeInput.close();
    }
}
