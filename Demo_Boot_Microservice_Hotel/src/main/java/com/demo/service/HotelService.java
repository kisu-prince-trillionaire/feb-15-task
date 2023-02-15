package com.demo.service;

import java.util.List;

import com.demo.bean.Hotel;

public interface HotelService {

	public List<Hotel> getAllHotel();

	public Hotel getHotel(String id);

	public Hotel addHotel(Hotel hotel);

	public Hotel updateHotel(Hotel hotel);

	public String deleteHotel(String id);
}
