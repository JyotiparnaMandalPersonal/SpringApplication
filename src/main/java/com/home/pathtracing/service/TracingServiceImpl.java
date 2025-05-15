package com.home.pathtracing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.pathtracing.dto.NavigationPointDto;
import com.home.pathtracing.entity.NavigationPoint;
import com.home.pathtracing.repository.TracePointRepository;

@Service
public class TracingServiceImpl implements TracingService {
	
	@Autowired
	private TracePointRepository startPointRepository;
	

	
    // Display starting coordinates	
	@Override
	public NavigationPoint displayStartPoint() {
		return startPointRepository.findAll().stream().findFirst().get();		
	}

	
    //Move right from last travesed coordinate	
	@Override
	public NavigationPoint moveRight(int step) {


		NavigationPoint lastNavigationCoordinate   = lastTrace();
		
		NavigationPoint navigationPoint = new NavigationPoint();
		navigationPoint.setId(lastNavigationCoordinate.getId()+1);
		navigationPoint.setXCoordinate(lastNavigationCoordinate.getXCoordinate()+ step);
		navigationPoint.setYCoordinate(lastNavigationCoordinate.getYCoordinate());
		
	     NavigationPoint finalCoordinate = startPointRepository.save(navigationPoint);
				
		return finalCoordinate;
	}
	

	//Move left from last travesed coordinate	
	@Override
	public NavigationPoint moveLeft(int step) {
		
		NavigationPoint lastNavigationCoordinate   = lastTrace();
		
		NavigationPoint navigationPoint = new NavigationPoint();
		navigationPoint.setId(lastNavigationCoordinate.getId()+1);
		navigationPoint.setXCoordinate(lastNavigationCoordinate.getXCoordinate() - step);
		navigationPoint.setYCoordinate(lastNavigationCoordinate.getYCoordinate());
		
	     NavigationPoint finalCoordinate = startPointRepository.save(navigationPoint);
				
		return finalCoordinate;
	}

	
	//Move up from last traversed coordinate		
	@Override
	public NavigationPoint moveUp(int step) {
		
		NavigationPoint lastNavigationCoordinate   = lastTrace();
		
		NavigationPoint navigationPoint = new NavigationPoint();
		navigationPoint.setId(lastNavigationCoordinate.getId()+1);
		navigationPoint.setXCoordinate(lastNavigationCoordinate.getXCoordinate());
		navigationPoint.setYCoordinate(lastNavigationCoordinate.getYCoordinate() + step);
		
	     NavigationPoint finalCoordinate = startPointRepository.save(navigationPoint);
				
		return finalCoordinate;
	}
	
	

	//Move down from last traversed coordinate
	@Override
	public NavigationPoint moveDown(int step) {
		
		NavigationPoint lastNavigationCoordinate   = lastTrace();
		
		NavigationPoint navigationPoint = new NavigationPoint();
		navigationPoint.setId(lastNavigationCoordinate.getId()+1);
		navigationPoint.setXCoordinate(lastNavigationCoordinate.getXCoordinate() );
		navigationPoint.setYCoordinate(lastNavigationCoordinate.getYCoordinate() - step);
		
	     NavigationPoint finalCoordinate = startPointRepository.save(navigationPoint);
				
		return finalCoordinate;
	}

	
	//Display all traversed coordinates
	@Override
	public List<NavigationPointDto> displayAll() {
	        
		List<NavigationPoint> allCoordinates = startPointRepository.findAll();
		List<NavigationPointDto> navigationPointDtoList = new ArrayList<>();

		
		allCoordinates.forEach(e -> navigationPointDtoList.add(
				new NavigationPointDto( e.getXCoordinate(), e.getYCoordinate())  ));
		
		
		return navigationPointDtoList;
		
	}
	
	
	//Fetch last navigated coordinates	
		public NavigationPoint lastTrace() {
			NavigationPoint lastNavigationCoordinate =startPointRepository.findFirstByOrderByIdDesc();		
			return lastNavigationCoordinate;
		}

}
