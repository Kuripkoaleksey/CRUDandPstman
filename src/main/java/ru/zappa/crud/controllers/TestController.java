package ru.zappa.crud.controllers;


import org.springframework.web.bind.annotation.*;
import ru.zappa.crud.models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("test")

public class TestController {
    List<Person> contacts;

    public TestController() {
        initList();
    }

    static int id = 0;
    private  void initList() {
        contacts = new ArrayList<>();
    }

    @PostMapping("/add")
    public boolean addUser(@RequestParam(required = true) int id,
                           @RequestParam(required = true) String field_n,
                           @RequestParam(required = true) int age,
                           @RequestParam(required = true) String email,
                           @RequestParam(required = true) String phone,
                           @RequestParam(required = true) String birth,
                           @RequestParam(required = true) String gender){
        Person person = (Person) contacts.stream().filter(x->x.getId()==id).findFirst().orElse(null);
        if (person == null){
            System.out.println("Информация о человеке добавлена");
            contacts.add(new Person(field_n,id,age,email,phone,birth,gender));

            return true;
        }else{
            System.out.println("Указанный ID занят");//
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateUser(String field_n, int id, int age, String email, String phone,String birth, String gender){
        Person person = contacts.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
        if (person != null) {
            person.setName(field_n);
            person.setId(id);
            person.setAge(age);
            person.setEmail(email);
            person.setPhone(phone);
            person.setBirth(birth);
            person.setGender(gender);
            System.out.println("Запись с идентификатором "+ id + " изменена");
            return true;
        } else {
            System.out.println("Запись с идентификатором "+ id + " не найдена");
            return false;
        }
    }
    @PutMapping("/delite")
    public boolean deliteUser(int id){
        Person person = contacts.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
        if (person != null) {
            contacts.remove(person);
            System.out.println("Запись с именем "+ id + " удалена");
            return true;
        } else {
            System.out.println("Запись с именем "+ id + " не найдена");
            return false;
        }
    }
    
    @GetMapping("/all")
    public List<Person> getAll(){
        return contacts;
    }

    @GetMapping("/user")
    public Person infoUser(int id){
        Person person = contacts.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
        if (person != null) {
                       return person;
        } else {
            System.out.println("Запись с идентификатором "+ id + " не найдена");
            return null;
        }
    }

    @GetMapping("/sort")
    public List<Person> sortName() {
        Comparator<Person> comparator = (person1, person2) -> person1.getName().compareTo(person2.getName());
        List<Person> sortedContacts = contacts.stream().sorted(comparator).collect(Collectors.toList());
        return sortedContacts;
    }

    @GetMapping("/poiskUser")
    public Person infoUser(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
                           @RequestParam(value = "age", required = false, defaultValue = "0") int age,
                           String field_n, String email, String phone,
                           String birth,
                           String gender){
        Person person = contacts.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
        Person person1 = contacts.stream().filter(x -> x.getName().equals(field_n)).findFirst().orElse(null);
        Person person2 = contacts.stream().filter(x -> x.getAge()==age).findFirst().orElse(null);
        Person person3 = contacts.stream().filter(x -> x.getEmail().equals(email)).findFirst().orElse(null);
        Person person4 = contacts.stream().filter(x -> x.getPhone().equals(phone)).findFirst().orElse(null);
        Person person5 = contacts.stream().filter(x -> x.getBirth().equals(birth)).findFirst().orElse(null);
        Person person6 = contacts.stream().filter(x -> x.getGender().equals(gender)).findFirst().orElse(null);
        if (person != null) {
            return person;
            }
        else if (person1 != null) {
            return person1;}
        else if (person2 != null) {
            return person2;
        }
        else if (person3 != null) {
            return person3;
        }
        else if (person4 != null) {
            return person4;
        }
        else if (person5 != null) {
            return person5;
        }
        else if (person6 != null) {
            return person6;
        }
        else {
            System.out.println("Запись с указанной информацией не найдена");
            return null;
        }
    }
}

