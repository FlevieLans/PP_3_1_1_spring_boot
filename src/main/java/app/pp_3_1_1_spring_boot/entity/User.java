package app.pp_3_1_1_spring_boot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Pattern(regexp = "^[A-Z[А-ЯЁ]][a-z[а-яё]]{1,15}", message = "Name is incorrect. Example: Иван / Ivan")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^[A-Z[А-ЯЁ]][a-z[а-яё]]{1,30}", message = "Surname is incorrect. Example: Иванов / Ivanov")
    @Column(name = "surname")
    private String surname;

    @Range(min = 0, max = 100, message = "Age is incorrect. Use range from 0 to 100.")
    @Column(name = "age")
    private int age;


    public User() {}

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

}
