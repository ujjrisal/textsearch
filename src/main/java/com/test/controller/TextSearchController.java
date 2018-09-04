package com.test.controller;

import com.test.dto.TextSearchDto;
import com.test.service.TextSearchService;

import java.util.Map;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/counter-api/search")
@AllArgsConstructor
public class TextSearchController {
	
	private TextSearchService textSearchService;
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Integer>> searchText(@RequestBody TextSearchDto textSearchDto) {
		Map<String, Integer>  countMap = textSearchService.search(textSearchDto.getSearchText());

		return new ResponseEntity<Map<String, Integer>>(countMap, HttpStatus.OK);
	}

}
