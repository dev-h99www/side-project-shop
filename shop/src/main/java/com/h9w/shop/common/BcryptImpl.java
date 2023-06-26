package com.h9w.shop.common;

import com.h9w.shop.common.EncryptHelper;
import com.h9w.shop.common.EncryptHelper;
import org.mindrot.jbcrypt.BCrypt;

public class BcryptImpl implements EncryptHelper {

    @Override
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean isMatch(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
