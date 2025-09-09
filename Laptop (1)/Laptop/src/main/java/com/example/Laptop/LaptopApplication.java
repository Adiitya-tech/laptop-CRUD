package com.example.Laptop;
//Brain of project
import com.example.laptop.Dao.LaptopDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootApplication
public class LaptopApplication {

    @Bean
    public CommandLineRunner commandLineRunner(LaptopDao theLaptopDao){
        return runner ->{

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the Option : ");
            int input = sc.nextInt(); ;
            sc.nextLine();

            switch (input) {

                case 1 :
                    for (int i=1 ; i<=3 ; i++) {
                        System.out.print("Enter Brand Name : ");
                        String brand = sc.nextLine();

                        System.out.print("Enter IMEI Number : ");
                        long imei = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Enter RAM : ");
                        int ram = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Processor : ");
                        String processor = sc.next();

                        System.out.print("Enter Price : ");
                        double price = sc.nextDouble();
                        sc.nextLine();


                        theLaptopDao.save(new com.example.laptop.Laptop(brand, imei, ram, processor, price));
                        System.out.println("Laptop Saved Successfully !!");
                    }
                    break;

                case 2:

                    System.out.print("Enter the Laptop Id to Fetch : ");
                    com.example.laptop.Laptop byId = theLaptopDao.findById(sc.nextInt());
                    if (byId!=null){
                        System.out.println(byId);
                        System.out.println("Laptop Found !");
                        break;
                    }
                    else{
                        System.out.println("Laptop Not Found !");
                        break;
                    }
                case 3:

                    List<com.example.laptop.Laptop> laptops = theLaptopDao.fetchAll();
                    for (com.example.laptop.Laptop lappy : laptops)
                    {
                        System.out.println(lappy);
                    }
                    break;

                case 4:

                    System.out.print("Enter Laptop's Imei No. To Fetch : ");
                    com.example.laptop.Laptop byImei = theLaptopDao.findByImeiNo(sc.nextLong());
                    if (byImei!=null)
                    {
                        System.out.println(byImei);
                        System.out.println("Laptop found Successfully !!");
                        break;
                    }
                    else
                    {
                        System.out.println("Laptop Not Found !!");
                        break;
                    }

                case 5: // Delete by ID
                    System.out.print("Enter Laptop ID to Delete: ");
                    int id = sc.nextInt();

                    com.example.laptop.Laptop laptop = theLaptopDao.findById(id);
                    if (laptop != null) {
                        theLaptopDao.deleteById(id); // must be inside @Transactional
                        System.out.println("Laptop Deleted Successfully ");
                    } else {
                        System.out.println("Laptop Not Found ");
                    }
                    break;

                case 6:
                    System.out.print("Enter Laptop ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // consume newline

                    com.example.laptop.Laptop laptopToUpdate = theLaptopDao.findById(updateId);

                    if (laptopToUpdate != null) {
                        System.out.print("Enter new Brand: ");
                        laptopToUpdate.setBrand(sc.nextLine());

                        System.out.print("Enter new Processor: ");
                        laptopToUpdate.setProcessor(sc.nextLine());

                        System.out.print("Enter new IMEI No: ");
                        laptopToUpdate.setImei(sc.nextLong());

                        System.out.print("Enter new Ram: ");
                        laptopToUpdate.setRam(sc.nextInt());

                        System.out.print("Enter new priceNo: ");
                        laptopToUpdate.setPrice(sc.nextInt());

                        theLaptopDao.update(laptopToUpdate);
                        System.out.println("Laptop Updated Successfully ");
                    } else {
                        System.out.println("Laptop Not Found ");
                    }
                    break;






            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LaptopApplication.class, args);
    }

}