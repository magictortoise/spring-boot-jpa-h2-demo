INSERT INTO calendar (id,name,userid) VALUES (1,'calendar1','admin');
INSERT INTO calendar (id,name,userid) VALUES (2,'calendar2','admin2');
INSERT INTO calendar (id,name,userid) VALUES (3,'calendar3','admin3');

INSERT INTO events (id,attendees,date,location,reminder_sent,reminder_time, title,calendar_id) VALUES (1,'tom,peter','2015-12-31 23:59:59','Atlanta',1,'2015-12-30 23:59:59','Spring party',1);
INSERT INTO events (id,attendees,date,location,reminder_sent,reminder_time, title,calendar_id) VALUES (2,'david','2017-07-05 23:59:59','New York',0,'2017-07-04 23:59:59','Spring party2',2);
INSERT INTO events (id,attendees,date,location,reminder_sent,reminder_time, title,calendar_id) VALUES (3,'luna','2017-07-05 23:59:59','Seattle',0,'2017-07-04 23:59:59','Spring party3',2);