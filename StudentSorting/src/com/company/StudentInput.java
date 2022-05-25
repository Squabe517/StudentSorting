package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * Takes student data from csv file and stores in student object
 * @author Gaige Wycuff
 */
public class StudentInput {

    /**
     * Read file then convert data to Student objects
     * @param myfile inputn file
     * @return Array of Student objects
     */

    public static Student[] createStudents(File myfile) {
        ArrayList<Student> studentList = new ArrayList<>();
        String line = "";
        String delimiter = ",";

        try(Scanner input = new Scanner(myfile)) {
            while (input.hasNext()) {
                line = input.nextLine();
                String[] student = line.split(delimiter);
                studentList.add(new Student(student[0],student[1],student[2],Integer.parseInt(student[3]),student[4],Double.parseDouble(student[5])));

            }
        } catch(FileNotFoundException ex) {
            System.out.println("Cannot access file: "+myfile);
        }
        Student[] students = studentList.toArray(new Student[studentList.size()]);

        return students;
    }


}
