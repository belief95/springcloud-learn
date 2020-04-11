package com.itmayiedu.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OrderController {

    @GetMapping("/getOrderUserId")
    public String getOrderUserId(Integer userId) {
        return get("http://127.0.0.1:8080/member/getUser?userId=" + userId);
    }

    // 发送get请求
    public String get(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // 创建httpget
            HttpGet httpGet = new HttpGet(url);
            System.out.println("executing request " + httpGet.getURI());
            // 执行get请求
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    String result = EntityUtils.toString(entity);
                    // 打印响应内容
                    System.out.println("Response content: " + result);
                    return result;
                }
                System.out.println("----------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
