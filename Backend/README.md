_Structure_      
Database : clearing_feedfile;
Table 1 : current_valid -> Table to store Current Transactions of file with successful validations     
Table 2 : current_invalid -> Table to store Current Transactions of file with failed validations     
Table 3 : archive -> Table to store all valid and invalid archived transactions    

_MySQL Commands_     
create database clearing_feedfile;    
use clearing_feedfile;    

create table current_valid(transaction_ref BIGINT, value_date date, payername varchar(35), payer_accno varchar(12), payeename varchar(35), payee_accno varchar(12), amount dec(10,2),Primary Key(transaction_ref));     

create table current_invalid(id int AUTO_INCREMENT,transaction_ref varchar(50), value_date varchar(50), payername varchar(50), payer_accno varchar(50), payeename varchar(50), payee_accno varchar(50), amount varchar(50),Primary Key(id));     

create table archive(id int AUTO_INCREMENT,transaction_ref varchar(50), value_date varchar(50), payername varchar(50), payer_accno varchar(50), payeename varchar(50), payee_accno varchar(50), amount varchar(50), valid_check int,file_no int,Primary Key(id));     
