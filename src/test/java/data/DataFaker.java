package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFaker {
    Faker faker = new Faker(new Locale("de"));

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            streetAddress = faker.address().streetAddress(),
            name = firstName + " " + lastName,
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            yearOfbirth = String.valueOf(faker.number().numberBetween(1950,2010)),
            monthOfbirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),

    /*dayOfBirth = String.valueOf(faker.number().numberBetween(1, 30)),*/
//            dayOfBirth = String.format("%02d", faker.number().numberBetween(10, 28)),
            dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),

            subjects = faker.options().option("Arts", "Maths", "Hindi"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state)
            ;

    public String setCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }

    }


    //for checks
    public String titleModal = "Thanks for submitting the form";





}
