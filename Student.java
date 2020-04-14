/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlisv;

/**
 *
 * @author Admin
 */
public class Student {


    private int id;
    private String name;
    private int age;
    private double GPA, mathGrade, literGrade, engGrade;

    Student(int id, String name, int age, double mG, double literG, double eG, double GPA) {
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public double getLiterGrade() {
        return literGrade;
    }

    public void setLiterGrade(double literGrade) {
        this.literGrade = literGrade;
    }

    public double getEngGrade() {
        return engGrade;
    }

    public void setEngGrade(double engGrade) {
        this.engGrade = engGrade;
    }

    public Student(double mathGrade, double literGrade, double engGrade) {
        this.mathGrade = mathGrade;
        this.literGrade = literGrade;
        this.engGrade = engGrade;
    }

//    public Student() {
//        id = new String("");
//        name = new String("");
//        age = 0;
//        GPA = 0;
//    }

    public Student(int i, String n, int a, double mathGrade, double literGrade, double engGrade) {
        id = i;
        name = n;
        age = a;
        GPA = (this.mathGrade + this.literGrade + this.engGrade) / 3;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

  

    void showInfo() {
        System.out.println("MSSV: " + this.id + " name: " + this.name + " age: " + this.age + " GPA: " + this.GPA);
    }
}
