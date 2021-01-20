package com.lutong.suanfa.zijie;

import com.lutong.suanfa.zijie.bean.Node;

/**
 * 根据数组返回积水面积
 * @author lutong
 * @Date 2021/1/20
 */
public class JiShuArea {

  public static void main(String[] args) {
    int[] arr = {3,1,0,2,1,0,1,3,2,1,2,1};
    Node[] nodes = new Node[arr.length];
    Node node = new Node();
    node.setV(arr[0]);
    node.setL(0);// 第一个节点的最左最大值为0
    nodes[0] = node; // 设置第一个节点
    node = new Node();
    node.setV(arr[arr.length-1]);
    node.setR(0);// 最后一个节点的最右最大值为0
    nodes[nodes.length-1] = node; // 设置最后一个节点

    for(int i = 1;i<arr.length-1;i++){ // 遍历设置所有节点的l值
      node = new Node();
      node.setV(arr[i]);
      // 取i-1节点的max(l,v)作为i的l值
      node.setL(Math.max(nodes[i-1].getL(),nodes[i-1].getV()));
      nodes[i] = node;
    }
    for(int i = arr.length-2;i>0;i--){ // 遍历设置所有节点的r值
      node = nodes[i];
      // 取i+1节点的max(r,v)作为i的r值
      node.setR(Math.max(nodes[i+1].getR(),nodes[i+1].getV()));
      nodes[i] = node;
    }
    int count = 0;
    for(int i = 1;i<nodes.length-1;i++){ // 从第二个到倒数第二个
      // 如果v<l && v<r则存在积水
      if(nodes[i].getV()<nodes[i].getL()&&nodes[i].getV()<nodes[i].getR()){
        // 积水单位为: min(l,r)-v
        count = count + Math.min(nodes[i].getL(),nodes[i].getR())-nodes[i].getV();
      }
    }
    System.out.println("积水为："+count);
  }
}
