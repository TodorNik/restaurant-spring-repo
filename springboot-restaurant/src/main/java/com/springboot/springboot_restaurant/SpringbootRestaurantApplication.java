package com.springboot.springboot_restaurant;

import java.sql.Connection;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestaurantApplication.class, args);
		System.out.println("Hello!");
		RestaurantFunctions db = new RestaurantFunctions();
		Connection conn = db.connect_to_db("testrestaurant", "postgres", "nikolatodor2");
		
		//db.createTable(conn, "restaurant");
		db.insertRow(conn,"restaurant", "Big Ben", "Tivat");
		db.insertRow(conn,"restaurant", "Marquez", "Podgorica");
		db.insertRow(conn,"restaurant", "Piazza", "Niksic");
		db.insertRow(conn,"restaurant", "Raccoon in the Garden", "Bar");
		db.insertRow(conn,"restaurant", "Fontana", "Niksic");
		db.insertRow(conn,"restaurant", "Bacchus", "Tivat");
		db.insertRow(conn,"restaurant", "Marienplatz", "Podgorica");
		db.insertRow(conn,"restaurant", "Vuk", "Podgorica");
		db.readData(conn, "restaurant");
		db.updateData(conn, "restaurant", "Big Ben", "Reccoleta");	
		System.out.println("Passed Update");
		db.searchByName(conn, "restaurant", "Marquez");
		System.out.println("Passed Search");
		db.deleteByName(conn, "restaurant", "Marquez");
		
		//db.deleteTable(conn, "restaurant");

	}

}
