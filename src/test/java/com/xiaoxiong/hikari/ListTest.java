package com.xiaoxiong.hikari;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xiongliang
 * @version 1.0
 * @description List线程安全测试
 * @since 2022/5/5  10:05
 */
public class ListTest {

   static List<Integer> vector = new Vector<>();
   static List<Integer> listSyn = Collections.synchronizedList(new ArrayList<>());
   static List<Integer> copyList = new CopyOnWriteArrayList<>();

   public static void main(String[] args) throws InterruptedException {
      // 设置并发数
      int num = 10000;
      List<List<Integer>> all = Arrays.asList(vector, listSyn, copyList);
      for (List<Integer> list : all) {
         long start = System.currentTimeMillis();
         test(num, list);
         System.out.println("------耗时：" + (System.currentTimeMillis() - start));
         // 等待上述所有线程执行完
         Thread.sleep(5 * 1000);
      }

      System.out.println("vector length===>" + vector.size());
      System.out.println("listSyn len  ===>" + listSyn.size());
      System.out.println("copyList len ===>" + copyList.size());
   }

   /**
    *
    * @param num   循环次数
    * @param list  集合
    */
   public static void test(int num, List<Integer> list) {
      for (int i = 0; i < num; i++) {
         new Thread(() -> list.add(Math.round(0))).start();
      }
   }


}
