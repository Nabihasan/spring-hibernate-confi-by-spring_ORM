package com.ms;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	@Id
	private int eno;
	private String name;
	private String dept;
	private String desg;
	private int salary;
}
