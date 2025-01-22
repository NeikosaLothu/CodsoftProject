import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        while (numSubjects <= 0) {
            System.out.print("Invalid input. Please enter a positive number: ");
            numSubjects = scanner.nextInt();
        }

        int totalMarks = 0;
        String grade = "";

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = scanner.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks. Please enter marks between 0 and 100: ");
                marks = scanner.nextInt();
            }

            totalMarks += marks; 
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "B+";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C+";
        } else if (averagePercentage >= 50) {
            grade = "C";
        } else if (averagePercentage >= 40) {
            grade = "D+";
        } else if (averagePercentage >= 30) {
            grade = "D";
        } else {
            grade = "E";
        }

        System.out.println("\nStudent Result:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close(); 
}    
}
