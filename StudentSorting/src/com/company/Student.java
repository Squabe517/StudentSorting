package com.company;

/**
 * Student class (immutable)
 * @author Gaige Wycuff
 */
public final class Student {
    private final String firstName;
    private final String lastName;
    private final String major;
    private final int zipcode;
    private final String studentID;
    private final double gpa;

    public Student(String firstName, String lastName, String major, int zipcode, String studentID, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.zipcode = zipcode;
        this.studentID = studentID;
        this.gpa = gpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getStudentID() {
        return studentID;
    }

    public double getGpa() {
        return gpa;
    }
}

