package com.client;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private Socket socket;
    public Client() {
        String host = System.getenv("SERVICE_HOST");
        String port_str = System.getenv("SERVICE_PORT");
        int port = Integer.parseInt(port_str);

        try {
            System.out.println("正在连接服务端...");
            socket = new Socket(host, port);
            //socket = new Socket("localhost",8088);
            System.out.println("与服务端建立连接!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void start() {
        try {
            OutputStream out = socket.getOutputStream();//建立一个输出的流
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);//转换字符与字节
            BufferedWriter bw = new BufferedWriter(osw);//加速
            bw.write("this is from client");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
    	while (true) {
            Client client = new Client();   //创建一个新的服务端
            client.start();  
            try {
		Thread.sleep(5000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
    	}
    }
}
