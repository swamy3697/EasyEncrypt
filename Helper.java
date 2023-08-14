package com.company;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Helper {
    private String string;
    private String path;
    private String fileName;
    private String filePath;
    private String line;
    private String inputFilePath;

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    private String outputType;
    User user=new User();
    Helper()
    {
        string="";
        path="C:\\Users\\";
        fileName="new.txt";
        filePath=path+fileName;

    }
    Scanner scanner=new Scanner(System.in);
    public  void encryption( )
    {
        createCode();
        String text =encryptionText(3);
        if(getOutputType().equals("string"))
        {
            System.out.println("--------- ----");
            System.out.println("ENCRYPTED TEXT");
            System.out.println("--------- ----");
            System.out.println("");
            System.out.println(text);
        }
        else
        {

            try
            {
                System.out.println(text);
                String tempPath="C:\\Users\\swamy\\Desktop\\hello\\encrypted.txt";

                File encryptedFile=new File(tempPath);
                encryptedFile.createNewFile();
                BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(encryptedFile));

                bufferedWriter.write(text);
                bufferedWriter.close();

            } catch (IOException e) {
                System.out.println("PROBLEM IN SAVING THE FILE ");
                e.printStackTrace();
            }

        }


    }
    public void getPath()
    {
        System.out.println("----- ---- -------- --- ---- -- ----");
        System.out.println("ENTER FILE LOACTION YOU WANT TO SAVE");
        System.out.println("----- ---- -------- --- ---- -- ----");
        System.out.println("");
        System.out.println("ENTER THE FILE PATH OR D--> FOR DEFAULT");



    }

    private @NotNull
    String encryptionText(int shift) {
        String encryptedString="";
        StringBuilder stringBuilder=new StringBuilder();

        for(char character:string.toCharArray())
        {
            if(Character.isLowerCase(character))
            {
                stringBuilder.append((char) ((((character-'a')+shift)%26)+'a'));
            }
            else if (Character.isUpperCase(character))
            {
                stringBuilder.append((char) ((((character-'A')+shift)%26)+'A'));
            }
            else
            {
                stringBuilder.append(character);
            }
        }
        encryptedString=stringBuilder.toString();


        return encryptedString;

    }

    private void createCode() {
        System.out.println("------ - -------- -----");
        System.out.println("CREATE A SECURITY CODE ");
        System.out.println("------ - -------- -----");
        System.out.println("ENTER USER NAME :");
        user.setUserName(scanner.nextLine());
        System.out.println("ENTER USER CODE :");
        user.setCode(scanner.nextInt());
    }

    public void decryption()
    {
       if(!checkAccess())
       {
           System.out.println("ACCESS DENIED.......");
           return;
       }
       String decryptionText=encryptionText(-3);
        if(getOutputType().equals("string"))
        {
            System.out.println("--------- ----");
            System.out.println("DECRYPTED TEXT");
            System.out.println("--------- ----");
            System.out.println("");
        }
        else
        {

            try
            {
                String tempPath="C:\\Users\\swamy\\Desktop\\hello\\decrypted.txt";
                File encryptedFile=new File(tempPath);
                encryptedFile.createNewFile();
                BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(encryptedFile));
                bufferedWriter.write(decryptionText);
                bufferedWriter.close();

            } catch (IOException e) {
                System.out.println("PROBLEM IN SAVING THE FILE ");
                e.printStackTrace();
            }

        }



    }
   public boolean checkAccess()
    {
        System.out.println("------ ---------- ---- ------");
        System.out.println("BEFORE DECRYPTION GAIN ACCESS");
        System.out.println("------ ---------- ---- ------");
        System.out.println("");
        System.out.println("ENTER THE USER NAME YOU ENTERED BEFORE OR DEFAULT \"user\" ");
        String u=scanner.nextLine();

        if(user.userName.equals(u)|| u.equalsIgnoreCase("user"))
        {
            System.out.println("ENTER THE CODE YOU ENTERED BEFOREOR DEFAULT \"0000\"");
            int c=scanner.nextInt();
            if (user.code==c|| c==0000)
            {
                return true;
            }
            else
            {
                System.out.println("WRONG USER CODE");
                return false;
            }
        }
        else
        {
            System.out.println("WRONG USER NAME");
            return false;
        }


    }
    public void takeString()
    {
        System.out.println("PLEASE ENTER THE STRING THAT YOU WANT PERFORM OPERATION :");
        string=scanner.nextLine();

    }
    public void takeFromFile()
    {
        System.out.println("");
        System.out.println("ENTER THE  CORRECT PATH OF TEXT FILE WHICH YOU WANT TO PERFORM OPERATION :");
        inputFilePath=scanner.nextLine();
        try
        {
            StringBuilder stringBuilder=new StringBuilder();
            File file=new File(inputFilePath);
            file.createNewFile();
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            while(( line= bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line)
                        .append("\n");

            }
            bufferedReader.close();
            string=stringBuilder.toString();
            System.out.println("FILE DETAILS :");
            System.out.println("Name   :"+file.getName());
            System.out.println("Size   :"+file.getTotalSpace());


        }catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("PROBLEM  IN TAKING TEXT FILE PATH");
        }


    }
}
