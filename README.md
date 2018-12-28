## Intro

This is an app reproducing basic spreadsheet functionality.

Initial MySQL scripts for creating database and tables can be found in the `resources/` dir ([here](https://github.com/olenalo/Module03/blob/master/src/main/resources/initMySQLScripts.sql)).

## Design

* A spreadsheet contains sheet(s), with each sheet having cell(s).
* There should be two parts in the app: 

(1) owner level - spreadsheets are stored per owner; this data is stored in a separate database (e.g. `spreadsheets`). 

(2) spreadsheet level - data entries are stored per sheet, with each spreadsheet being represented as a separate database 
(here - `myspreadsheet`) or document. 
*Only the second part is implemented within this module as per initial requirements (add/remove table/row/column).*

* A user can not add data to a non-existing cell, need to first add row(s) and column(s) to a entry.