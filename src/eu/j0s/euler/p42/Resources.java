package eu.j0s.euler.p42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public final class Resources {
	private String[] wordList;

	private Resources() {
		// do nothing
	}

	private static Resources singletonInstance = new Resources();

	public static Resources getInstance() {
		return Resources.singletonInstance;
	}

	public synchronized String[] wordlist() throws IOException {
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
					vec.add(word.substring(word.indexOf('"') + 1,
							word.lastIndexOf('"')));
				}
			}

			in.close();
			this.wordList = vec.toArray(new String[0]);
		}
		return wordList;
	}
}
