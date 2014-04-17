package com.lujianfei.bluetooth.parses;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import com.lujianfei.bluetooth.util.ByteHelper;

public class DownloadPhoneBookReader extends Commander {
	List<Byte> byteArray = new LinkedList<Byte>();
	final int MAX_LENGTH = 100; 
	final byte[] HEADER= new byte[]{0x6c,0x65,0x6e,0x67,0x74,0x68,0x3d};//’“µΩlength=
	final byte[] END= new byte[]{0x0d,0x0a};//’“µΩ\r\n
	
	public DownloadPhoneBookReader(OutputStream outputStream,
			InputStream inputStream){
		setOutputStream(outputStream);
		setInputStream(inputStream);
	}
	@Override
	public void execute() throws IOException {
		ParseHeader(getInputStream());
	}

	@Override
	public void stop() {

	}
	
	private void ParseHeader(InputStream is){
		byte[] buffer = new byte[64];
		boolean findlength = false;
		int posOfStart = 0;
		int posOfEnd = 0;
		while(true){
			try {
				int readsize = is.read(buffer);
				if(readsize==-1) break;
				for(int i=0;i<readsize;i++)
					byteArray.add(buffer[i]);
				
				if(findlength && (posOfEnd = ByteHelper.containsBytes(byteArray,END))!=-1)
				{
					System.out.print("length=");
					for (int i = posOfStart+HEADER.length; i <posOfEnd; i++) {
						System.out.print(ByteHelper.asciiToNumber(byteArray.get(i)));
					}
					System.out.println("");
					byteArray.clear();
					break;
				}
				else if(!findlength && (posOfStart = ByteHelper.containsBytes(byteArray,HEADER))!=-1)
				{   //’“µΩlength=
					findlength = true;
					System.out.println("find length");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("finish");
	}
}
