package baitap.ra.business.implement;

import baitap.ra.business.design.CRUD;
import baitap.ra.business.entity.Student;
import baitap.ra.business.config.InputMethods;


public class StudentImplement implements CRUD {
    private static Student[] students = new Student[100];
    private int size = 0;
    @Override
    public void create() {
        if (size == 100){
            System.err.println("mảng đầy");
        }else {
            // logic thêm mới
            // ta 1 đối tượng student
            Student newStudent = new Student();
            newStudent.inputData();
            // thêm vào mang
            students[size] = newStudent;
            size++; // tăng số lương
        }
    }

    @Override
    public void display() {
        if (size == 0){
            System.err.println("mảng ko co ptu");
        }else {
            for (int i = 0; i < size; i++) {
                System.out.println(students[i]);
            }
        }
    }

    @Override
    public void edit() {
        if (size==0){
            System.out.println("Khong co phan tu sinh vien nao ton tai");
        }else {
            System.out.println("Nhap id sinh vien");
            int updateId = InputMethods.getInteger();
            boolean checkID = false;
            for (int i = 0; i < size; i++) {
                if (students[i].getStudentId() == updateId){
                    students[i].inputData();
                    checkID = true;
                    System.out.println("Hoan tat cap nhat");
                    break;
                }
            }
            if (!checkID){
                System.out.println("Id sinh vien khong ton tai");
            }
        }
    }

    @Override
    public void delete() {
        if (size == 0){
            System.out.println("Khong co phan tu sinh vien nao ton tai");
        }else {
            System.out.println("Nhap id sinh vien muon xoa");
            int deleteId = InputMethods.getInteger();
            boolean checkDel = false;
            for (int i = 0; i < size; i++) {
                if (students[i].getStudentId()== deleteId){
                    for (int j = i; j < size-1; j++) {
                        students[j]=students[j+1];
                    }
                    size--;
                    checkDel=true;
                    System.out.println("Da xoa sinh vien co ma "+students[i].getStudentId());
                    break;
                }
            }
            if (!checkDel){
                System.out.println("Id sinh vien khong ton tai");
            }
        }
    }
}