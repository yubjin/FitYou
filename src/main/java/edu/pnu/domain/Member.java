package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	private String username;
	private String pwd;
	
	private int age;
	
	private int cusNum;
	
	private String regidate;
	
	private String styleInfo;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	private List<MemberLike> memberLikeList = new ArrayList<MemberLike>();
	
	
	/*
	 * @OneToMany(mappedBy="member", fetch=FetchType.EAGER) private
	 * List<MemberDetail> memberDetailList = new ArrayList<MemberDetail>();
	 */
}
