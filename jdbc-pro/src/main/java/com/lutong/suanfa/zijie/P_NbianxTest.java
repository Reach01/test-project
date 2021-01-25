package com.lutong.suanfa.zijie;

import com.lutong.suanfa.zijie.bean.Coordinate;
import com.lutong.suanfa.zijie.bean.Polygon;

/**
 * 打印n变形所有k等分点
 * @author lutong
 * @Date 2021/1/20
 */
public class P_NbianxTest {

  public static void main(String[] args) {
    Coordinate[] arr = new Coordinate[]{new Coordinate(0,0),new Coordinate(0,2),
                                        new Coordinate(2,2),new Coordinate(2,1),
                                        new Coordinate(1,1),new Coordinate(1,0)};
    Polygon polygon = new Polygon(arr);
    System.out.println(polygon.getPerimeter());
    Coordinate[] kDivid = polygon.getKDivid(4);
    for(int i = 0;i<kDivid.length;i++){
      System.out.println(kDivid[i]);
    }
  }
}
