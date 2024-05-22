package main.java.classes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

import java.security.MessageDigest;
import java.security.SecureRandom;


public class Cryptography {
	
	private final static String algorithm = "AES";
	private final static String cipherType = "AES/CBC/PKCS5Padding";
	
	private static IvParameterSpec generateRandomInitializationVector() {
		byte[] array = new byte[16];
		new SecureRandom().nextBytes(array);
		
		return new IvParameterSpec(array);
	}
	
	private static SecretKeySpec generateKeyFromUserPassword(String password) throws Exception{
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
	    byte[] key = sha.digest(password.getBytes("UTF-8"));
	    return new SecretKeySpec(key, algorithm);
	    
	}

	public static String encrypt(String message, String password) throws Exception {
		
	    
	    
	    IvParameterSpec iv = generateRandomInitializationVector();
	    SecretKeySpec aesKey = generateKeyFromUserPassword(password);
	    Cipher cipher = Cipher.getInstance(cipherType);
	    
	    cipher.init(Cipher.ENCRYPT_MODE, aesKey, iv);
	    
	    byte[] ciphertext = cipher.doFinal(message.getBytes());
	    byte[] encrypted = new byte[iv.getIV().length + ciphertext.length];
	    
	    System.arraycopy(iv.getIV(), 0, encrypted, 0, iv.getIV().length);
	    System.arraycopy(ciphertext, 0, encrypted, iv.getIV().length, ciphertext.length);
	    
	    return new String(encodeBase64(encrypted));
	}

	public static String decrypt(String encryptedMessage, String password) throws Exception {
		
	    SecretKeySpec aesKey = generateKeyFromUserPassword(password);
	    
	    byte[] encrypted = decodeBase64(encryptedMessage);
	    
	    byte[] iv = new byte[16];
	    System.arraycopy(encrypted, 0, iv, 0, iv.length);
	    
	    byte[] ciphertext = new byte[encrypted.length - iv.length];
	    System.arraycopy(encrypted, iv.length, ciphertext, 0, ciphertext.length);
	    
	    Cipher cipher = Cipher.getInstance(cipherType);
	    
	    cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));
	    return new String(cipher.doFinal(ciphertext), "UTF-8");
	}
	
	public static String hashPasswordSHA3256 (String password) {
		return new DigestUtils("SHA3-256").digestAsHex(password);
	}
}
