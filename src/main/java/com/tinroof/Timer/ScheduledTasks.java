package com.tinroof.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tinroof.model.Event;
import com.tinroof.repository.EventRepository;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private EventRepository evtRepository;
    
    /**
     * Run Task everyday at 8AM to check if we have reminder to send.
     */
    @Scheduled(cron="0 0 8 ? * *")
    //@Scheduled(fixedRate=5000)
    public void sendReminder() {
        List<Event> events = evtRepository.findReminder();
        for (Event e : events) {
            log.info("Send reminder for Event:" + e.getTitle());
            
            e.setReminderSent((byte) 1);
            evtRepository.save(e);
            log.info("Event " + e.getTitle() +" Reminder is sent. Database reminder flag is updated");
        }       
    }
}