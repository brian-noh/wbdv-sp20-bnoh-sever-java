package com.example.wbdvsp20bnohserverjava.controllers;

import com.example.wbdvsp20bnohserverjava.models.Topic;
import com.example.wbdvsp20bnohserverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {
  @Autowired
  TopicService topicService;

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics(){
    return topicService.findAllTopics();
  }
}
