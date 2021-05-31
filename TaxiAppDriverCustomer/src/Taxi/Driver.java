package Taxi;

import java.time.LocalDate;

public class Driver {
    private int id;
    private String full_name;
    private int age;
    private String phone_num;
    private String car_model;
    private int number_of_seats;
    private String date;
    private String destination;

    public Driver(int id, String full_name, int age, String phone_num, String car_model, int number_of_seats, String date, String destination) {
        this.id = id;
        this.full_name = full_name;
        this.age = age;
        this.phone_num = phone_num;
        this.car_model = car_model;
        this.number_of_seats = number_of_seats;
        this.date = date;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
