create table issue_job (
  id int unsigned auto_increment not null,
  issueKey varchar(32) not null,
  processInstanceId varchar(32) not null,
  date_created timestamp default now(),
  signal_ref varchar(32) not null,
  status varchar(32) not null,
  primary key (id)
);