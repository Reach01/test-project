package com.lutong.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**
 * @author lutong
 * @Date 2021/1/11
 */
public class ABCTest {

  public static void main(String[] args) throws ParseException {
    /*Calendar calendar = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    calendar.setTime(df.parse("20210108080000"));
    for(int i = 0;i<74;i++){
      String startTime = df.format(calendar.getTime());
      calendar.add(Calendar.HOUR,1);
      String endTime = df.format(calendar.getTime());
      System.out.println(startTime+"  "+endTime);
    }*/

    /*Map<String,Integer> map = new HashMap<>();
    map.put("a",1);
    map.put("c",3);
    map.put("b",2);
    map.put(null,null);
    *//*for (String key : map.keySet()){
      System.out.println(key+":"+map.get(key));
    }*//*
    Set<Entry<String, Integer>> entries = map.entrySet();
    for (Entry<String, Integer> entry : entries) {
      System.out.println(entry.getKey()+":"+entry.getValue());
    }*/

    StringBuilder bu = new StringBuilder();
    for (int i = 0;i<10;i++)
      bu.append(new Random().nextInt(10));
    System.out.println(bu);
  }

}
