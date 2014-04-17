package com.lujianfei.bluetooth;
import java.math.BigInteger;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				super.run();
				new SocketServer(5000);
			}
		}.start();
//		String str = "\r\n";
//		try {
//			System.out.println(getHexString(str.getBytes(),str.getBytes().length));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Byte> byteArray = new LinkedList<Byte>();
//		byteArray.add(new Byte((byte) 0x01));
//		byteArray.add(new Byte((byte) 0x01));
//		final byte[] HEADER= new byte[]{0x6c,0x65,0x6e,0x67,0x74,0x68,0x3d};//’“µΩlength=
//		for (int i = 0; i < HEADER.length; i++) {
//			byteArray.add(HEADER[i]);
//		}
//		System.out.println(containsBytes(byteArray, HEADER));
	}
	public static String getHexString(byte[] b,int size) throws Exception {
		  StringBuilder result = new StringBuilder();
		  for (int i=0; i < size; i++) {
		    result.append(Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring(1));
		  }
		  return result.toString();
		}

	public static byte[] getByteArray(String hexString) {
	  return new BigInteger(hexString,16).toByteArray(); 
	}
}
