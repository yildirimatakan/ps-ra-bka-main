package models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class UserModel {

    @CsvBindByName(column = "id")
    public long id;

    @CsvBindByName(column = "userName")
    public String username;

    @CsvBindByName(column = "firstName")
    public String firstName;

    @CsvBindByName(column = "lastName")
    public String lastName;

    @CsvBindByName(column = "email")
    public String email;

    @CsvBindByName(column = "password")
    public String password;

    @CsvBindByName(column = "phone")
    public String phone;

    @CsvBindByName(column = "userStatus")
    public int userStatus;

    public UserModel(long id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public UserModel() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserStatus() {
        return userStatus;
    }
}
