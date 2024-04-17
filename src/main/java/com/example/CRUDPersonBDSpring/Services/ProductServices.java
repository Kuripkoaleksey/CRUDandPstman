package com.example.CRUDPersonBDSpring.Services;

import com.example.CRUDPersonBDSpring.models.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServices {
    public void insert(Person person) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Success connect");
            String url = "jdbc:mysql://localhost:3306/idea";
            String password = "Skorost15";
            String username = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            {
                String insertQuery = """
                        insert into Person (name, age, email,  phone, birth, gender) values (?,?,?,?,?,?);
                        """;
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, person.getName());
                preparedStatement.setDouble(2, person.getAge());
                preparedStatement.setString(3, person.getEmail());
                preparedStatement.setString(4, person.getPhone());
                preparedStatement.setString(5, person.getBirth());
                preparedStatement.setString(6, person.getGender());

                int insertRow = preparedStatement.executeUpdate();
                System.out.println("Было добавлено " + insertRow + " строки");
                connection.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void update(Person person) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Success connect");
            String url = "jdbc:mysql://localhost:3306/idea";
            String password = "Skorost15";
            String username = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            {
                String updateQuery = "UPDATE Person SET ";
                int index = 1;
                if (person.getName() != null) {
                    updateQuery += " name = ? ";
                }
                if (person.getAge() != 0) {
                    updateQuery += " , age = ? ";
                }
                if (person.getEmail() != null) {
                    updateQuery += " , email = ? ";
                }
                if (person.getPhone() != null) {
                    updateQuery += " , phone = ? ";
                }
                if (person.getBirth() != null) {
                    updateQuery += " , birth = ? ";
                }
                if (person.getGender() != null) {
                    updateQuery += " , gender = ? ";
                }
                updateQuery += "WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                if (person.getName() != null) {
                    preparedStatement.setString(index++, person.getName());
                }
                if (person.getAge() != 0) {
                    preparedStatement.setDouble(index++, person.getAge());
                }
                if (person.getEmail() != null) {
                    preparedStatement.setString(index++, person.getEmail());
                }
                if (person.getPhone() != null) {
                    preparedStatement.setString(index++, person.getPhone());
                }
                if (person.getBirth() != null) {
                    preparedStatement.setString(index++, person.getBirth());
                }
                if (person.getGender() != null) {
                    preparedStatement.setString(index++, person.getGender());
                }
                preparedStatement.setInt(index, person.getId());
                preparedStatement.executeUpdate();
                int updatedRows = preparedStatement.executeUpdate();
                System.out.println("Было обновлено " + updatedRows + " строки");

                // Закрываем соединение
                preparedStatement.close();
                connection.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<Person> read() {
        List<Person> persons = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Success connect");
            String url = "jdbc:mysql://localhost:3306/idea";
            String password = "Skorost15";
            String username = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            {
                String selectQuery = """
                        SELECT * FROM Person;
                        """;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("id"));
                    person.setName(resultSet.getString("name"));
                    person.setAge(resultSet.getDouble("age"));
                    person.setEmail(resultSet.getString("email"));
                    person.setPhone(resultSet.getString("phone"));
                    person.setBirth(resultSet.getString("birth"));
                    person.setGender(resultSet.getString("gender"));
                    persons.add(person);
                }
                connection.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return persons;
    }

    public void delete(Person person) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Success connect");
            String url = "jdbc:mysql://localhost:3306/idea";
            String password = "Skorost15";
            String username = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            {
                String deleteQuery = "DELETE FROM person WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, person.getId()); // Добавляем ID для WHERE
                int deletedRows = preparedStatement.executeUpdate();
                System.out.println("Было удалено " + deletedRows + " строки");
                connection.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
