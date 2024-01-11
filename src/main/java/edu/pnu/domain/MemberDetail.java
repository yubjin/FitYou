package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class MemberDetail {
	@Id
	private Long seq;
	
	private int cusNum;
	private String sellDt;		//판매일자
	private int sellNum;		//전표번호
	private String shopCode;	//매장코드
	private String prodCode;	//상품코드
	private String colorName;	//칼라
	private String size;		//사이즈
	private int sellCount;		//수량

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="cusNum") private Member member;
	 */
}
