package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Hotel;
import com.demo.dao.HotelDao;
import com.demo.exception.ResourceNotFoundException;


@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDao dao;

	@Override
	public List<Hotel> getAllHotel() {
		return (List<Hotel>) dao.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found" + id));
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		return dao.save(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		return dao.save(hotel);
	}

	@Override
	public String deleteHotel(String id) {
		dao.deleteById(id);
		return "Deleted Sucessfully";
	}

}
