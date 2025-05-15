package com.home.pathtracing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.home.pathtracing.entity.NavigationPoint;


public interface TracePointRepository extends JpaRepository<NavigationPoint, Integer>{
	
	
	NavigationPoint findFirstByOrderByIdDesc();

}

