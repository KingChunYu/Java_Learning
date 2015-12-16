package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chunyu on 15/12/16.
 */
public class SimpleServer {
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(12345);
            while (true)
            {
                Socket s = ss.accept();
                OutputStream os = s.getOutputStream();
                os.write("链接成功".getBytes("utf-8"));
                os.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
