package com.lujianfei.bluetooth.util;

import java.util.List;

public class ByteHelper {
	/**
	 * AscII��ת����
	 * @param bNumber
	 * @return
	 */
	public static int asciiToNumber(byte bNumber){
		return (bNumber&0x0ff) - 48;
	}
	/**
	  * �ж��������Ƿ����Ŀ�괮
	  * @param byteArray ����
	  * @param destByteArray Ŀ�괮
	  * @return -1 ����û���ҵ������򷵻��ҵ���λ��
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
