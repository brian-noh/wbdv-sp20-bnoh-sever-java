package com.example.wbdvsp20bnohserverjava.controllers;

import com.example.wbdvsp20bnohserverjava.models.Widget;
import com.example.wbdvsp20bnohserverjava.services.WidgetService;

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
@CrossOrigin(origins = {"*"})
public class WidgetController {

  @Autowired
  WidgetService service;



//
//  @PostMapping("/widgets")
//  public Widget createWidget(
//          @RequestBody Widget newWidget){
//
//    return service.createWidget(newWidget);
//  }


  @GetMapping("/widgets")
  public List<Widget> findAllWidgets(){
    return service.findAllWidgets();
  }

  @DeleteMapping("/widgets/{widgetId}")
  public int deleteWidget(
          @PathVariable("widgetId") Integer wid){

    return service.deleteWidget(wid);
  }
  @GetMapping("/widgets/{widgetId}")
  public Widget findWidgetById(
          @PathVariable("widgetId") Integer wid){

    return service.findWidgetById(wid);
  }

  @PutMapping("/widgets/{widgetId}")
  public int updateWidget(
          @PathVariable("widgetId") Integer wid, @RequestBody Widget updatedWidget){

    return service.updateWidget(wid, updatedWidget);
  }
  @GetMapping("topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(
          @PathVariable("tid") String topicId){
            return service.findWidgetsForTopic(topicId);
    }



}
