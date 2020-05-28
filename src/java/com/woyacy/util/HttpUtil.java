package com.woyacy.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author Administrator
 *
 */
public class HttpUtil {


    /**
     * 调用对方接口方法
     * @param httpUrl 对方或第三方提供的路径
     * @param data 向对方或第三方发送的数据，大多数情况下给对方发送JSON数据让对方解析 "?name=zs"
     */
    public static String  sendGet(String httpUrl,String data) {
        URL url = null;
        try {
            url = new URL(httpUrl + data);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置该连接是可以输出的
            connection.setDoOutput(true);
            // 设置请求方式
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            // 读取数据
            while ((line = br.readLine()) != null) {
                result.append(line + "\n");
            }
            connection.disconnect();
            return result.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}