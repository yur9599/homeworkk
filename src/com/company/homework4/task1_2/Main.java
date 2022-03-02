package com.company.homework4.task1_2;

import com.company.homework4.task1_2.person.Person;

import java.util.Scanner;

import static com.company.homework4.task1_2.personValidator.PersonValidator.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstName ;
        String lastName ;
        String passportId ;
        int age ;
        String gender ;
        String nationality;

        while (true){
            System.out.println("Name");
            firstName=sc.nextLine();
            if (isValidName(firstName)) {
                break;
            }
            else{
                System.out.println("Invalid name");
            }
        }

        while (true){
            System.out.println("Surname");
            lastName=sc.nextLine();
            if (isValidName(lastName)) {
                break;
            }
            else{
                System.out.println("Invalid surname");
            }
        }

        while (true){
            System.out.println("PassportID");
            passportId=sc.nextLine();
            if (isValidPassportId(passportId)) {
                break;
            }
            else{
                System.out.println("Invalid passportID");
            }
        }

        while (true){
            System.out.println("Age");
            age=sc.nextInt();
            if (isValidAge(age)) {
                break;
            }
            else{
                System.out.println("Invalid age");
            }
        }

        sc.nextLine();

        while (true){
            System.out.println("Gender");
            gender=sc.nextLine();
            if (isValidGender(gender)) {
                break;
            }
            else{
                System.out.println("Invalid gender");
            }
        }

        System.out.println("Nationality");
        nationality=sc.nextLine();

        Person person = new Person(firstName,lastName,passportId,age,gender,nationality);
        System.out.println(person.display());
    }

}
