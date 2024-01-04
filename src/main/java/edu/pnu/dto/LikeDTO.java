package edu.pnu.dto;

import java.util.List;

import lombok.Data;

@Data
public class LikeDTO {
	private List<String> like;
	private Long seq;
}
