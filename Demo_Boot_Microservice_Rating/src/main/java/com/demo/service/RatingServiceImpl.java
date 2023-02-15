package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Rating;
import com.demo.dao.RatingDao;
import com.demo.exception.ResourceNotFoundException;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao dao;
	
	@Override
	public List<Rating> getAllRating() {
		return (List<Rating>) dao.findAll();
	}

	@Override
	public Rating getRating(String id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("rating of given id not present !! " + id));
	}

	@Override
	public Rating addRating(Rating rating) {
		return dao.save(rating);
	}

	@Override
	public Rating updateRating(Rating rating) {
		return dao.save(rating);
	}

	@Override
	public String deleteRating(String id) {
		dao.deleteById(id);
		return "Deleted Sucessfully";
	}

}
