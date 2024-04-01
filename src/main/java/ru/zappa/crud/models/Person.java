package ru.zappa.crud.models;

import java.util.Objects;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private int id;
    private int age;
    private String phone;
    private String  birth;
    private String  gender;
    private String email;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int id, int age,String email, String phone,String birth, String gender) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setEmail(email);
        this.setPhone(phone);
        this.setBirth(birth);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public void setEmail(String email) {
        if (!Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$").matcher(email).matches()) {
            throw new IllegalArgumentException("Введенный email не соответствует формату");
        }
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public void setPhone(String phone) {
        if (!Pattern.compile("^[0-9]{1}+-[0-9]{3}+-[0-9]{3}+-[0-9]{2}+-[0-9]{2}$").matcher(phone).matches()) {
            throw new IllegalArgumentException("Введенный телефон не соответствует формату:+х-ххх-ххх-хх-хх");
        }
        this.phone = phone;
    }

    public void setBirth(String birth) {
        if (!Pattern.compile("^[0-9]{2}+.[0-9]{2}+.[0-9]{4}$").matcher(birth).matches()) {
            throw new IllegalArgumentException("Введенная дата рождения не соответствует формату:дд.мм.гггг");
        }
        this.birth = birth;
    }

    public void setGender(String gender) {
        switch (gender.toLowerCase()) {
            case "female":
                System.out.println("Вы ввели женский пол");
                this.gender = "female";
                break;
            case "male":
                System.out.println("Вы ввели мужской пол");
                this.gender = "male";
                break;
            default:
                throw new IllegalArgumentException("Некорректное значение для gender, требуется male или female");
        }
          System.out.println(gender);
    }
}



