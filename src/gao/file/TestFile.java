package gao.file;

import org.apache.camel.util.FileUtil;

import java.io.*;

/**
 * <b></b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/10/20 11:20
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("", "");
        FileOutputStream fos = new FileOutputStream(file);
        FileWriter fileWriter = new FileWriter(file);
        InputStream ins = new FileInputStream(file);

        //while(ins.read()){

        //}
    }
}
