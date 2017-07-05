package com.tinroof.controller;

import java.io.IOException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinroof.model.Calendar;
import com.tinroof.model.Event;
import com.tinroof.repository.CalendarRepository;
import com.tinroof.repository.EventRepository;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventRepository evtRepository;
	
	@RequestMapping(path="/findall", method = RequestMethod.GET)
	public Iterable<Event> findAllEvent() throws IOException {
		return evtRepository.findAll();
	}
	
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public ResponseEntity<String> persistEvent(@RequestBody @Valid Event event) {
	    evtRepository.save(event);
	    return new ResponseEntity<String>("Successful.", new HttpHeaders(), HttpStatus.CREATED);

    }
	
	@RequestMapping(value = "/delete/{eventId}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteEvent(@PathVariable int eventId) {
        evtRepository.deleteById(eventId);
        return new ResponseEntity<String>("Event is deleted.", new HttpHeaders(), HttpStatus.OK);

    }
	
	/**
	 * Find Event within a time period. It allow a user to retrieve the list of events for a day, a week, or a month.
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	@RequestMapping(value = "/findByDate", method = RequestMethod.POST)
    public Iterable<Event> findEventByDatePeriod(@RequestParam(value="fromDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fromDate,
            @RequestParam(value="toDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toDate) {
	    
        return evtRepository.findByDatePeriod(fromDate, toDate);
    }
	
}
