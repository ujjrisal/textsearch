package com.test.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TextSearchService {

	private Map<String, Integer> tokenAndCount = new HashMap<>();

	public Map<String, Integer>  search(List<String> textsToSearch) {

		textsToSearch.stream().forEach(text -> {
			tokenAndCount.put(text, 0);
		});

		try {

			List<String> dataLines = Files.readAllLines(Paths.get("src/main/resources/textFile.txt"));

			dataLines.stream().map(dataLine -> dataLine.split(" ")).forEach(data -> {

				List<String> token = Arrays.asList(data);

				token.stream().forEach( token1 -> {
					if(tokenAndCount.containsKey(token1)) {
						tokenAndCount.put(token1, tokenAndCount.get(token1) + 1 );
					}
				});
			});
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return tokenAndCount;
	}

}
