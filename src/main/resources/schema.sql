DROP TABLE IF EXISTS pathtrace_db.trace_coordinate;

create table pathtrace_db.trace_coordinate(
	id int NOT NULL,
	x_coordinate int NOT NULL,
	y_coordinate int NOT NULL,
	 PRIMARY KEY (id)
);
