
create table em_event_type(
	id BIGSERIAL PRIMARY KEY NOT NULL,
	name varchar(255),
	description TEXT,
	created_by varchar(255),
	created_on timestamp,
	updated_by varchar(255),
	updated_on timestamp,
	event_img bytea
);

insert into em_event_type values(1, 'Hackathon', 'A Developer Challenge', 'Venkatesh Kumar', '2016-06-07 10:10:06', 'Venkatesh Kumar V', '2016-06-07 10:15:06', '');

insert into em_event_type values(2, 'Annual Meet', 'Company Celebration', 'Venkatesh Kumar', '2016-06-07 10:10:06', 'Venkatesh Kumar V', '2016-06-07 10:15:06', '');

insert into em_event_type values(3, 'Product Launch', 'Product Release', 'Venkatesh Kumar', '2016-06-07 10:10:06', 'Venkatesh Kumar V', '2016-06-07 10:15:06', '');

insert into em_event_type values(4, 'Meetup', 'Discussion Board', 'Venkatesh Kumar', '2016-06-07 10:10:06', 'Venkatesh Kumar V', '2016-06-07 10:15:06', '');