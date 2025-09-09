package com.example.Laptop.dao.DaoImp;
//entry point of project
import com.example.laptop.Dao.LaptopDao;
import com.example.laptop.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LaptopDaoImpl implements LaptopDao {


    private final EntityManager theLatpot;

    @Autowired
    public LaptopDaoImpl(EntityManager theLaptop) {
        this.theLatpot = theLaptop;
    }

    @Override
    @Transactional
    public void save(Laptop theLaptop) {

        theLatpot.persist(theLaptop);
    }

    @Override
    public Laptop findById(int theId) {
        return theLatpot.find(Laptop.class, theId);
    }

    @Override
    public List fetchAll() {
        Query query = theLatpot.createQuery("Select l from Laptop l");
        return query.getResultList();

    }

    ;

    @Override
    public Laptop findByImeiNo(long theimeiNo) {
        try {
            Query query = theLatpot.createQuery("Select l from Laptop l Where imei=:imeiNo");
            query.setParameter("imeiNo", theimeiNo);
            return (Laptop) query.getSingleResult();
        } catch (Exception E) {
            return null;
        }
    }

    ;

    @Transactional
    @Override
    public void deleteById(int theId) {
        Laptop laptop = theLatpot.find(Laptop.class, theId); // (A)
        if (laptop != null) {
            theLatpot.remove(laptop); // (B)
        }
    }

    @Override
    @Transactional
    public void update(Laptop theLaptop) {
        theLatpot.merge(theLaptop); // merge updates the existing entity


    }
}