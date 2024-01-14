package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;

public class RandomUtils {

    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }


    Faker faker = new Faker(new Locale("de"));
    //
//
    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String userEmail = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress();
    String name = firstName + " " + lastName;//

}
