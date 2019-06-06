package org.fogbeam.example.opennlp;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TokenizerTest {
	
	private TokenizerMain tokenizerMain= new TokenizerMain();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void ShoulReadfileReturnTexttest() {
		String text = tokenizerMain.readFile();
		assertNotNull(text);
	}
	
	@Test
	public void Shoultokenitest() {
		tokenizerMain.readFile();
		assertTrue(!tokenizerMain.getTxt().isEmpty());
	}

}
