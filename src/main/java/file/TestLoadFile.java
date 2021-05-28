package main.java.file;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <b>文件下载</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/28 18:32
 */
public class TestLoadFile {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://111.198.186.63:8081/zwfwpt_test/document/service/DocumentServiceImpl/downloadFile?docId=e505cd8e-1a65-4fe7-a156-a6b158578f16");
        InputStream is = url.openStream();
        String file = url.getFile();
        String authority = url.getAuthority();
        File t = new File("http://111.198.186.63:8081/zwfwpt_test/document/service/DocumentServiceImpl/downloadFile?docId=e505cd8e-1a65-4fe7-a156-a6b158578f16");
//        HttpGet client = new HttpGet(url,"1",1);
        OutputStream out = new FileOutputStream(t);

        int read=0;
        byte[] bytes = new byte[1024];

        while((read = is.read(bytes))!= -1){
            out.write(bytes, 0, read);
        }
        System.out.println(t.getName());
    }

    @Test
    public void test(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://111.198.186.63:8081/zwfwpt_test/document/service/DocumentServiceImpl/downloadFile?docId=e505cd8e-1a65-4fe7-a156-a6b158578f16");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            Header[] allHeaders = response.getAllHeaders();
            Header[] names = response.getHeaders("Content-Disposition");
            Header header = names[0];
            String value1 = header.getValue();
            System.out.println(value1);
            HeaderElement[] elements = header.getElements();
            String value = elements[0].getValue();
            NameValuePair filename = elements[0].getParameterByName("filename");
            String filenameValue = filename.getValue();
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
