package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
	@Id
	private Long seq;
	
	private Long code;
	
	private String name;
	
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private List<MemberLike> memberLikeList = new ArrayList<MemberLike>();
	
}
