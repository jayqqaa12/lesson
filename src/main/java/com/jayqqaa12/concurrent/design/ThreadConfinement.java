package com.jayqqaa12.concurrent.design;

import com.jayqqaa12.ThreadSafe;

/**
 * 线程封闭
 * Created by 12 on 2017/8/15.
 */
@ThreadSafe
public class ThreadConfinement {

  private String[] status =new String[]{
  	"OPEN","COLSE"
  };


  public String[] getStatus(){

  	return status;
  }




}
