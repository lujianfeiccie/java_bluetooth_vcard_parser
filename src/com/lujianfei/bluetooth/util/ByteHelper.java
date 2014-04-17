package com.lujianfei.bluetooth.util;

import java.util.List;

public class ByteHelper {
	/**
	 * AscII码转数字
	 * @param bNumber
	 * @return
	 */
	public static int asciiToNumber(byte bNumber){
		return (bNumber&0x0ff) - 48;
	}
	/**
	  * 判断主串中是否存在目标串
	  * @param byteArray 主串
	  * @param destByteArray 目标串
	  * @return -1 则是没有找到，否则返回找到的位置
	  */
	 public static int containsBytes(List<Byte> byteArray,byte[] destByteArray){
	  int iByteArray=0,iBuffer=0;
	  while(true){
	   if(byteArray.get(iByteArray) == destByteArray[iBuffer])
	   {
	    ++iByteArray;
	    ++iBuffer;
	   }
	   else
	   {
	    iBuffer=0;
	    ++iByteArray;
	   }
	   
	   if(iBuffer == destByteArray.length)
	    return iByteArray - destByteArray.length;
	   
	   if(iByteArray>byteArray.size()-1)
	    return -1;
	  }
	 }
}
