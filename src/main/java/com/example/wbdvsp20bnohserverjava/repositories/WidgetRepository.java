package com.example.wbdvsp20bnohserverjava.repositories;

import com.example.wbdvsp20bnohserverjava.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {
  // SELECT * FROM cs4550.widgets WHERE topic_id='222'
  @Query(nativeQuery = true, value = "SELECT * FROM widget WHERE topic_id =:tid")
  public List<Widget> findWidgetsForTopic(
          @Param("tid") String topicId);

}
