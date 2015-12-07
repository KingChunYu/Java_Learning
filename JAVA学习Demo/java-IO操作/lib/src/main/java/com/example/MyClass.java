package com.example;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyClass {
    public static void main(String args[]) {
        useApache();

    }

    public static void ioRead() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte input[] = new byte[10];
        try {
            fis.read(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputString = new String(input);
        System.out.println(inputString);
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ioWrite() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("outWrite");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String outWriter = "写出到文件上面";
        byte output[] = outWriter.getBytes();
        try {
            fos.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWriteAndReader() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("test.txt");
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("test-new.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    try {
                        bufferedWriter.write(line + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void useApache() {
        File file = new File("test.txt");
        String str = null;
        try {
            str = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);

    }
}
