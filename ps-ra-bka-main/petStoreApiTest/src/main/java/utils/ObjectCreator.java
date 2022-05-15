package utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import models.OrderModel;
import models.PetModel;
import models.UserModel;
import models.subModels.CategoryModel;
import models.subModels.TagModel;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectCreator extends RandomDataCreator {
    //TODO BURALARA BIRSEYLER DUSUNMEMIZ GEREKECEK
    private static long petId = 9223372000001097001L;
    private static String petName = "Pet New Added";
    private static String[] photoUrls = {"BC","KY","AY"};
    private static String status = "Available";
    private static long categoryId = 1;
    private static String categoryName = "Dog";
    private static long tagId = 1;
    private static String tagName = "Tag No 1";

    public static PetModel createPet(){
        CategoryModel category = new CategoryModel(categoryId,categoryName);
        TagModel tag = new TagModel(tagId,tagName);
        return new PetModel(petId,category,petName,photoUrls,new TagModel[]{tag},status);
    }
    public static PetModel updatePet(){
        CategoryModel category = new CategoryModel(categoryId,categoryName);
        TagModel tag = new TagModel(tagId+1,tagName +" Updated");
        return new PetModel(petId,category,petName+" Updated",photoUrls,new TagModel[]{tag},status);
    }
    public static OrderModel createOrder(){
        return new OrderModel(8,9223372000001097001L,5,"1992-10-19T07:30:21.197Z","placed",true);
    }

    //TODO buradaki kod yığını düzenlenmeli
    public static UserModel createUser(){

        createUserData();

        Map<String, String> mapping = new
                HashMap<String, String>();
        mapping.put("id", "id");
        mapping.put("userName", "username");
        mapping.put("firstName", "firstName");
        mapping.put("lastName", "lastName");
        mapping.put("email", "email");
        mapping.put("password", "password");
        mapping.put("phone", "phone");
        mapping.put("userStatus", "userStatus");

        HeaderColumnNameTranslateMappingStrategy<UserModel> strategy =
                new HeaderColumnNameTranslateMappingStrategy<UserModel>();
        strategy.setType(UserModel.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader ("userData.csv"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        List<UserModel> list = csvToBean.parse(strategy, csvReader);

        UserModel userModel = new UserModel();

        for (UserModel e : list) {
         userModel = e;
        }

        return userModel;
    }

    public static List<UserModel> createUserFromList(){
        List<UserModel> userList = new ArrayList<>();
        userList.add(new UserModel(1,"username_test1",
                "firstName_test1", "lastName_test1", "email_test1","password_test1",
                "phone_test1", 1));
        userList.add(new UserModel(2,"username_test2",
                "firstName_test2", "lastName_test2", "email_test2","password_test2",
                "phone_test2", 2));
        userList.add(new UserModel(3,"username_test3",
                "firstName_test3", "lastName_test3", "email_test3","password_test3",
                "phone_test3", 3));
        userList.add(new UserModel(4,"username_test4",
                "firstName_test4", "lastName_test4", "email_test4","password_test4",
                "phone_test4", 4));
        return userList;
    }

}
