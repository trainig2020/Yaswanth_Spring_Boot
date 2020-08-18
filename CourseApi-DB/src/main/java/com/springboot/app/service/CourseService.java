package com.springboot.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.Course;
import com.springboot.app.repo.CourseRepository;

@Service
public class CourseService {
   
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(int topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Optional<Course> getCourse(int id) {
		Optional<Course> course =courseRepository.findById(id);
		return course;
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(int id, Course course) {		
		courseRepository.save(course);
		
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}
}
