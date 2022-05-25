package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean run = true;

        String fname = "src/files/";
        System.out.print("Please input the file you would like to work with: ");
        fname += input.nextLine() + ".csv";

        do {


            File myfile = new File(fname);
            Student[] students = StudentInput.createStudents(myfile);

            System.out.print("1.Sort by last name\n2.Sort by major\n3.Sort by Zip Code\n4.Sort by GPA\n5. Exit\n------->");
            String choice = input.nextLine();

            switch(choice) {
                case "1":
                    // Sort by Last Name
                    Arrays.sort(students,new Comparator<Student>() {
                        public int compare(Student s1,Student s2) {
                            String lastname1 = s1.getLastName();
                            String lastname2 = s2.getLastName();
                            return lastname1.compareTo(lastname2);
                        }
                    });
                    printStudents("Students Sorted By LastName",students);
                    break;
                case "2":
                    // Sort students by major
                    Arrays.sort(students,new Comparator<Student>() {
                        public int compare(Student s1,Student s2) {
                            String major1 = s1.getMajor();
                            String major2 = s2.getMajor();
                            return major1.compareTo(major2);
                        }
                    });
                    printStudents("Students Sorted By Major",students);
                    break;
                case "3":
                    // Sort students by ZipCode
                    Arrays.sort(students,new Comparator<Student>() {
                        public int compare(Student s1,Student s2) {
                            if (s1.getZipcode() == s2.getZipcode()) {
                                return s1.getFirstName().compareTo(s2.getFirstName());
                            }
                            return s1.getZipcode() - s2.getZipcode();
                        }
                    });
                    printStudents("Students Sorted By Zip Code",students);
                    break;
                case "4":
                    // Sort students by GPA
                    Arrays.sort(students,new Comparator<Student>() {
                        public int compare(Student s1, Student s2) {
                            if (s1.getGpa() == s2.getGpa()) {
                                return s1.getLastName().compareTo(s2.getLastName());
                            } if(s2.getGpa() > s1.getGpa()) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }
                    });
                    printStudents("Students Sorted By GPA",students);
                    break;
                case "5":
                    run = false;
                    break;
                default:
                    System.out.println("That is an invalid option");

            }

        } while(run);






    }

    public static void printStudents(String title,Student[] list) {
        final String format = "%-12s %-12s %-18s %-12s %-12s\n";
        System.out.println(title);
        System.out.printf(format,"First Name","Last Name","Major","Zip Code","GPA");
        for (Student s : list) {
            System.out.printf(format,s.getFirstName(),s.getLastName(),s.getMajor(),s.getZipcode(),s.getGpa());
        }
        System.out.println("==============================================================\n");
    }

}
