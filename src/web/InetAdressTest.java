package web;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress[] i =InetAddress.getAllByName("www.baidu.com");
			for (int j = 0; j < i.length; j++) {
				System.out.println(i[j].getHostAddress());
			}
			
			InetAddress[] addresss =InetAddress.getAllByName("time-a.nist.gov");
			for (int j = 0; j < addresss.length; j++) {
				System.out.println(addresss[j].getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
