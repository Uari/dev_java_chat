package com_step2;

public class DeptSimulation {
  public static void main(String args[]){
    Dept dept = new Dept();
    int dno = 10;
    dept.setDeptno(dno);
    System.out.println(dept.getDeptno());
    String dname = "개발부";
    dept.setDname(dname);
    System.out.println(dept.getDname());
    String loc = "가디";
    dept.setLoc(loc);
    System.out.println(dept.getLoc());
  }
}
