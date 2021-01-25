package com.lutong.suanfa.zijie.bean;

import lombok.Data;

/**
 * n变形k等分点问题的坐标类
 * @author lutong
 * @Date 2021/1/20
 */
@Data
public class Coordinate {

  private double x, y;

  public Coordinate(double x, double y) {
    super();
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "x = " + x + ", y=" + y;
  }
}
