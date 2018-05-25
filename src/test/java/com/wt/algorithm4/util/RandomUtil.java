package com.wt.algorithm4.util;

public class RandomUtil {

	private static char[] SEQUEBCE = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
		'X', 'Y', 'Z' , '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'a','b','c','d','e','f','g','h','i', 'j','k','l', 'm','n','o','p','q','r','s',
		't','u','v','w','x','y','z'}; 
	
	/**
	 * 说明:随便产生多少位的随即数
	 * @param codeCount 随即数的个数
	 * @return
	 */
	public static String getRandom(int codeCount){
		String randomCode = "";
		for (int i = 0; i < codeCount; i++) {
			randomCode+=SEQUEBCE[(int) Math.floor(Math.random()*(SEQUEBCE.length))];
		}
		return randomCode;
	}
}
