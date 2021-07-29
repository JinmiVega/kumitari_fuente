package pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;

public class Encrypt {

	private static Cipher encrypt;
	private static Cipher decrypt;   
	private static String keyTxt;

	public static void init(String configkey){
		
		keyTxt = ResourceUtil.getKey(configkey);
		try {
			encrypt = Cipher.getInstance("DES");
			decrypt = Cipher.getInstance("DES");
			if (keyTxt.equals("")) {
				SecretKey key = KeyGenerator.getInstance("DES").generateKey();
				encrypt.init(Cipher.ENCRYPT_MODE, key);
				decrypt.init(Cipher.DECRYPT_MODE, key);
			} else {
				KeySpec ks = new DESKeySpec(keyTxt.getBytes("UTF8"));
				SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
				SecretKey ky = kf.generateSecret(ks);
				encrypt.init(Cipher.ENCRYPT_MODE, ky);
				decrypt.init(Cipher.DECRYPT_MODE, ky);
			}
		} catch (InvalidKeySpecException ex) {
			
		} catch (UnsupportedEncodingException ex) {
			
		} catch (InvalidKeyException ex) {
			
		} catch (NoSuchAlgorithmException ex) {
			
		} catch (NoSuchPaddingException ex) {
			
		}
	}
	
	public static String encrypt(String str) throws EncryptException {
		try {
			byte[] utf8 = str.getBytes("UTF8");
			byte[] enc = encrypt.doFinal(utf8);
			return new sun.misc.BASE64Encoder().encode(enc);
		} catch (javax.crypto.BadPaddingException e) {
			throw new EncryptException(e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptException(e);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptException(e);
		}
	}

	public static String decrypt(String str) throws EncryptException {
		try {
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

			byte[] utf8 = decrypt.doFinal(dec);

			return new String(utf8, "UTF8");
		} catch (javax.crypto.BadPaddingException e) {
			throw new EncryptException(e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptException(e);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptException(e);
		} catch (java.io.IOException e) {
			throw new EncryptException(e);
		}

	}

}