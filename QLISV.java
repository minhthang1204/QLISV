/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlisv;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author Admin
 */
public final class QLISV {

    /**
     * @param args the command line arguments
     */
    ArrayList<Student> list = new ArrayList<>();
    ArrayList<Student> studentSortedByGrade = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        new QLISV();
        
        File F = new File("Student.txt");
        F.toPath();
        System.out.println("");
    }

    public QLISV() {
        while (true) {
            System.out.println("CHUONG TRINH QUAN LY SINH VIEN");
            System.out.println("1. Xem sinh vien ");
            System.out.println("2. Them sinh vien");
            System.out.println("3. Xoa sinh vien ");
            System.out.println("4. Top 10 sinh vien co GPA cao nhat ");
            System.out.println("5. Exit");
            int n;
            int StudentId;
            System.out.print("Nhap lua chon ban muon : ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    this.showStudents();
                    break;
                case 2:
                    this.addStudent();
                    break;
                case 3:
                    StudentId = this.findId();
                    this.deleteStudent(StudentId);
                    break;
                case 4:
                    this.search();
                    break;
                case 5:
                    System.out.print("Thoat chuong trinh");
                    return;
            }
        }
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Nhap du lieu cho sinh vien thu " + i);
            System.out.print("ID : ");
            int id = sc.nextInt();
            System.out.print("Ho Ten : ");
            String name = sc.next();
            System.out.print("Tuoi : ");
            int age = sc.nextInt();
            System.out.print("mathGrade : ");
            double mG = sc.nextDouble();
            System.out.print("literGrade : ");
            double literG = sc.nextDouble();
            System.out.print("engGrade : ");
            double eG = sc.nextDouble();
            double GPA = (mG + literG + eG) / 3;
            System.out.print("GPA: " + GPA);
            Student sv = new Student(id, name, age, mG, literG, eG, GPA);
            list.add(sv);

        }
    }

    public void showStudents() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).showInfo();
        }
    }

    public void search() {
        studentSortedByGrade = (ArrayList<Student>) list.clone(); // Class =Object => (ArrayList<Student>) => ArrayList
        for (int i = 0; i < studentSortedByGrade.size() - 1; i++) {  //bubble sort
            for (int j = i + 1; j < studentSortedByGrade.size(); j++) {
                if (studentSortedByGrade.get(i).getGPA() < studentSortedByGrade.get(j).getGPA()) {
                    Student temp = studentSortedByGrade.get(i);
                     studentSortedByGrade.set(i, studentSortedByGrade.get(j));
                    studentSortedByGrade.set(j, temp);
                }
            }
        }
        for (int i = 0; i < studentSortedByGrade.size(); i++) {
            if (i == 10) {
                break;
            }
            studentSortedByGrade.get(i).showInfo();
        }
    }

//    private void deleteStudent() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private void deleteStudent(int Id) {
        Student student = null;
        int size = list.size();

        for (int i = 0; i < size; i++) {
            if (list.get(i).getId() == Id) {
                student = list.get(i);
                break;
            }
        }
        if (student != null) {

            list.remove(student);

        } else {
            System.out.printf("id = %d not existed.\n", Id);
        }
    }

    public int findId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((sc.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }
}
