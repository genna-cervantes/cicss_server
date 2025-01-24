CREATE TABLE backend.courses (
	course_code VARCHAR(10) NOT NULL,
	course_name VARCHAR(80) NOT NULL,
	units_per_class INTEGER NOT NULL,
	course_type VARCHAR(20) NOT NULL,
	course_category VARCHAR(25) NOT NULL,
	restrictions JSONB,
	total_units INTEGER NOT NULL
);

CREATE TABLE backend.course_offerings (
	course_offerings_id VARCHAR(10) PRIMARY KEY NOT NULL,
	department VARCHAR(50) NOT NULL,
	year_level INTEGER NOT NULL,
	semester INTEGER NOT NULL,
	specialization VARCHAR(30) NOT NULL,
	courses VARCHAR[] NOT NULL
);

CREATE TABLE backend.department_chair (
	department_chair_id VARCHAR(10) PRIMARY KEY NOT NULL,
	department VARCHAR(30) NOT NULL,
	department_chair_name VARCHAR(100) NOT NULL,
	department_chair_email VARCHAR(80) NOT NULL
);

CREATE TABLE backend.gened_constraints (
	gened_constraint_id VARCHAR(10) PRIMARY KEY NOT NULL,
	course_title VARCHAR(80) NOT NULL,
	course_code VARCHAR(10) NOT NULL,
	day_and_time_restriction JSONB NOT NULL
);

CREATE TABLE backend.section_count (
	section_count_id VARCHAR(10) PRIMARY KEY NOT NULL,
	department VARCHAR(2) NOT NULL,
	first_year_section_count INTEGER NOT NULL,
	second_year_section_count INTEGER NOT NULL,
	third_year_section_count INTEGER NOT NULL,
	fourth_year_section_count INTEGER NOT NULL
);

CREATE TABLE backend.tas_constraints (
	tas_constraint_id VARCHAR(10) PRIMARY KEY NOT NULL,
	tas_name VARCHAR(100) NOT NULL,
	tas_status VARCHAR(25) NOT NULL,
	specialty_courses VARCHAR[] NOT NULL,
	day_and_time_restrictions JSONB NOT NULL
);

CREATE TABLE backend.year_level_day_constraints (
	year_level_day_constraint_id VARCHAR(10) PRIMARY KEY NOT NULL,
	department VARCHAR(2) NOT NULL,
	first_year_allowed_days VARCHAR[] NOT NULL,
	first_year_max_days_of_recurrence INTEGER NOT NULL,
	second_year_allowed_days VARCHAR[] NOT NULL,
	second_year_max_days_of_recurrence INTEGER NOT NULL,
	third_year_allowed_days VARCHAR[] NOT NULL,
	third_year_max_days_of_recurrence INTEGER NOT NULL,
	fourth_year_allowed_days VARCHAR[] NOT NULL,
	fourth_year_max_days_of_recurrence INTEGER NOT NULL
);

CREATE TABLE backend.year_level_time_constraints (
	year_level_time_constraint_id VARCHAR(10) PRIMARY KEY NOT NULL,
	department VARCHAR(2) NOT NULL,
	first_year_time_constraint JSONB NOT NULL,
	second_year_time_constraint JSONB NOT NULL,
	third_year_time_constraint JSONB NOT NULL,
	fourth_year_time_constraint JSONB NOT NULL
)
