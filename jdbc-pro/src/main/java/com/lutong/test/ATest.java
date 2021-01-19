package com.lutong.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * 测试时间字符串
 * @author lutong
 * @date 2021/1/11
 **/
public class ATest {
    public static void main(String[] args) throws ParseException, InterruptedException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        calendar.setTime(sdf.parse("20210110020000"));
        long endTime = calendar.getTime().getTime();
        calendar.setTime(sdf.parse("20210109180000"));
        long startTime = calendar.getTime().getTime();
        while(startTime < endTime){
            System.out.println(sdf.format(calendar.getTime()));
            TimeUnit.SECONDS.sleep(1);
            calendar.add(Calendar.HOUR,1);
            startTime = calendar.getTime().getTime();
        }
    }
}
