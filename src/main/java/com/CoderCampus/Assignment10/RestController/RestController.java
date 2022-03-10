package com.CoderCampus.Assignment10.RestController;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CoderCampus.Assignment10.spoonapi.SpoonacularAPI;
import com.CoderCampus.Assignment10.spoonapi.dto.WeekResponse;
import com.CoderCampus.Assignment10.spoonapi.dto.days.DayResponse;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	

	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam(required = false) String targetCalories,
			@RequestParam Optional<String> diet, @RequestParam Optional<String> exclude){
		SpoonacularAPI spoonacularApi = new SpoonacularAPI();
		ResponseEntity<WeekResponse> week = spoonacularApi.callSpoonApiWeek(targetCalories, diet, exclude);
		return week;
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(@RequestParam(required = false) String targetCalories,
			@RequestParam(required = false) Optional<String> diet, @RequestParam(required = false) Optional<String> exclude){
		SpoonacularAPI spoonacularApi = new SpoonacularAPI();
		ResponseEntity<DayResponse> day = spoonacularApi.callSpoonApiDays(targetCalories, diet, exclude);
		return day;
	}
	
}
