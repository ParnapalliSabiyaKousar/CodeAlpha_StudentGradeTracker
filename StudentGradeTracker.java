import java.util.ArrayList;
import java.util.Scanner;

// ===============================
// CODEALPHA STUDENT GRADE TRACKER
// ===============================

class Student {

    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {

    // ===============================
    // MAIN METHOD
    // ===============================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=======================================");
        System.out.println("     CODEALPHA STUDENT TRACKER");
        System.out.println("=======================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // ===============================
        // INPUT STUDENT DETAILS
        // ===============================

        for (int i = 1; i <= n; i++) {

            System.out.println("\n---------- Student " + i + " ----------");

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            int marks;

            while (true) {

                System.out.print("Enter marks (0 - 100): ");
                marks = sc.nextInt();
                sc.nextLine();

                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter between 0 and 100.");
                }
            }

            students.add(new Student(name, marks));
        }

        // ===============================
        // CALCULATIONS
        // ===============================

        int total = 0;
        int highest = students.get(0).marks;
        int lowest = students.get(0).marks;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student s : students) {

            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                highestStudent = s.name;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowestStudent = s.name;
            }
        }

        double average = (double) total / students.size();

        // ===============================
        // DISPLAY REPORT
        // ===============================

        System.out.println("\n");
        System.out.println("=======================================");
        System.out.println("          SUMMARY REPORT");
        System.out.println("=======================================");

        System.out.printf("%-20s %-10s %-10s\n", "Student Name", "Marks", "Grade");

        System.out.println("---------------------------------------");

        for (Student s : students) {

            String grade = calculateGrade(s.marks);

            System.out.printf("%-20s %-10d %-10s\n",
                    s.name,
                    s.marks,
                    grade);
        }

        System.out.println("---------------------------------------");

        System.out.println("Average Marks : " + String.format("%.2f", average));

        System.out.println("Highest Marks : " + highest + " (" + highestStudent + ")");

        System.out.println("Lowest Marks  : " + lowest + " (" + lowestStudent + ")");

        System.out.println("=======================================");

        System.out.println("\nProject Completed Successfully!");

        sc.close();
    }

    // ===============================
    // GRADE CALCULATION METHOD
    // ===============================

    public static String calculateGrade(int marks) {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "Fail";
        }
    }
}