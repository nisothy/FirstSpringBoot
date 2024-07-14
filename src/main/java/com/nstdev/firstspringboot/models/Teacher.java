package com.nstdev.firstspringboot.models;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "teachers")
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "salary")
    private float salary;
    private String status;
    @Transient
    private List<ItemKey> statusList;
    @ManyToOne
    private Position position;

    private String phoneNumber;
    //Contractor

    public Teacher(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Teacher() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<ItemKey> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<ItemKey> statusList) {
        this.statusList = statusList;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", status='" + status + '\'' +
                ", statusList=" + statusList +
                ", position=" + position +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
