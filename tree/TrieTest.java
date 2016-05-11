package tree;

import java.util.Random;

public class TrieTest {
	
	public static void main(String[]args){
		
		Trie trie = new Trie();
		Random r = new Random();
		String[]array = {"a", "ab", "abb", "ac", "zz", "bet", "beton",
						"betoniarka", "betonowy", "aaaaa"};
		String[]randoms = new String[1000];
		
		int maxStringLength = 8000;
		for(int i = 0; i < randoms.length; i++){
			randoms[i] = generateString(maxStringLength);
		}
		for(String s : randoms){
			trie.insert(s);
		}
		for(String s: array){
			trie.insert(s);
		}
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000 ; i++){
			trie.search(randoms[r.nextInt(randoms.length)]);
		}
		long timeElapsed = System.currentTimeMillis() - start;
		
		System.out.println(timeElapsed);
		
		
		/*
		System.out.println("is \"abb\" in trie?: " + trie.search("abb"));
		System.out.println("is \"betonowy\" in trie?: " + trie.search("betonowy"));
		System.out.print("is \"nowy\" in trie?: " + trie.search("nowy"));
		*/
	}
	
	public static String generateString(int stringLength){
		char alphabetStart = 'a';
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		for(int i = stringLength; i > 0; i--){
			sb.append((char)(r.nextInt(20) + alphabetStart));
		}
		
		return sb.toString();
	}
}
