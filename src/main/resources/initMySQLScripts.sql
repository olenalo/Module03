# drop database spreadsheets;

create database spreadsheets;

create table spreadsheets.dataTables (
    table_id int(11) not null auto_increment,
    title varchar(20) not null,
    primary key (table_id)
);


create table spreadsheets.sheets (
    sheet_id int(11) not null auto_increment,
    title varchar(20) not null,
	table_id int(11),
    primary key (sheet_id),
    foreign key (table_id) references spreadsheets.dataTables(table_id)  # TODO One to One
);


create table spreadsheets.spreadsheet (
    spreadsheet_id int(11) not null auto_increment,
    title varchar(20) not null,
	sheet_id int(11),
    primary key (spreadsheet_id),
	foreign key (sheet_id) references spreadsheets.sheets(sheet_id)
);