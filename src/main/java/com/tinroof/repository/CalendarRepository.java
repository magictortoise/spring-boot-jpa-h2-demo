package com.tinroof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tinroof.model.Calendar;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {
    @Transactional
    Long deleteById(int id);
}