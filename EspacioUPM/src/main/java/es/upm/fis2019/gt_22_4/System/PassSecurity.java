package es.upm.fis2019.gt_22_4.System;

import es.upm.fis2019.gt_22_4.Interfaces.IPasswordHasher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PassSecurity implements IPasswordHasher {
    public String hash(String passwordToHash) {
        if (passwordToHash == null) passwordToHash = "";
        passwordToHash = "Whats_" + passwordToHash + "_UPM";

        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X", bytes[i]));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
