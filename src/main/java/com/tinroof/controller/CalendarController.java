package com.tinroof.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tinroof.model.Calendar;
import com.tinroof.model.Event;
import com.tinroof.repository.CalendarRepository;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	private CalendarRepository calRepository;
	
	@RequestMapping(path="/findall", method = RequestMethod.GET)
	public Iterable<Calendar> findAllCalendar() throws IOException {
		return calRepository.findAll();
	}
	
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public ResponseEntity < String > persistCalendar(@RequestBody @Valid Calendar calendar) {
	    calRepository.save(calendar);
        return new ResponseEntity<String>("Successful.", new HttpHeaders(), HttpStatus.CREATED);

    }
    
    @RequestMapping(value = "/delete/{calId}", method = RequestMethod.POST)
    public ResponseEntity < String > deleteCalendar(@PathVariable int calId) {
        calRepository.deleteById(calId);
        return new ResponseEntity<String>("Event is deleted.", new HttpHeaders(), HttpStatus.OK);

    }
}
