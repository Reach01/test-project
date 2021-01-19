package com.lutong.test;

import java.io.*;

/**
 * @author lutong
 * @date 2021/1/11
 **/
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/logs/a.txt");
        String str = "abc|abc|abc";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        for(int i = 0;i < 5; i++){
            bw.write(str);
            bw.newLine();
        }
        bw.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while(null != (line = br.readLine())){
            System.out.println("读出："+line);
        }

    }
}
