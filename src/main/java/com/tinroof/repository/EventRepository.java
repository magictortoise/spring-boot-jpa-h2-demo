package com.tinroof.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tinroof.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    
    @Transactional
    Long deleteById(int id);
    
    @Query("SELECT e FROM Event e WHERE e.date > :fromDate AND e.date < :toDate")
    public List<Event> findByDatePeriod(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
    
    // http://www.h2database.com/html/functions.html#current_date
    // H2 function is different from other databases
    @Query("SELECT e FROM Event e WHERE FORMATDATETIME(e.reminderTime,'yyyy-MM-dd') = CURRENT_DATE() AND e.reminderSent = 0")
    public List<Event> findReminder();
}