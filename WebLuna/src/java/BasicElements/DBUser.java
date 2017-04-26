/*
 * Copyright (c) 2017 a01334390.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    a01334390 - initial API and implementation and/or initial documentation
 */
package BasicElements;

/**
 *
 * @author a01334390
 */
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class DBUser {
    private String username,email,privilege,first_name,second_name,image,password;
    private BigInteger enc, p, q, n, pubKey, secKey;    
    
    public String getPassword() throws UnsupportedEncodingException {
        return decryptPassword();
    }
    public DBUser(String username, String privilege,String email, String first_name, String second_name, String image, String password) {
        this.username = username;
        this.email = email;
        this.privilege = privilege;
        this.first_name = first_name;
        this.second_name = second_name;
        this.image = image;
        this.password = encryptPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
        
    
    public String encryptPassword(String password){
        
        initRSA(512);     
        
        try{
            byte [] bytes = password.getBytes("ISO-8859-1");
            BigInteger msg = new BigInteger(1,bytes);
            System.out.println("msg Num = "+msg);

            BigInteger enc = encrypt(msg);
            setEnc(enc);
            System.out.println("Enc num = "+enc);

            return new String(enc.toByteArray(), "ISO-8859-1");
                        
        }catch(UnsupportedEncodingException ex){
            System.out.println("An error occurred");
        }
        return null;
    }
    
    public String decryptPassword() throws UnsupportedEncodingException{        
        BigInteger dec = decrypt(enc);
        System.out.println("Num descifrado = " + dec);
        return new String(dec.toByteArray(), "ISO-8859-1");
    }
    
    public void setEnc(BigInteger enc){
        this.enc = enc;
    }

    public void initRSA (int Nbits){
            BigInteger phi;
            SecureRandom sr = new SecureRandom();
            p = BigInteger.probablePrime(Nbits, sr);
            q = BigInteger.probablePrime (Nbits, sr);
            n = p.multiply(q);
            phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
            pubKey = BigInteger.probablePrime(Nbits, sr);
            secKey = pubKey.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger msg){
            return msg.modPow(pubKey, n);
    }
    
    public BigInteger decrypt(BigInteger msg){
            return msg.modPow(secKey, n);
    }
    @Override
    public String toString(){
        return username;
    }
}
