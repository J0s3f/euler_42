package eu.j0s.euler.p42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {
	public static void main(String [ ] args)
	{
		Main obj = new Main();
		try {
			for (String str : obj.readWordlist()){
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
	private  String[] wordList;

	public synchronized String[] readWordlist() throws IOException {
		if (wordList == null) {
			Vector<String> vec = new Vector<String>();
			InputStream in = this.getClass().getResourceAsStream(
					"/res/words.txt");
			if (in == null)
				throw new IOException("resource 'words.txt' not found!");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				String words[] = strLine.split(",");
				for (String word : words) {
					vec.add(word.substring(word.indexOf('"')+1,word.lastIndexOf('"')));
				}
			}

			in.close();
			this.wordList = vec.toArray(new String[0]);
		}
		return wordList;
	}
}
