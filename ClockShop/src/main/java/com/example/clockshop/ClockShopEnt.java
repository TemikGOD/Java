package com.example.clockshop;

import jakarta.persistence.*;

@Entity
@Table(name = "clockshop")
public class ClockShopEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Shop")
    private String shop;

    public ClockShopEnt() {

    }

    public int getId(){
        return id;
    }

    public String getShop(){
        return shop;
    }

    public void setId(int _id){
        id = _id;
    }

    public void setShop(String _shop){
        shop = _shop;
    }

    public ClockShopEnt(String _save){
        shop = _save;
    }
}
