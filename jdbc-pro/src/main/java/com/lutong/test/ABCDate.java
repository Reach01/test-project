package com.lutong.test;

import java.io.File;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author lutong
 * @Date 2021/1/13
 */
public class ABCDate {

  public static void main(String[] args) throws Exception {
    String fileP = "C:\\Users\\lutong\\Desktop\\20210112\\data.txt";
    File file = new File(fileP);
    FileWriter fileWriter = new FileWriter(file, true);
    for (int i = 0; i < 1000; i++) {
      fileWriter.write("123123114" + getRandom(2) + "|" + getRandom(13) + "|" + getRandomId() + "|" + getRandom(13) + "|0000|" + getRandom(2));
      fileWriter.write("\n");
    }
    fileWriter.flush();
    fileWriter.close();
  }

  private static String getRandomId() {
    String[] strings = new String[]{
        "614500000000000001",
        "614500000000000002",
        "614500000000000003",
        "614500000000000004",
        "614500000000000005",
        "614500000000000006"};
    return strings[new Random().nextInt(strings.length)];
  }

  private static String getRandom(int length) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      builder.append(new SecureRandom().nextInt(9));
    }
    return builder.toString();
  }

}
