package com.algorithm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * Aes encryption
 */
public class AES {

	private  SecretKeySpec secretKey;
	private  byte[] key;

	private  String decryptedString;
	private  String encryptedString;
	
	public AES(String key) {
		setKey(key);
	}

	public  void setKey(String myKey) {

		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			System.out.println(key.length);
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16); // use only first 128 bit
			System.out.println(key.length);
			System.out.println(new String(key, "UTF-8"));
			secretKey = new SecretKeySpec(key, "AES");

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  String getDecryptedString() {
		return decryptedString;
	}

	public  void setDecryptedString(String decryptedString) {
		this.decryptedString = decryptedString;
	}

	public  String getEncryptedString() {
		return encryptedString;
	}

	public  void setEncryptedString(String encryptedString) {
		this.encryptedString = encryptedString;
	}

	public  String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));

		} catch (Exception e) {

			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public  String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));

		} catch (Exception e) {

			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

//	public static void main(String args[]) {
//		final String strToEncrypt = "gkcompsci@gmail.com";
//		final String strPssword = "callcentre@123";
//		AES aes = new AES(strPssword);
////		aes.setKey(strPssword);
//
//		aes.encrypt(strToEncrypt.trim());
//
//		System.out.println("String to Encrypt: " + strToEncrypt);
//		System.out.println("Encrypted: " + aes.getEncryptedString());
//
//		final String strToDecrypt = aes.getEncryptedString();
//		aes.decrypt(strToDecrypt.trim());
//		
//        		
// 
//		System.out.println("String To Decrypt : " + strToDecrypt);
//		System.out.println("Decrypted : " + aes.getDecryptedString());
//		
//		aes.encrypt("Check Message".trim());
//		System.out.println("Excrypt String :: "+aes.getEncryptedString());
//		String enc = aes.getEncryptedString();
//		aes.decrypt(enc.trim());
//		System.out.println("Dec :: "+aes.getDecryptedString());
//		
//		
//		String encryptString = "HsDGt/WaO2K0ZGRBvsXMO0Ku9ljEOEwcROZgmrXOai8=";
//		aes.setEncryptedString(encryptString);
//		String dec = aes.decrypt(encryptString);
//		System.out.println("Decrypt :: "+dec);
//		
//
//	}

}