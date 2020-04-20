package com.example.wbdvsp20bnohserverjava.controllers;

import com.example.wbdvsp20bnohserverjava.models.Topic;
import com.example.wbdvsp20bnohserverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class TopicController {
  @Autowired
  TopicService topicService;

  @PostMapping("/api/lessons/{lid}/topics")
  public Topic createTopicForLesson(
          @PathVariable("lid") String lessonId,
          @RequestBody Topic newTopic
  ) {
    newTopic.setLessonId(lessonId);
    return topicService.createTopic(newTopic);
  }

  @GetMapping("/api/lessons/{lessonId}/topics")
  public List<Topic> findTopicsForLesson(
          @PathVariable("lessonId") String lessonId
  ) {
    return topicService.findTopicsForLesson(lessonId);
  }

  @PutMapping("/api/topics/{topicId}")
  public int updateWidget(
          @PathVariable("topicId") Integer tid, @RequestBody Topic updatedTopic) {
    return topicService.updateTopic(tid, updatedTopic);
  }

  @DeleteMapping("/api/topics/{topicId}")
  public int deleteTopic(
          @PathVariable("topicId") Integer tid) {
    return topicService.deleteTopic(tid);
  }

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return topicService.findAllTopics();
  }

  @GetMapping("/api/topics/{topicId}")
  public Topic findTopicById(
          @PathVariable("topicId") Integer tid) {
    return topicService.findTopicById(tid);
  }

}