package com.lutong.jvm;

/**
 * @author lutong
 * @Date 2020/12/21
 */
public class StackOverflowTest {

  // 默认线程的栈内存大小为 1M
  // -Xss128k
  // 该值越大，开启的线程数就越少；所以可以将改值调小点

  static int count = 0;

  static void redo() {
    count++;
    redo();
  }

  public static void main(String[] args) {
    try {
      redo();
    } catch (Throwable t) {
      t.printStackTrace();
      System.out.println(count);
    }
  }
}
