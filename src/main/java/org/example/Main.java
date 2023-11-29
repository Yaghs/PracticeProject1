package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // create a small program that takes in the number of students
        //and their grades and calculates their average and ends the loop based on the command "end"
        //do something for the scenario if the student name is "end"


        //STEP 1: initialize primitive data types and set the values of each variable to its default state.
        //AverageGrade is meant for the total average of the collective grades during execution
        double AverageGrade = 0.0;
        //TotalGrades is the collection of all grades collected (this is needed for the grade average)
        int TotalGrades = 0;
        //student grade is set to 0 until user adds the correct grade for the student
        double studentGrade = 0;
        //total number of students that have a grade inside the loop
        int StudentNumber = 0;
        // letter grade for the numerical value set for the student grade
        String letterGrade;

        //the variable for the user to add in the necessary information to put whos grade belongs to whom
        String studentName;
        //scanner is like cin from c++, you input a value and it will take it but with an extra step(line 41)
        Scanner studentNameInput = new Scanner(System.in);
        // as explained in line 28, but in this instance we are taking in a numerical value for the grade
        Scanner gradeInput = new Scanner(System.in);
        // it simply prints out that if you want to break the loop just type in end
        System.out.println("Welcome, To end the program, simply type end");

        //in order to start the cycle to add more students into the terminal we need a loop, a while loop will suffice
        //NOTE: BEST NOT TO OVERUSE LOOPING, A LOOP INSIDE A LOOP (NESTED LOOP) HAS A BIG O OF N^2, BAD IDEA FOR OPTIMIZATION IF ONE WANTS TO RUN CODE FASTER
        while(true){
            // prints out asking to enter the student Name
            System.out.print("Enter the student name:  ");
            //allows the user to input the necessary data
            studentName = studentNameInput.nextLine();


            // if there is no longer any students to add, user can type end
            if("End".equalsIgnoreCase(studentName)){
                //if there is existing data it will calculate the average of the grade based on the total grades divided by the number of students
                if(StudentNumber > 0) {
                    AverageGrade = (double) TotalGrades / StudentNumber;
                    //prints out the average grade
                    System.out.println("Average Grade is " + gradeResult(AverageGrade));
                    //the loop ends
                    break;
                }
                //if there wasnt any data given it will simply say no data was given and ends the loop
                else{
                    System.out.println("There was no data given, have a nice day");
                    break;
                }
            }


            // checks to make sure that the name variable is given the correct data, REGULAR EXPRESSION: a filter that prevents unwanted inputs(for this instance digits because we dont have numbers in our names)
            if(studentName.matches(".*\\\\d.*")){
                //if the the conditional statement doesnt match, it will ask you to give a valid name
                System.out.println("Please enter a valid name(no digits please)");
                //continues the loop
                continue;
            }
            //after the studentName is given the right data the user is now asked to enter the grade
            System.out.println("Enter the student grade:  ");

            // a conditional statement where if the inputted value for the grade is invalid it prints asking to enter a valid grade
            //NOTE: REGEX COULD HAVE BEEN USED HERE USING THE [A-Z,a-z] PATTERN INCLUDING AN ADDITIONAL PATTERN FOR SPECICIAL CHARACTERS
            if(!gradeInput.hasNextInt()){
                System.out.println("Please enter a valid grade(no words or letters please)");
                gradeInput.next();
            }
            studentGrade = gradeInput.nextInt();
            // After all the conditions are met, the current grade is added to the totalgrades
            TotalGrades += studentGrade;
            //the number of students inside the list is incremented
            StudentNumber++;
            //the data (excluding the average) is printed display the name, the grade and the number of students who have been given a grade and their letter grade will be given by calling the grade result function
            System.out.println("Student Name: " + studentName + ", Grade: " + studentGrade + ", Letter Grade: " + gradeResult(studentGrade) + ", Student Number: " + StudentNumber);

        }
        //the scanners for both grade and name close because the loop is over and we are no longer adding any data
        studentNameInput.close();
        gradeInput.close();
    }


//the grade result function has an argument of studentGrade with a data type of double for a parameter
    //NOtE: I COULD HAVE PUT ALL OF THIS INSIDE THE MAIN METHOD BUT I WANTED TO HAVE GOOD PRACTICE BY STRENGTHENING MY FOUNDATIONS
    public static String gradeResult(double studentGrade) {
        //letterGrade is initialized inside the function
        String letterGrade;
        //multiple conditional statements to ensure that all the inputted grades get the correct letter grade (including the average grade
        //if student grade is greater than 90 set letter grade to be A
        if (studentGrade >= 90) {
            letterGrade = "A";
            //returns letterGrade
            return letterGrade;
            //if the studentGrade is greater than 80 but less than 90, set letter grade to B and return the letterGrade
        } else if (studentGrade >= 80 && studentGrade < 90) {
            letterGrade = "B";
            return letterGrade;
            //if the studentGrade is greater than 70 but less than 80, set letter grade to C and return the letterGrade
        } else if (studentGrade >= 70 && studentGrade < 80) {
            letterGrade = "C";
            return letterGrade;
            //if the studentGrade is greater than 60 but less than 70, set letter grade to D and return the letterGrade
        } else if (studentGrade >= 60 && studentGrade < 70) {
            letterGrade = "D";
            return letterGrade;
            //if the studentGrade is less than 60 then set the letter grade to F and return letterGrade
        } else {
            letterGrade = "F";
            return letterGrade;
        }

    }


}
