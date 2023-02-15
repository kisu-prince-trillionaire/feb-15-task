package com.demo.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {
	@Id
	private String ratingId;
	@Column
	private String userId;
	@Column
	private String hotelId;
	@Column
	private int rating;
	@Column
	private String feedback;
}
