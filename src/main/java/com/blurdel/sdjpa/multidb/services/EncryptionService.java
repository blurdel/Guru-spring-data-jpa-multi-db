package com.blurdel.sdjpa.multidb.services;

public interface EncryptionService {

	String encrypt(String freeText);

    String decrypt(String encryptedText);
    
}
