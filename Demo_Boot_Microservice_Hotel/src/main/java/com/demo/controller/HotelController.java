package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Hotel;
import com.demo.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService service;

	@GetMapping("/home")
	public String home() {
		return "Hello";
	}

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		try {
			List<Hotel> hotelList = service.getAllHotel();
			if (hotelList.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(hotelList));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/hotels/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
		try {
			Hotel hotel = service.getHotel(id);
			if (hotel == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(hotel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		try {
			Hotel usr = service.addHotel(hotel);
			return ResponseEntity.of(Optional.of(usr));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/users")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
		try {
			this.service.updateHotel(hotel);
			return ResponseEntity.ok().body(hotel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable String id) {
		try {
			String message = service.deleteHotel(id);
			System.out.println(message);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
