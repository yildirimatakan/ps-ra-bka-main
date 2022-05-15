package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.opencsv.CSVWriter;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.lang.*;

public class RandomDataCreator {

    @Test
    public static void createUserData(){
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Faker faker = new Faker();

        long id = faker.idNumber().hashCode();
        String userName = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = fakeValuesService.bothify("????????##@gmail.com");
        String password = fakeValuesService.regexify("[a-z1-9]{8}");
        String phone = faker.phoneNumber().cellPhone();
        int userStatus = faker.number().numberBetween(1,999);


        try {
            File myObj = new File("userData.csv");
            FileWriter outputfile = new FileWriter("userData.csv");
            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = { "id", "userName", "firstName", "lastName", "email", "password", "phone", "userStatus"};
            writer.writeNext(header);

            String[] data1 = { String.valueOf(id), userName, firstName, lastName, email, password, phone, String.valueOf(userStatus)};
            writer.writeNext(data1);

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
