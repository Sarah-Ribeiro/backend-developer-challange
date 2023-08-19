create table crud_click_bus (
	id bigint not null auto_increment, 
	name varchar(100) not null, 
	slug varchar(100) not null, 
	city varchar(100) not null, 
	state varchar(100) not null, 
	updatedAt date, 
	createdAt date,
	
	primary key(id)
);