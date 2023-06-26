package com.h9w.shop.common;

public interface EncryptHelper {
    String encrypt(String password);
    boolean isMatch(String password, String hashed);
}
