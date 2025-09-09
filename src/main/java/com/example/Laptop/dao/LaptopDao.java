package com.example.laptop.Dao;
//Structure of project i.e interface
import com.example.laptop.Laptop;

import java.util.List;

public interface LaptopDao{

    public void save(Laptop theLaptop );

    Laptop findById(int theId);

    List<Laptop> fetchAll();

    Laptop findByImeiNo(long theimeiNo);

    void deleteById(int theId);

    void update(Laptop theLaptop);
}