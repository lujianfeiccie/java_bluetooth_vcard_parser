package com.lujianfei.bluetooth.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Network {
	
	public static String getLocalIp() throws SocketException{
		Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements())
		{
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			System.out.println(netInterface.getName());
			Enumeration addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements())
			{
				 ip = (InetAddress) addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address)
				{
					return ip.getHostAddress();
				} 
			}
		}
		return "";
	}
}
