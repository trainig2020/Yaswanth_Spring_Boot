package com.springboot.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Course;
import com.springboot.app.model.Topic;
import com.springboot.app.service.CourseService;

@RestController
public class CousreController {
    
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable int id) {
		return courseService.getAllCourses(id);		
	}
	
	@RequestMapping("/topic/{topicId}/course/{id}")
	public Optional<Course> getCourse(@PathVariable int id) {
		return courseService.getCourse(id);
	}
	@RequestMapping(method = RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable int topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable int topicId,@PathVariable int id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(id, course);;
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/topics/{topicsId}/courses/{id}")
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
	}
} 
