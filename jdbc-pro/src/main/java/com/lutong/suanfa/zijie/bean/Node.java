package com.lutong.suanfa.zijie.bean;

import lombok.Data;

/**
 * 水坑问题节点
 * @author lutong
 * @Date 2021/1/20
 */
@Data
public class Node {

  int v; // 本挡板高度
  int l; // 本挡板左侧最高高度
  int r; // 本挡板右侧最高高度

}
