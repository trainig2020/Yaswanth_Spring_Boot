package com.springboot.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.Topic;
import com.springboot.app.repo.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic(1, "java", "java description"),
			new Topic(2, "spring", "spring description"), new Topic(3, "javascript", "javascript description")));

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(int id) {
		Optional<Topic> topic =topicRepository.findById(id);
		return topic;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(int id, Topic topic) {		
		topicRepository.save(topic);
		
	}

	public void deleteTopic(int id) {
		topicRepository.deleteById(id);
	}
}
