package com_step2;

public class Dept {
  private int deptno; //부서번호
  private String dname = null; //부서명
  private String loc = null;; //근무지역

  //setter
  public void setDeptno(int deptno){
    this.deptno = deptno;
  }
  
  public void setDname(String dname){
    this.dname = dname;
  }
  
  public void setLoc(String loc){
    this.loc = loc;
  }
  
  //getter
  public int getDeptno(){
    return deptno;
  }
  
  public String getDname(){
    return dname;
  }
  public String getLoc(){
    return loc;
  }
}
