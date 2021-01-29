package com.lutong.suanfa.zijie.bean;

/**
 * n变形类
 * @author lutong
 * @Date 2021/1/25
 */
public class Polygon {

  private Coordinate[] coArray = null;

  public Polygon(Coordinate[] array) {
    coArray = array;
  }

  /**
   * 计算多边形边长
   *
   * @return
   */
  public double getPerimeter() {
    double perimeter = 0;

    /*double min_x = 0;
    double max_x = 0;
    double min_y = 0;
    double max_y = 0;
    for(int i = 0;i<coArray.length-1;i++){
      if(coArray[i].getX()<coArray[i+1].getX()){
        min_x = coArray[i].getX();
        max_x = coArray[i+1].getX();
      }
      if(coArray[i].getY()<coArray[i+1].getY()){
        min_y = coArray[i].getY();
        max_y = coArray[i+1].getY();
      }
    }
    return (max_x-min_x+max_y-min_y)*2;*/
    for (int i = 0; i < coArray.length; i++) {
      int next = i + 1;

      // 如果最后一个顶点的话，需要计算和起点的距离
      if (i == coArray.length - 1) {
        next = 0;
      }

      // 计算每条边的边长
      if (coArray[i].getX() == coArray[next].getX()) {
        perimeter += Math.abs(coArray[i].getY() - coArray[next].getY());
      } else {
        perimeter += Math.abs(coArray[i].getX() - coArray[next].getX());
      }
    }

    return perimeter;
  }

  /*public Coordinate[] getKDivid(int k) {
    double perimeter = getPerimeter();
    double divLen = perimeter / k;
    double len = divLen;
    Coordinate[] coordinates = new Coordinate[k];
    int index = 0;

    for (int i = 0; i < coArray.length; i++) {
      int next = i + 1;
      // 如果最后一个顶点的话，需要计算和起点的距离
      if (i == coArray.length - 1) {
        next = 0;
      }

      //判断当前的边是垂直还是水平方向
      if (coArray[i].getX() == coArray[next].getX()) { // 垂直
        double distance = Math.abs(coArray[i].getY() - coArray[next].getY());

        if (len < distance) {//当前边上存在k等分点，而且存在多个的情况

          //用来记录距离当前线段起点距离
          double base = 0;
          while (len <= distance) {
            if (coArray[i].getY() > coArray[next].getY()) {
              coordinates[index] = new Coordinate(coArray[i].getX(), coArray[i].getY() - (len + base));
            } else {
              coordinates[index] = new Coordinate(coArray[i].getX(), coArray[i].getY() + (len + base));
            }

            base += len;
            distance -= len;
            len = divLen;
            index++;
          }

          //len记录了当前边计算完k等分点后还剩余多长
          len = divLen - distance;
        } else {
          len -= distance;
        }
      } else { //处理垂直方向的情况
        double distance = Math.abs(coArray[i].getX() - coArray[next].getX());

        if (len < distance) {
          double base = 0;
          while (len <= distance) {
            if (coArray[i].getX() > coArray[next].getX()) {
              coordinates[index] = new Coordinate(coArray[i].getX() - (len + base), coArray[i].getY());
            } else {
              coordinates[index] = new Coordinate(coArray[i].getX() + (len + base), coArray[i].getY());
            }

            base += len;
            index++;
            distance -= len;
            len = divLen;
          }
          len = divLen - distance;
        } else {
          len -= distance;
        }
      }
    }

    return coordinates;
  }*/

  public Coordinate[] getKDivid(int k) {
    double perimeter = getPerimeter();
    double divLen = perimeter / k;
    double len = divLen;
    Coordinate[] coordinates = new Coordinate[k];
    int index = 0;

    for (int i = 0; i < coArray.length; i++) {
      int next = i + 1;
      // 如果最后一个顶点的话，需要计算和起点的距离
      if (i == coArray.length - 1) {
        next = 0;
      }
      //判断当前的边是垂直还是水平方向
      if (coArray[i].getX() == coArray[next].getX()) {
        double distance = Math.abs(coArray[i].getY() - coArray[next].getY());
        while (len <= distance) {
          if (coArray[i].getY() > coArray[next].getY()) {
            coordinates[index] = new Coordinate(coArray[i].getX(), coArray[i].getY() - len);
          } else {
            coordinates[index] = new Coordinate(coArray[i].getX(), coArray[i].getY() + len);
          }
          len += divLen;
          index++;
        }
        //len记录了当前边计算完k等分点后还剩余多长
        len -= distance;
      } else { //处理垂直方向的情况
        double distance = Math.abs(coArray[i].getX() - coArray[next].getX());
        while (len <= distance) {
          if (coArray[i].getX() > coArray[next].getX()) {
            coordinates[index] = new Coordinate(coArray[i].getX() - len, coArray[i].getY());
          } else {
            coordinates[index] = new Coordinate(coArray[i].getX() + len, coArray[i].getY());
          }
          index++;
          len += divLen;
        }
        len -= distance;
      }
    }

    return coordinates;
  }

}
