package com.company;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    public static String generateRandomString(){
        return new BigInteger(130, new SecureRandom()).toString(36);
    }
    public static void printMessage(String str){
        System.out.println(str);
    }
}
