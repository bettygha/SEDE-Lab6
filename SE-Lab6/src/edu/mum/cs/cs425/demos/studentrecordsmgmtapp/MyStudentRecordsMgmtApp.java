package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author: Betelhem Gebrehawaryat
 * Date: 8/27/2023
 */
public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {

        System.out.println("===> List of all student...");
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("110001", "Dave", LocalDate.now()));
        list1.add(new Student("110002", "Anna", LocalDate.now()));
        printListOfStudents(list1);
        System.out.println("===> List of premium student...");
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("110003", "Erica", LocalDate.of(1974, 1, 31)));
        list2.add(new Student("0110004", "Carlos", LocalDate.now()));
        getListOfPlatinumAlumniStudents(list2);
        System.out.println("===> Print Hello World");
        printHelloWorld(new int[]{5, 15, 49, 35});
        System.out.println("===> Print second biggest");
        findSecondBiggest(new int[]{10, 9, 8, 9, 7, 11, 10});
    }

    public static void printListOfStudents(List<Student> students) {
        students.sort(Comparator.comparing(Student::getStudentName));
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void getListOfPlatinumAlumniStudents(List<Student> students) {
        students = students.stream().filter(x -> {
            Period period = x.getDateOfAdmission().until(LocalDate.now());
            int yearsBetween = period.getYears();
            return yearsBetween >= 30;
        }).sorted(Comparator.comparing(Student::getStudentName).reversed()).toList();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void printHelloWorld(int[] arr) {
        for (int x : arr) {
            if (x % 5 == 0 && x % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (x % 5 == 0) {
                System.out.println("Hello");
            } else if (x % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static void findSecondBiggest(int[] arr) {
        int max = arr[0];
        int secondMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                secondMax = max;
                max = arr[i];
            }
        }
        System.out.println(secondMax);
    }
}
