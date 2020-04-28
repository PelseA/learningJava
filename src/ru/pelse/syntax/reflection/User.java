package ru.pelse.syntax.reflection;

@ConfigClass(prefix = "section", gender = Gender.CHILD, version = 34)
public class User {
    private String login;
    @Required
    private int age;

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }

    public User() { }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    @Required
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                '}';
    }
}




