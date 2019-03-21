package com.fsgame.test;

public class Test {
 public static void main(String[] args) {
  Culculate thread = new Culculate(1000);
  thread.start();
  while (thread.isAlive()) {
   try {
	   //线程睡眠500ms
    Thread.sleep(0);
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
   //输出结果
   System.out.println(thread.getCurrentResult());
  }
  //最终结果
  System.out.println("final result: " + 
   thread.getCurrentResult());
 }
}
class Culculate extends Thread {
	 private int n = 0;
	 private int result = 0;
	 public Culculate(int n) {
	  this.n = n;
	 }
	 public void run() {
		 sum(n);
	 }
	 //阶乘总和
	 public int sum(int n){
		int sum = 0;
		for(int i=n;i>0;i--){
			sum = sum + jiecheng(i);
		}
		return sum;
	 }
	 //递归求得单次阶乘的结果
	 public int jiecheng(int n){
		 if(n>=1){
			 result = result + n;
			 return jiecheng(n-1);
		 }
		 if(n==1){
			 return result;
		 }
		 return result;
	 }
	//获取结果函数
	 public int getCurrentResult() {
	  return result;
	 }
}