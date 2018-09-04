package com.test.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Valid
@Data
public class TextSearchDto {

    @NotEmpty
    List<String> searchText = new ArrayList<>();

	public List<String> getSearchText() {

		return searchText;
	}
}
