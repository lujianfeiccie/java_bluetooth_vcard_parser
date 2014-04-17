package com.lujianfei.bluetooth;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.lujianfei.bluetooth.parses.Commander;
import com.lujianfei.bluetooth.parses.DownloadPhoneBookReader;
import com.lujianfei.bluetooth.parses.DownloadPhoneBookWriter;
import com.lujianfei.bluetooth.util.Network;

public class SocketServer {
	private ServerSocket ss; 
	private Socket socket; 
	private InputStream inputStream;
	private OutputStream outputStream; 	
	private boolean thread_read_flag = true; 
	private Commander writer = null;
	private Commander reader = null;
	public SocketServer(int port) 
	{ 		
			try {
				
				ss = new ServerSocket(port);
				System.out.println("LocalIP="+Network.getLocalIp()+":"+port);
				while(true){
					System.out.println("Listening...");
				socket = ss.accept();
				System.out.println("accepted from:"+socket.getLocalAddress().getHostAddress()+":"+socket.getLocalPort());
				outputStream = socket.getOutputStream();
				inputStream = socket.getInputStream();	
				
				writer = new DownloadPhoneBookWriter(outputStream, inputStream);
				reader = new DownloadPhoneBookReader(outputStream, inputStream);
			//	new Thread(new InputStreamThread()).start();			
				PhoneBook();//外部调用
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
	} 
	public void PhoneBook(){
		try {
			writer.execute();
			reader.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
