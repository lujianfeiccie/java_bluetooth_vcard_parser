package com.lujianfei.bluetooth.parses;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadPhoneBookWriter extends Commander{
	
	public DownloadPhoneBookWriter(OutputStream outputStream,
			InputStream inputStream){
		setOutputStream(outputStream);
		setInputStream(inputStream);
	}
	@Override
	public void execute() throws IOException {
		String downCommand = "PBDOWN";
		log("write:"+downCommand);
		getOutputStream().write(downCommand.getBytes());
	}

	@Override
	public void stop() {
		
	}
	void log(String msg){
		System.out.println(msg);
	}
}
