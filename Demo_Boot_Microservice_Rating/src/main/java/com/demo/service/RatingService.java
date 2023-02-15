package com.demo.service;

import java.util.List;

import com.demo.bean.Rating;

public interface RatingService {
	
	public List<Rating> getAllRating();
	
	public Rating getRating(String id);
	
	public Rating addRating(Rating rating);
	
	public Rating updateRating(Rating rating);
	
	public String deleteRating(String id);
	
}
