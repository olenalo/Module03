# drop database spreadsheets;
# drop database myspreadsheet;


# Normally this should correspond to a particular spreadsheet's file name / id or so
# This exact part is implemented within the module.\
create database myspreadsheet;

create table myspreadsheet.sheets (
    sheet_id int(11) not null auto_increment,
    title varchar(20) not null,
    rows_number int(11) not null,
    columns_number int(11) not null,
    primary key (sheet_id)
);

create table myspreadsheet.cells (
    cell_id int(11) not null auto_increment,  
    row_index int(11) not null,
    column_index int(11) not null,
    cell_value varchar(20),
    sheet_id int(11),
    primary key (cell_id),
    foreign key (sheet_id) references myspreadsheet.sheets(sheet_id)
);

select * from myspreadsheet.sheets;
select * from myspreadsheet.sheets where sheet_id=1;

select * from myspreadsheet.cells;
select * from myspreadsheet.cells where cell_id=1;

select * from myspreadsheet.cells where sheet_id=1;
select * from myspreadsheet.cells where sheet_id=2;

select * from myspreadsheet.cells where sheet_id=1 and cell_id=1;
select * from myspreadsheet.cells where sheet_id=1 and row_index=0 and column_index=0;




# This part is not implemented within the module
# (API: add/remove new spreadsheet...)

/**
create database spreadsheets;

create table spreadsheets.owners (
    owner_id int(11) not null auto_increment,  
    first_name varchar(20) not null,
    second_name varchar(20) not null,
    primary key (owner_id)
);

create table spreadsheets.spreadsheets (
    spreadsheet_id int(11) not null auto_increment,  
    title varchar(20) not null,
    owner_id int(11) not null,
    primary key (spreadsheet_id),
    foreign key (owner_id) references spreadsheets.owners(owner_id)
);
*/
