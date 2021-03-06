package com.example.wbdvsp20bnohserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;
  private String type = "HEADING";
  private int size = 2;
  @ManyToOne
  private Topic topic;

  public Topic getTopic(){
    return topic;
  }

  public void setTopic(Topic topic){
    this.topic = topic;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }



  public Widget(){

  }

  public Widget(Integer id, String title, String type) {
    this.id = id;
    this.title = title;
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
