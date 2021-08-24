# ClearingFeedGeneration_Group9
#### Structure

_Database : clearing_feedfile;_  
_Table 1 : current_valid -> Table to store Current Transactions of file with successful validations_     
_Table 2 : current_invalid -> Table to store Current Transactions of file with failed validations_      
_Table 3 : archive -> Table to store all valid and invalid archived transactions_


#### MySQL Commands 

create database clearing_feedfile;    
use clearing_feedfile;   

create table current_valid(transaction_ref BIGINT, value_date date, payername varchar(35), payer_accno varchar(12), payeename varchar(35), payee_accno varchar(12), amount dec(10,2),Primary Key(transaction_ref));    

create table current_invalid(id int AUTO_INCREMENT,transaction_ref varchar(50), value_date varchar(50), payername varchar(50), payer_accno varchar(50), payeename varchar(50), payee_accno varchar(50), amount varchar(50),Primary Key(id));    

create table archive(id int AUTO_INCREMENT,transaction_ref varchar(50), value_date varchar(50), payername varchar(50), payer_accno varchar(50), payeename varchar(50), payee_accno varchar(50), amount varchar(50), valid_check int,file_no int,Primary Key(id));    

##To run:
1. Initialise the mysql database as mentioned above.

2. Open the frontEnd in Visual Studio Code with angular CLI and node.js installed.

3. In VSCode terminal, in the root folder, for initial run only, run 
  > npm install
  
4. In Backend, in application.properties file, add password and user for your mysql server

5. To start the application:
   
   5.1 Launch the mysql server
   
   5.2 Run the ClearingFeedGenerationApplication.java as application in Springboot
   
   5.3 Run the command 
   
   >ng serve in 
   
   terminal in VSCode
   
   5.4 Launch http://localhost:4200
