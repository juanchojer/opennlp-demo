
package org.fogbeam.example.opennlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenizerMain {

	private final String path = "src/main/resources/file.txt";
	public File file = null;
	public String txt = "";
	public String[] tokens = null;

	public File getFile() {
		return file;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String[] getTokens() {
		return tokens;
	}

	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}

	public String readFile() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			file = new File(path);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String eachLine;
			while ((eachLine = br.readLine()) != null) {
				setTxt(getTxt() + eachLine);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return getTxt();
	}

	public void Tokenizer(String texto) throws Exception {
		InputStream modelIn = new FileInputStream("models/en-token.model");

		try {
			TokenizerModel model = new TokenizerModel(modelIn);

			Tokenizer tokenizer = new TokenizerME(model);

			/* note what happens with the "three depending on which model you use */
			String[] tokens = tokenizer.tokenize("A ranger journeying with Oglethorpe, founder of the Georgia Colony, "
					+ " mentions \"three Mounts raised by the Indians over three of their Great Kings"
					+ " who were killed in the Wars.\"");

			for (String token : tokens) {
				System.out.println(token);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
				}
			}
		}
		System.out.println("\n-----\ndone");
	}

	public static void main(String[] args) throws Exception {
		TokenizerMain tokenizerMain = new TokenizerMain();
		String txtToTokenize = tokenizerMain.readFile();
		tokenizerMain.Tokenizer(txtToTokenize);
	}

}
