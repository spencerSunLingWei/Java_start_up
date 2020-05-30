package com.stage1.part4.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) {

        try {
            URL ur1 = new URL("https://kaiwu.lagou.com/xunlianying/index.html?courseId=11#/detail?weekId=551&lessonId=1738");
            System.out.println("获取到的协议名称： " + ur1.getProtocol());
            System.out.println("获取到的主机名称： " + ur1.getHost());
            System.out.println("获取到的端口号：" +  ur1.getPort());


            HttpURLConnection urlConnection = (HttpURLConnection) ur1.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while((str=br.readLine()) != null){
                System.out.println(str);
            }
            br.close();

            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
