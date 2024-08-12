package edu.kh.member.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member implements Serializable{

//  DTO (Data Transfer Object) : 데이터 전달용 객체
	// - 여러 데이터를 한번에 담아서 
	//   계층 간 데이터를 전달하는 목적
	
	// 계층 : view, service, dao 등 다른 클래스
	
	
	// 등급을 나타내는 상수
	public static final int COMMON = 0;
	public static final int GOLD = 1;
	public static final int DIAMOND = 2;

	// 회원 정보를 저장할 필드
	private int    index;
	private String name;
	private String phone;
	private int    amount;
}

