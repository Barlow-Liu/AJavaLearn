package web;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("time-a.nist.gov",13);
			Scanner in = new Scanner(s.getInputStream(),"UTF-8");
			while(in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
			in.close();
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {


		}
		System.out.println("end");
	}

}
