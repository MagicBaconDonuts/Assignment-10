package com.CoderCampus.Assignment10.spoonapi;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.CoderCampus.Assignment10.spoonapi.dto.WeekResponse;
import com.CoderCampus.Assignment10.spoonapi.dto.days.DayResponse;

public class SpoonacularAPI {
	
	public void printsomething() {
		System.out.println("cheese");
	}
	
	public ResponseEntity<WeekResponse> callSpoonApiWeek(String targetCalories, Optional<String> diet, Optional<String> exclude) {
		RestTemplate rt = new RestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", "7de9ce2742e34d61819396562f39b159")
									  .queryParam("timeFrame", "week")
									  .queryParam("targetCalories", targetCalories != null ? Integer.parseInt(targetCalories):2000)
									  .queryParam("diet", diet)
									  .queryParam("exclude", exclude)
									  .build()
									  .toUri();
		ResponseEntity<WeekResponse> response = rt.getForEntity(uri, WeekResponse.class);
		return response;
	}
	
	public ResponseEntity<DayResponse> callSpoonApiDays() {
		RestTemplate rt = new RestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
													   .queryParam("apiKey", "7de9ce2742e34d61819396562f39b159")
													   .queryParam("timeFrame", "day")
													   .queryParam("targetCalories", "2000")
													   .queryParam("diet", "vegetarian")
													   .queryParam("exclude", "shellfish, olives")
													   .build()
													   .toUri();
		ResponseEntity<DayResponse> response = rt.getForEntity(uri, DayResponse.class);
		return response;
	}
}
