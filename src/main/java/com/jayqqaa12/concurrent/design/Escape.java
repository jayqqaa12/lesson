package com.jayqqaa12.concurrent.design;

import com.jayqqaa12.NotThreadSafe;

/**
 * 逸出
 *
 * Created by 12 on 2017/8/15.
 */
@NotThreadSafe
public class Escape {
  
   private String[] status =new String[]{
  	"OPEN","COLSE"
  };


  public String[] getStatus(){

  	return status;
  }



}
