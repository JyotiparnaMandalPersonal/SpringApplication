package com.home.pathtracing.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.home.pathtracing.service.TracingService;
import com.home.pathtracing.dto.NavigationPointDto;
import com.home.pathtracing.entity.NavigationPoint;

@RestController
@RequestMapping("/trace")
public class PathTracingController {
	
	@Autowired
	private TracingService tracingService;
	
@GetMapping("/startpoint")	
public ResponseEntity<NavigationPoint> displayStartCoordinate() {
	
	     NavigationPoint startPoint=  tracingService.displayStartPoint();     
	     return new ResponseEntity<>(startPoint, HttpStatus.OK);
}


@PostMapping("/moveright/{step}")
public ResponseEntity<NavigationPoint> moveRight(@PathVariable String step) {
	NavigationPoint finalCoordinate = tracingService.moveRight(Integer.parseInt(step));
	
	return new ResponseEntity<>(finalCoordinate, HttpStatus.CREATED);
	
}

@PostMapping("/moveleft/{step}")
public ResponseEntity<NavigationPoint> moveLeft(@PathVariable String step) {
	NavigationPoint finalCoordinate = tracingService.moveLeft(Integer.parseInt(step));
	
	return new ResponseEntity<>(finalCoordinate, HttpStatus.CREATED);
	
}

@PostMapping("/moveup/{step}")
public ResponseEntity<NavigationPoint> moveUp(@PathVariable String step) {
	NavigationPoint finalCoordinate = tracingService.moveUp(Integer.parseInt(step));
	
	return new ResponseEntity<>(finalCoordinate, HttpStatus.CREATED);
	
}


@PostMapping("/movedown/{step}")
public ResponseEntity<NavigationPoint> moveDown(@PathVariable String step) {
	NavigationPoint finalCoordinate = tracingService.moveDown(Integer.parseInt(step));
	
	return new ResponseEntity<>(finalCoordinate, HttpStatus.CREATED);
	
}

@GetMapping("/show")
public ResponseEntity<List<NavigationPointDto>> displayCoordinates() {
	
	List<NavigationPointDto> allCoordinates = tracingService.displayAll();
	return new ResponseEntity<>(allCoordinates, HttpStatus.OK);
}

}
