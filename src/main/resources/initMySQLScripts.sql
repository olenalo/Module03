# drop database spreadsheets;
# drop database myspreadsheet;


# Normally this should correspond to a particular spreadsheet's file name / id or so
# This exact part is implemented within Module03 A-Level
create database myspreadsheet;


create table myspreadsheet.sheets (
    sheet_id int(11) not null,  # not `auto_increment`, since we pass id from Java
    title varchar(20) not null,
    rows_number int(11) not null,
    columns_number int(11) not null,
    spreadsheet_id int(11),
    primary key (sheet_id),
    foreign key (spreadsheet_id) references spreadsheets.spreadsheets(spreadsheet_id)
);

create table myspreadsheet.entries (
    entry_id int(11) not null auto_increment,  
    row_index int(11) not null,
    column_index int(11) not null,
    cell_value varchar(20),
    sheet_id int(11),
    primary key (entry_id),
    foreign key (sheet_id) references spreadsheets.sheets(sheet_id)
);



# This part is not implemented within Module03 A-Level
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
