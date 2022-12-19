package com.example.clockshop.entity;

import jakarta.persistence.*;

@Entity
public class ClockShop {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "cost")
    private Integer cost;
    @Basic
    @Column(name = "time")
    private Object time;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClockShop clockShop = (ClockShop) o;

        if (id != clockShop.id) return false;
        if (name != null ? !name.equals(clockShop.name) : clockShop.name != null) return false;
        if (cost != null ? !cost.equals(clockShop.cost) : clockShop.cost != null) return false;
        if (time != null ? !time.equals(clockShop.time) : clockShop.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
