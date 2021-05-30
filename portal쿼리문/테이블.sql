CREATE TABLE `student` (
	`st_num`	varchar(10)	NOT NULL,
	`st_id`	varchar(15)	NULL,
	`st_res_num`	varchar(14)	NULL,
	`st_pw`	varchar(225)	NULL,
	`st_dp`	varchar(20)	NULL,
	`st_name`	varchar(30)	NULL
);

CREATE TABLE `class` (
	`cl_code`	varchar(10)	NOT NULL,
	`cl_title`	varchar(30)	NULL,
	`cl_max_count`	int	NULL,
	`cl_point`	int	NULL,
	`cl_schedule`	varchar(40)	NULL,
	`cl_pr_num`	varchar(11)	NOT NULL
);

CREATE TABLE `professor` (
	`pr_num`	varchar(11)	NOT NULL,
	`pr_id`	varchar(15)	NULL,
	`pr_pw`	varchar(225)	NULL,
	`pr_name`	varchar(30)	NULL,
	`pr_dep`	varchar(20)	NULL,
	`pr_res_num`	varchar(14)	NULL
);

CREATE TABLE `course` (
	`co_num`	int	NOT NULL,
	`co_st_num`	varchar(10)	NOT NULL,
	`co_cl_code`	varchar(10)	NOT NULL
);

ALTER TABLE `student` ADD CONSTRAINT `PK_STUDENT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `class` ADD CONSTRAINT `PK_CLASS` PRIMARY KEY (
	`cl_code`
);

ALTER TABLE `professor` ADD CONSTRAINT `PK_PROFESSOR` PRIMARY KEY (
	`pr_num`
);

ALTER TABLE `course` ADD CONSTRAINT `PK_COURSE` PRIMARY KEY (
	`co_num`
);