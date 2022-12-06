import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec; 

public class keyGeneration {
    
    public static void generateKey(String KeyAlgorithm) throws 
    NoSuchAlgorithmException {
        try {
            KeyGenerator key = KeyGenerator.getInstance(KeyAlgorithm);

            SecretKey key1 = key.generateKey();
            byte[] sk1 = key1.getEncoded();
            int len1 = sk1.length;

            SecretKey key2 = new SecretKeySpec(sk1, KeyAlgorithm);
            byte[] sk2 = key2.getEncoded();
            int len2 = sk2.length;

            System.out.println("\nAlgorithm used is: "+KeyAlgorithm);
            System.out.println("\n Key2 Generated is: "+key2);
            System.out.println("\n Key2 length is : "+len2);

            System.out.println("\n are both keys symmetric?: "+key1.equals(key2));

        } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException{
        
        generateKey("DES");

        generateKey("AES");

        generateKey("BLowfish");

        generateKey("DESede");

        generateKey("HmacMD5");

        generateKey("HmacSHA1");

    }
}
