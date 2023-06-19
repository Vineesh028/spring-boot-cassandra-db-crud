package com.test.cassandra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("Users")
public class UserEntity {

	@Id
	@PrimaryKey
	private int id;
	private String name;
	private String nickName;
	private String email;

}