package stduentdatabase;

import java.util.Scanner;

public class Student {
    private static int costOfCourse = 600; // 등록금
    private static int id = 1000;
    private String firstName;
    private String lastName;
    private int gradeYear; // 학년
    private String studentID; // 학번
    private String courses = "" ; // 학습과정
    private int tuitionBalance; // 수업료

    // Constructor : prompt user to enter student's name and year
    // 생성자 : 사용자에게 학생의 이름과 연도를 입력하라는 메시지를 표시합니다.
    public Student(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter student first name : ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name : ");
        this.lastName = in.nextLine();

        System.out.print("1 - 1학년\n2 - 2학년\n3 - 3학년\n4 - 4학년\nEnter student class level : ");
        this.gradeYear = in.nextInt();

        setStudentID();

    }
    // Generation an ID
    // 아이디 생성
    private void setStudentID(){
        // Grade Level + ID
        id++; // id를 static 정적으로 설정 후 학생수가 증가할때마다 1씩 증가
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    // 수업 등록
    public void enroll(){
        // Get inside a loop, user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
    }

    // View balance
    // 잔액 보기
    public void viewBalance() {
        System.out.println("your balance is : $" + tuitionBalance);
    }

    // Pay Tuition
    // 수업료 지불
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment : $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you your payment of $ " + payment);
        viewBalance();
    }

    // Show status
    // 상태 표시
    public String toString() {
        return "Name : " + firstName + " " + lastName +
                "\nGrade Level : " + gradeYear +
                "\nStudent ID : " + studentID +
                "\nCourses Enrolled : " + courses +
                "\nBalance: $" + tuitionBalance;

    }
}
