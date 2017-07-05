package com.tinroof.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="events")
public class Event implements Serializable {
	
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String attendees;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	private String location;

	@Column(name="reminder_sent")
	private byte reminderSent;

	//@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="reminder_time")
	private Date reminderTime;

	private String title;

	//bi-directional many-to-one association to Calendar
	@ManyToOne
	private Calendar calendar;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttendees() {
		return this.attendees;
	}

	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte getReminderSent() {
		return this.reminderSent;
	}

	public void setReminderSent(byte reminderSent) {
		this.reminderSent = reminderSent;
	}

	public Date getReminderTime() {
		return this.reminderTime;
	}

	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getCalendar() {
		return this.calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	// Must have
	public Event() {
    }
	
	public Event(int id, String attendees, Date date, String location, byte reminderSent,
            Date reminderTime, String title, Calendar calendar) {
        super();
        this.id = id;
        this.attendees = attendees;
        this.date = date;
        this.location = location;
        this.reminderSent = reminderSent;
        this.reminderTime = reminderTime;
        this.title = title;
        this.calendar = calendar;
    }
	
}