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

import com.demo.bean.Rating;
import com.demo.service.RatingService;

public class RatingController {
	
	@Autowired
	private RatingService service;

	@GetMapping("/home")
	public String home() {
		return "Hello";
	}

	@GetMapping("/ratings")
	public ResponseEntity<List<Rating>> getAllRating() {
		try {
			List<Rating> ratingList = service.getAllRating();
			if (ratingList.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(ratingList));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/ratings/{id}")
	public ResponseEntity<Rating> getRating(@PathVariable String id) {
		try {
			Rating rating = service.getRating(id);
			if (rating == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(rating));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/ratings")
	public ResponseEntity<Rating> addHotel(@RequestBody Rating rating) {
		try {
			Rating usr = service.addRating(rating);
			return ResponseEntity.of(Optional.of(usr));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/ratings")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
		try {
			this.service.updateRating(rating);
			return ResponseEntity.ok().body(rating);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("/ratings/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable String id) {
		try {
			String message = service.deleteRating(id);
			System.out.println(message);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
