package TestDate;

import com.github.javafaker.Faker;

public class Credentials {

    private Faker faker = new Faker();

    private String userEmail = "taras.mokretsky@gmail.com";

    private String userPassword = "zam6416taras21&";

    private String userPhoneNumber = "+380932394685";

    private String newUserName = faker.name().fullName();


    public String getNewUserName() {
        return newUserName;
    }


    public String getUserEmail() {
        return userEmail;
    }


    public String getUserPassword() {
        return userPassword;
    }


    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }


    public String generateNewUserPassword(){
        String newPassword = String.valueOf(faker.idNumber()) + faker.name();
        userPassword = newPassword;
        return userPassword;
    }
}