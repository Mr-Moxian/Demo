package com.sts.demo.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;

public class SignatureTookKit
{
    public static SecureRandom secRandom = new SecureRandom();
    public static final String DEFAULT_PROVIDER_NAME = "BC";
    public static Signature signature = null;

    static{
        try{
            Security.addProvider(new BouncyCastleProvider());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Signature getSignature() throws Exception {
        if (signature == null) {
            synchronized (SignatureTookKit.class) {
                if (signature == null) {
                    try {
                        signature = Signature.getInstance("SHA256WithRSA", "BC");
                    }
                    catch (Exception e) {
                        throw e;
                    }
                }
            }
        }
        return signature;
    }

    public static KeyPair genKeyPair(byte[] seed) throws Exception {
        KeyPair keyPair = null;
        try {
            KeyPairGenerator kpGenerator = KeyPairGenerator.getInstance("RSA", "BC");

            SecureRandom secRandom = new SecureRandom();
            secRandom.setSeed(seed);
            kpGenerator.initialize(1024, secRandom);
            keyPair = kpGenerator.genKeyPair();
        } catch (Exception e) {
            throw e;
        }

        return keyPair;
    }


    public static byte[] sign(PrivateKey privateKey, byte[] data) throws Exception {
        byte[] retr = null;
        try {
            Signature signature = getSignature();
            signature.initSign(privateKey);
            signature.update(data);
            retr = signature.sign();
        } catch (Exception e) {
            throw e;
        }
        return retr;
    }


    public static boolean verify(PublicKey publicKey, byte[] orignData, byte[] signBytes) throws Exception {
        boolean auth = false;
        try {
            Signature signature = getSignature();
            signature.initVerify(publicKey);
            signature.update(orignData);
            auth = signature.verify(signBytes);
        } catch (Exception e) {
            auth = false;
            throw e;
        }
        return auth;
    }

    public static byte[] digestSign(byte[] seed, byte[] data) throws Exception {
        byte[] retr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256", "BC");
            md.update(seed);
            md.update(data);
            retr = md.digest();
        } catch (Exception e) {
            throw e;
        }
        return retr;
    }


    public static boolean digestVerify(byte[] seed, byte[] orignData, byte[] signdata) throws Exception {
        boolean auth = false;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256", "BC");
            md.update(seed);
            md.update(orignData);
            byte[] digData = md.digest();
            auth = Arrays.equals(digData, signdata);
        } catch (Exception e) {
            auth = false;
            throw e;
        }
        return auth;
    }
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
