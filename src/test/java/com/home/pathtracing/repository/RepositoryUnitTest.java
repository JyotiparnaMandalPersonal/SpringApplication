package com.home.pathtracing.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.home.pathtracing.PathtracingApplication;
import com.home.pathtracing.entity.NavigationPoint;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PathtracingApplication.class)
public class RepositoryUnitTest {
	@Autowired
	TracePointRepository tracePointRepository;
	
	
	
    @Test
    @DisplayName("Test 1:Save Starting coordinate")
    @Order(1)
	public void saveNavigationPoint() {
		
		//Action
		NavigationPoint navigationPoint = new NavigationPoint(1,15,15);	
		
		tracePointRepository.deleteAll();
		NavigationPoint	savedNavigationPoint = tracePointRepository.save(navigationPoint);
		
		//Verify
		Assertions.assertThat(navigationPoint.getId() == savedNavigationPoint.getId());
		Assertions.assertThat(navigationPoint.getXCoordinate() == savedNavigationPoint.getXCoordinate());
		Assertions.assertThat(navigationPoint.getYCoordinate() == savedNavigationPoint.getYCoordinate());
		
	}
    
    @Test
    @DisplayName("Test 2:Save another coordinate")
    @Order(2)
	public void saveAnotherNavigationPoint() {
		
		//Action
		NavigationPoint navigationPoint = new NavigationPoint(2,30,90);	
		NavigationPoint	savedNavigationPoint = tracePointRepository.save(navigationPoint);
		
		//Verify
		Assertions.assertThat(navigationPoint.getId() == savedNavigationPoint.getId());
		Assertions.assertThat(navigationPoint.getXCoordinate() == savedNavigationPoint.getXCoordinate());
		Assertions.assertThat(navigationPoint.getYCoordinate() == savedNavigationPoint.getYCoordinate());
		
		
	}

    
    @Test
    @DisplayName("Test 3:Fetch all coordinates")
    @Order(3)
	public void fetchAllNavigationPoint() {
		
		//Action		
	
		List<NavigationPoint> allCoordinates = tracePointRepository.findAll();
		
		//Verify
		Assertions.assertThat(allCoordinates.size() == 2);

		
	}
    
    
    @Test
    @DisplayName("Test 4:Fetch last coordinates inserted")
    @Order(4)
	public void fetchLastNavigationPoint() {
		
		//Action		
	
		NavigationPoint lastNavigationPoint = tracePointRepository.findFirstByOrderByIdDesc();
		
		//Verify
		Assertions.assertThat(lastNavigationPoint.getId() == 2);
		Assertions.assertThat(lastNavigationPoint.getXCoordinate() == 30 );
		Assertions.assertThat(lastNavigationPoint.getYCoordinate() == 90);

		
	}
}
