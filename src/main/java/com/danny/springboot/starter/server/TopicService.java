package com.danny.springboot.starter.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.danny.springboot.starter.model.Topic;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring framework description"),
			new Topic("Java", "Core Java", "Core Java description"),
			new Topic("Javacsript", "Java script Framework", "Java Script description")
		));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void removeTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
	public void removeAllTopic() {
		topics.clear();
	}
	
}
