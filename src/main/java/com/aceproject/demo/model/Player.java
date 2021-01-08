package com.aceproject.demo.model;

import javax.persistence.Id;

import com.aceproject.gamebox.lang.DTO;
import com.aceproject.gamebox.orm.annotation.JsonColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor  //아무것도 받지않는 기본 생성
@AllArgsConstructor //멤버변수 다 받는 기본 생성자 
@Data  //getter setter 
@EqualsAndHashCode(callSuper = true)
public class Player extends DTO {

	private static final long serialVersionUID = 5888783319049507204L;

	@Id  //key 명시 
	private int playerId;
	private String name;

	@JsonColumn  // 객체를 json으로 바꿔서 db 저장 
	private Stat stat;

}