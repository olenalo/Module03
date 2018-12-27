# drop database spreadsheets;

create database spreadsheets;

create table spreadsheets.sheets (
    sheet_id int(11) not null,  # not `auto_increment`, since we pass id from Java
    title varchar(20) not null,
    primary key (sheet_id)
);

create table spreadsheets.entries (
    entry_id int(11) not null auto_increment,  
    row_index int(11) not null,
    column_index int(11) not null,
    cell_value varchar(20),
    sheet_id int(11),
    primary key (entry_id),
    foreign key (sheet_id) references spreadsheets.sheets(sheet_id)
);

create table spreadsheets.spreadsheets (
    spreadsheet_id int(11) not null auto_increment,  
    title varchar(20) not null,
	sheet_id int(11),
    primary key (spreadsheet_id),
	foreign key (sheet_id) references spreadsheets.sheets(sheet_id)
);