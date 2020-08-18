package com.springboot.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
