package com.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bean.Rating;

@Repository
public interface RatingDao extends CrudRepository<Rating, String> {

}
