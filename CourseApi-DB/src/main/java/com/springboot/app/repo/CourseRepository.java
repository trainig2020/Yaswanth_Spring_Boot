package com.springboot.app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>  {
   
	public List<Course> findByTopicId(int topicId);
}
