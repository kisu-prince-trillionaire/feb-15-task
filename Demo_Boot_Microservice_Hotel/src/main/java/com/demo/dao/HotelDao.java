package com.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bean.Hotel;

@Repository
public interface HotelDao extends CrudRepository<Hotel, String> {

}
