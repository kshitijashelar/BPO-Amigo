/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.algorithm;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.util.StringTokenizer;

import com.constant.Constant;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.dictionary.Dictionary;
import net.didion.jwnl.dictionary.MorphologicalProcessor;

/**
 *
 * @author Ganesh
 */
public class Stemming implements Constant {
	static {
		try {
			JWNL.initialize(new FileInputStream(WORDNET_DICTIONARY_PATH + "file_properties.xml"));
		} catch (Exception ex) {
			System.err.println("  Exception initialising Dictionary.  " + ex.getMessage());
		}
	}

	public static String getBaseForm(String statement) {
		StringBuilder base_data = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(statement);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (token.length() < 20) {
				if (getBaseForm(POS.VERB, token).equals(token)) {
					if (getBaseForm(POS.ADVERB, token).equals(token)) {
						if (getBaseForm(POS.ADJECTIVE, token).equals(token)) {
							token = getBaseForm(POS.NOUN, token);
						} else {
							token = getBaseForm(POS.ADJECTIVE, token);
						}
					} else {
						token = getBaseForm(POS.ADVERB, token);
					}
				} else {
					token = getBaseForm(POS.VERB, token);
				}
			}
			base_data.append(token).append(" ");
		}
		return base_data.toString();
	}

	private static String getBaseForm(POS p, String val) {
		try {
			MorphologicalProcessor mlp = Dictionary.getInstance().getMorphologicalProcessor();
			IndexWord word0 = mlp.lookupBaseForm(p, val);
			if (word0 != null) {
				val = word0.getLemma();
			}
		} catch (Exception er) {
			System.err.println("  " + er.getMessage());
		}
		return val;
	}

	// ----23-05-2017 ----------
	public static String removeStopWords(String statment) {
		// Stopwords stopwords = new Stopwords();
		StringBuilder stringBuilder = new StringBuilder();
		for (String str_ : statment.split(" ")) {
			if (Stopwords.isStopword(str_)) {
				// System.out.println(str_);
			} else {
				stringBuilder.append(str_ + " ");
			}
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		Stopwords stopwords = new Stopwords();
		Stemming stemming = new Stemming();
		StringBuilder stringBuilder = new StringBuilder();
		//
		String input = "nice beautiful romantic great cozy small cool fun comfortable warm live opened intimate casual private elegant modern";
		String output = stemming.getBaseForm(input);
		// for(String str_ : output.split(" ")){
		// if(stopwords.isStopword(str_)){
		// System.out.println(str_);
		// }else{
		// stringBuilder.append(str_+" ");
		// }
		// }
		System.out.println("INPUT :" + input);
		System.out.println("OUTPUT :" + output);
		// System.out.println("FINAL :"+stringBuilder);
	}
}