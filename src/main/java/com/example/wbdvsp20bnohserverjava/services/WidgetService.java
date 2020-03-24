package com.example.wbdvsp20bnohserverjava.services;

import com.example.wbdvsp20bnohserverjava.models.Widget;
import com.example.wbdvsp20bnohserverjava.repositories.WidgetRepository;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
  List<Widget> widgetList = new ArrayList<Widget>();
  @Autowired
  WidgetRepository widgetRepository;



  public Widget createWidget(Widget newWidget){
    widgetList.add(newWidget);
    return newWidget;
  }


  public List<Widget> findAllWidgets(){
    return (List<Widget>)widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer wid){
    for(Widget w: widgetList){
      if(w.getId().equals(wid)){
        return w;
      }
    }
    return null;
  }


  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> results = new ArrayList<Widget>();
    for(Widget w:widgetList){
      if(w.getTopicId().equals(topicId)){
        results.add(w);

      }
    }
    return results;

  }

  public int deleteWidget(Integer wid) {
    widgetList = widgetList.stream()
            .filter(w-> !w.getId().equals(wid)).collect(Collectors.toList());

    return 1;
  }

  public int updateWidget(Integer wid, Widget updatedWidget){
    for(int i = 0; i < widgetList.size(); i++){
      if(widgetList.get(i).getId().equals(wid)){
        widgetList.set(i, updatedWidget);
        return 1;
      }
    }
    return 0;
  }
}
