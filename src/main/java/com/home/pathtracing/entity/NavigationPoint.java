package com.home.pathtracing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "trace_coordinate")
public class NavigationPoint {

	@Id
	private int id;
	private int xCoordinate;
	private int yCoordinate;
}
