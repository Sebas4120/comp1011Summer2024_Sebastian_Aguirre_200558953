package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.Week9;

public class Student {
    private int studentId;
    private String firstName, lastName;
    private int age;
    private double grade;

    public Student(int studentId, String firstName, String lastName, int age, double grade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }


}
