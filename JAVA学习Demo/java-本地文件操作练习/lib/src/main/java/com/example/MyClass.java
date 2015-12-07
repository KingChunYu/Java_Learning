package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MyClass {
    public static void main(String args[]) {
        dirOption();
        fileOut();

    }

    public static void fileOption() {
        File file = new File("../hello.txt");
        if (file.exists()) {
            System.out.println("文件存在");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 文件移动操作
        File rename = new File("Hello.txt");
        file.renameTo(rename);
    }

    public static void dirOption() {
        File dir = new File("first");
        if (dir.exists()) {
            System.out.println("文件夹已经存在");
        } else {
            try {
                dir.mkdir();
                System.out.println("文件夹创建成功!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileProperty() {
        File file = new File("test.txt");
        System.out.println("读取文件名称：" + file.getName());
        System.out.println("读取文件路径：" + file.getPath());
        //详细属性参阅文档API
    }

    public static void fileRead() {
        File file = new File("Hello.txt");
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                InputStreamReader isr = null;
                try {
                    isr = new InputStreamReader(fis, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                try {
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }

    public static void fileOut() {
        File newfile = new File("newHello.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(newfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        try {
            bw.write("lalalalal\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.write("hahahaha\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
