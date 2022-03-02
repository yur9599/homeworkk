package com.company.homework4.task4;

import com.company.homework4.task4.store.Store;
import static com.company.homework4.task4.storeValidator.StoreValidator.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countOfWorkers;
        String name;
        String phoneNumber;
        System.out.print("Set array size ");
        int[] productNumbers=new int[sc.nextInt()];

        while (true){
            System.out.print("CountOfWorkers ");
            countOfWorkers=sc.nextInt();
            if(isValidCountofWorkers(countOfWorkers)){
                break;
            }
            else {
                System.out.println("Invalid countOfWorkers");
            }
        }

        sc.nextLine();

        while (true){
            System.out.print("Name ");
            name=sc.nextLine();
            if (isVAlidName(name)){
                break;
            }
            else {
                System.out.println("Invalid name");
            }
        }

        while (true){
            System.out.print("PhoneNumber ");
            phoneNumber=sc.nextLine();
            if (isValidPhoneNum(phoneNumber)){
                break;
            }
            else {
                System.out.println("Invalid phoneNumber");
            }
        }

        System.out.println("Set array elements");
        for (int i=0;i<productNumbers.length;i++){
            System.out.print("ProductNumber["+i+"] ");
            productNumbers[i]=sc.nextInt();
        }

        Store st = new Store(countOfWorkers,name,phoneNumber,productNumbers);
        System.out.println(st);
    }

}
