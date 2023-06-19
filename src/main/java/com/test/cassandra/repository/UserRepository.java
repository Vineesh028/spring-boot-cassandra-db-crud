package com.test.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.test.cassandra.entity.UserEntity;

public interface UserRepository extends CassandraRepository<UserEntity, Integer>{

}
