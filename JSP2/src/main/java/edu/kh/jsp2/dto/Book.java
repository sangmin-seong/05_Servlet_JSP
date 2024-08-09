package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data // @Getter + @Setter + @toString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private String title;
	private String writer;
	private int price;
}
