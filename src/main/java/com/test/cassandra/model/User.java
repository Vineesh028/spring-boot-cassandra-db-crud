package com.test.cassandra.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

  private int id;
  private String name;
  private String nickName;
  private String email;


}