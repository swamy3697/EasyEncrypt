package com.company;


import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        int choice;
        Helper helper=new Helper();
        Scanner scanner=new Scanner(System.in);

        System.out.println("------- -- ---- ---------- - ----------");
        System.out.println("WELCOME TO FILE ENCRYPTION / DECRYPTION");
        System.out.println("------- -- ---- ---------- - ----------");
        System.out.println("");
        System.out.println("");
        System.out.println("WHICH ONE YOU WANT PERFORM ON ");
        System.out.println("");
        System.out.println("(1)-->        BY ENTERING TEXT");
        System.out.println("(2)-->            BY TEXT FILE");

        System.out.println("");
        switch (scanner.nextInt())
        {
            case 1:
                helper.takeString();
                helper.setOutputType("string");
                break;
            case 2:
                helper.takeFromFile();
                helper.setOutputType("file");
                break;
            default:
                System.out.println("YOU MISTAKENLY ENTERED WRONG OPTION SO REREUN AND TRY AGAIN");
        }
        System.out.println("");
        System.out.println("TAKEN INPUT SUCCESSFULLY");
        System.out.println("");
        System.out.println("PLEASE SELECT THE OPERATION");
        System.out.println("(1)-->           ENCRYPTION");
        System.out.println("(2)-->           DECRYPTION");
        choice=scanner.nextInt();
        switch (choice)
        {
            case 1:
                helper.encryption();
                break;
            case 2:
                helper.decryption();
                break;
            default:
                System.out.println("default");
        }
    }

}
