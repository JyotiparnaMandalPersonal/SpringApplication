package com.home.pathtracing.service;

import java.util.List;

import com.home.pathtracing.dto.NavigationPointDto;
import com.home.pathtracing.entity.NavigationPoint;

public interface TracingService {
	
	public NavigationPoint displayStartPoint();
	
	public NavigationPoint moveRight(int step);
	
	public NavigationPoint moveLeft(int step);
	
	public NavigationPoint moveUp(int step);
	
	public NavigationPoint moveDown(int step);
	
	public List<NavigationPointDto> displayAll();

}
