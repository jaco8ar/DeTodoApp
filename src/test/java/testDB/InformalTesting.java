package test.java.testDB;

import main.java.dataBaseManagement.DBconnection;
import main.java.classes.TargetEnvironment;
import main.java.dataBaseManagement.AppDBBuilder;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import main.java.classes.Cryptography;

public class InformalTesting {

	public static void main(String[] args) {
		
		String userPassword = "elefantesMarronesloco";
		
	

		String toBeEncrypted = "thisWillBeThePassw0rd**";
		
		try {
			String encrypted = Cryptography.encrypt( toBeEncrypted, userPassword);
			System.out.println("Encrypted password: " + encrypted);
			String decrypted = Cryptography.decrypt( encrypted, userPassword);
			System.out.println("Decrypted password: " + decrypted);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
