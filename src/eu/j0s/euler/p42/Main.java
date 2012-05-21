package eu.j0s.euler.p42;

import java.io.IOException;

public class Main {
	public static void main(String [ ] args)
	{
		try {
			for (String str : Resources.getInstance().wordlist()){
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
