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
	private int cusNum;			//고객번호
	
	private String sellDt;		//판매일자
	private int sellNum;		//전표번호
	private String shopCode;	//매장코드
	private String prodCode;	//상품코드
	private String prodName;	//상품명
	private String colorName;	//칼라
	private String size;		//사이즈
	private int sellPrice;		//판매금액
	private int sellCount;		//수량

}
