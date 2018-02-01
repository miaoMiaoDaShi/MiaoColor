package com.mcfish.code.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtils {
    private static final String AES_Algorithm = "AES";
    public static String AES_Transformation = "AES/ECB/NoPadding";
    private static final String DES_Algorithm = "DES";
    public static String DES_Transformation = "DES/ECB/NoPadding";
    private static final String TripleDES_Algorithm = "DESede";
    public static String TripleDES_Transformation = "DESede/ECB/NoPadding";

    private EncryptUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String encryptMD2ToString(String data) {
        return encryptMD2ToString(data.getBytes());
    }

    public static String encryptMD2ToString(byte[] data) {
        return ConvertUtils.bytes2HexString(encryptMD2(data));
    }

    public static byte[] encryptMD2(byte[] data) {
        return hashTemplate(data, "MD2");
    }

    public static String encryptMD5ToString(String data) {
        return encryptMD5ToString(data.getBytes());
    }

    public static String encryptMD5ToString(String data, String salt) {
        return ConvertUtils.bytes2HexString(encryptMD5((data + salt).getBytes()));
    }

    public static String encryptMD5ToString(byte[] data) {
        return ConvertUtils.bytes2HexString(encryptMD5(data));
    }

    public static String encryptMD5ToString(byte[] data, byte[] salt) {
        if (data == null || salt == null) {
            return null;
        }
        byte[] dataSalt = new byte[(data.length + salt.length)];
        System.arraycopy(data, 0, dataSalt, 0, data.length);
        System.arraycopy(salt, 0, dataSalt, data.length, salt.length);
        return ConvertUtils.bytes2HexString(encryptMD5(dataSalt));
    }

    public static byte[] encryptMD5(byte[] data) {
        return hashTemplate(data, "MD5");
    }

    public static String encryptMD5File2String(String filePath) {
        return encryptMD5File2String(StringUtils.isSpace(filePath) ? null : new File(filePath));
    }

    public static byte[] encryptMD5File(String filePath) {
        try {
            return encryptMD5File(StringUtils.isSpace(filePath) ? null : new File(filePath));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static String encryptMD5File2String(File file) {
        try {
            return ConvertUtils.bytes2HexString(encryptMD5File(file));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static byte[] encryptMD5File(File file) throws Throwable {
        Exception e;
        Exception e2;
        Throwable th;
        byte[] bArr = null;
        if (file != null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fis = new FileInputStream(file);
                try {
                    DigestInputStream digestInputStream = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
                    do {
                    } while (digestInputStream.read(new byte[262144]) > 0);
                    bArr = digestInputStream.getMessageDigest().digest();
                    CloseUtils.closeIO(fis);
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    fileInputStream = fis;
                    e2 = e;
                    try {
                        e2.printStackTrace();
                        CloseUtils.closeIO(fileInputStream);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        CloseUtils.closeIO(fileInputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = fis;
                    e2 = e;
                    e2.printStackTrace();
                    CloseUtils.closeIO(fileInputStream);
                    return bArr;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fis;
                    CloseUtils.closeIO(fileInputStream);
                    throw th;
                }
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                e2 = e;
                e2.printStackTrace();
                CloseUtils.closeIO(fileInputStream);
                return bArr;
            } catch (IOException e6) {
                e = e6;
                e2 = e;
                e2.printStackTrace();
                CloseUtils.closeIO(fileInputStream);
                return bArr;
            }
        }
        return bArr;
    }

    public static String encryptSHA1ToString(String data) {
        return encryptSHA1ToString(data.getBytes());
    }

    public static String encryptSHA1ToString(byte[] data) {
        return ConvertUtils.bytes2HexString(encryptSHA1(data));
    }

    public static byte[] encryptSHA1(byte[] data) {
        return hashTemplate(data, "SHA1");
    }

    public static String encryptSHA224ToString(String data) {
        return encryptSHA224ToString(data.getBytes());
    }

    public static String encryptSHA224ToString(byte[] data) {
        return ConvertUtils.bytes2HexString(encryptSHA224(data));
    }

    public static byte[] encryptSHA224(byte[] data) {
        return hashTemplate(data, "SHA224");
    }

    public static String encryptSHA256ToString(String data) {
        return encryptSHA256ToString(data.getBytes());
    }

    public static String encryptSHA256ToString(byte[] data) {
        return ConvertUtils.bytes2HexString(encryptSHA256(data));
    }

    public static byte[] encryptSHA256(byte[] data) {
        return hashTemplate(data, "SHA256");
    }

    public static String encryptSHA384ToString(String data) {
        return encryptSHA384ToString(data.getBytes());
    }

    public static String encryptSHA384ToString(byte[] data) {
        return ConvertUtils.bytes2HexString(encryptSHA384(data));
    }

    public static byte[] encryptSHA384(byte[] data) {
        return hashTemplate(data, "SHA384");
    }

    public static String encryptSHA512ToString(String data) {
        return encryptSHA512ToString(data.getBytes());
    }

    public static String encryptSHA512ToString(byte[] data) {
        return ConvertUtils.bytes2HexString(encryptSHA512(data));
    }

    public static byte[] encryptSHA512(byte[] data) {
        return hashTemplate(data, "SHA512");
    }

    private static byte[] hashTemplate(byte[] data, String algorithm) {
        byte[] bArr = null;
        if (data != null && data.length > 0) {
            try {
                MessageDigest md = MessageDigest.getInstance(algorithm);
                md.update(data);
                bArr = md.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return bArr;
    }

    public static String encryptHmacMD5ToString(String data, String key) {
        return encryptHmacMD5ToString(data.getBytes(), key.getBytes());
    }

    public static String encryptHmacMD5ToString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptHmacMD5(data, key));
    }

    public static byte[] encryptHmacMD5(byte[] data, byte[] key) {
        return hmacTemplate(data, key, "HmacMD5");
    }

    public static String encryptHmacSHA1ToString(String data, String key) {
        return encryptHmacSHA1ToString(data.getBytes(), key.getBytes());
    }

    public static String encryptHmacSHA1ToString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptHmacSHA1(data, key));
    }

    public static byte[] encryptHmacSHA1(byte[] data, byte[] key) {
        return hmacTemplate(data, key, "HmacSHA1");
    }

    public static String encryptHmacSHA224ToString(String data, String key) {
        return encryptHmacSHA224ToString(data.getBytes(), key.getBytes());
    }

    public static String encryptHmacSHA224ToString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptHmacSHA224(data, key));
    }

    public static byte[] encryptHmacSHA224(byte[] data, byte[] key) {
        return hmacTemplate(data, key, "HmacSHA224");
    }

    public static String encryptHmacSHA256ToString(String data, String key) {
        return encryptHmacSHA256ToString(data.getBytes(), key.getBytes());
    }

    public static String encryptHmacSHA256ToString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptHmacSHA256(data, key));
    }

    public static byte[] encryptHmacSHA256(byte[] data, byte[] key) {
        return hmacTemplate(data, key, "HmacSHA256");
    }

    public static String encryptHmacSHA384ToString(String data, String key) {
        return encryptHmacSHA384ToString(data.getBytes(), key.getBytes());
    }

    public static String encryptHmacSHA384ToString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptHmacSHA384(data, key));
    }

    public static byte[] encryptHmacSHA384(byte[] data, byte[] key) {
        return hmacTemplate(data, key, "HmacSHA384");
    }

    public static String encryptHmacSHA512ToString(String data, String key) {
        return encryptHmacSHA512ToString(data.getBytes(), key.getBytes());
    }

    public static String encryptHmacSHA512ToString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptHmacSHA512(data, key));
    }

    public static byte[] encryptHmacSHA512(byte[] data, byte[] key) {
        return hmacTemplate(data, key, "HmacSHA512");
    }

    private static byte[] hmacTemplate(byte[] data, byte[] key, String algorithm) {
        GeneralSecurityException e;
        byte[] bArr = null;
        if (!(data == null || data.length == 0 || key == null || key.length == 0)) {
            try {
                SecretKeySpec secretKey = new SecretKeySpec(key, algorithm);
                Mac mac = Mac.getInstance(algorithm);
                mac.init(secretKey);
                bArr = mac.doFinal(data);
            } catch (InvalidKeyException e2) {
                e = e2;
                e.printStackTrace();
                return bArr;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                e.printStackTrace();
                return bArr;
            }
        }
        return bArr;
    }

    public static byte[] encryptDES2Base64(byte[] data, byte[] key) {
        return EncodeUtils.base64Encode(encryptDES(data, key));
    }

    public static String encryptDES2HexString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptDES(data, key));
    }

    public static byte[] encryptDES(byte[] data, byte[] key) {
        return desTemplate(data, key, DES_Algorithm, DES_Transformation, true);
    }

    public static byte[] decryptBase64DES(byte[] data, byte[] key) {
        return decryptDES(EncodeUtils.base64Decode(data), key);
    }

    public static byte[] decryptHexStringDES(String data, byte[] key) {
        return decryptDES(ConvertUtils.hexString2Bytes(data), key);
    }

    public static byte[] decryptDES(byte[] data, byte[] key) {
        return desTemplate(data, key, DES_Algorithm, DES_Transformation, false);
    }

    public static byte[] encrypt3DES2Base64(byte[] data, byte[] key) {
        return EncodeUtils.base64Encode(encrypt3DES(data, key));
    }

    public static String encrypt3DES2HexString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encrypt3DES(data, key));
    }

    public static byte[] encrypt3DES(byte[] data, byte[] key) {
        return desTemplate(data, key, TripleDES_Algorithm, TripleDES_Transformation, true);
    }

    public static byte[] decryptBase64_3DES(byte[] data, byte[] key) {
        return decrypt3DES(EncodeUtils.base64Decode(data), key);
    }

    public static byte[] decryptHexString3DES(String data, byte[] key) {
        return decrypt3DES(ConvertUtils.hexString2Bytes(data), key);
    }

    public static byte[] decrypt3DES(byte[] data, byte[] key) {
        return desTemplate(data, key, TripleDES_Algorithm, TripleDES_Transformation, false);
    }

    public static byte[] encryptAES2Base64(byte[] data, byte[] key) {
        return EncodeUtils.base64Encode(encryptAES(data, key));
    }

    public static String encryptAES2HexString(byte[] data, byte[] key) {
        return ConvertUtils.bytes2HexString(encryptAES(data, key));
    }

    public static byte[] encryptAES(byte[] data, byte[] key) {
        return desTemplate(data, key, AES_Algorithm, AES_Transformation, true);
    }

    public static byte[] decryptBase64AES(byte[] data, byte[] key) {
        return decryptAES(EncodeUtils.base64Decode(data), key);
    }

    public static byte[] decryptHexStringAES(String data, byte[] key) {
        return decryptAES(ConvertUtils.hexString2Bytes(data), key);
    }

    public static byte[] decryptAES(byte[] data, byte[] key) {
        return desTemplate(data, key, AES_Algorithm, AES_Transformation, false);
    }

    public static byte[] desTemplate(byte[] data, byte[] key, String algorithm, String transformation, boolean isEncrypt) {
        byte[] bArr = null;
        if (!(data == null || data.length == 0 || key == null || key.length == 0)) {
            try {
                SecretKeySpec keySpec = new SecretKeySpec(key, algorithm);
                Cipher cipher = Cipher.getInstance(transformation);
                cipher.init(isEncrypt ? 1 : 2, keySpec, new SecureRandom());
                bArr = cipher.doFinal(data);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return bArr;
    }
}