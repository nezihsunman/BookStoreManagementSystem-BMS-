# BookStoreManagementSystemBMS

For the local setup first of all you have to folllow instrauctre below 

1. Install Notepad ++ 7.8.1 Release according to your x86 or x64 bit 
https://notepad-plus-plus.org/downloads/v7.8.1/
2. Install Oracle 19c Db setting 
https://www.oracle.com/database/technologies/oracle-database-software-downloads.html
3. Maven Install
https://howtodoinjava.com/maven/how-to-install-maven-on-windows/. 
Use: Local Host https://localhost:5500/em

4. Sql Developer 19.2.1 Download
https://www.oracle.com/tools/downloads/sqldev-v192-downloads.html
For Any NonVisualise correctly case Plase follow this link
http://www.muratoner.net/oracle/oracle-sql-developer-nesnelerin-gozukmeme-problemi

5. Please install https://nodejs.org/en/ version: lastest possible

Our Spesific Files
SYS as SYSDBA
select name from v$database;

unzip folder is oracledb cd.. inside app folder 
username=orcl
password= oracle

oralce base= C:\app
database file location = C:\app\oradata
---------
SID=orcl
Pasword = bmStore1234
plugable database = orclpdb
CONNECT sqlplus 
SYS as SYSBA

For enable scpritng 
alter session set "_ORACLE_SCRIPT"=true;
For change user pasword
ALTER USER SYSTEM IDENTIFIED BY SYSTEM;
FİNİSHED oracle DB setup;


AFTER FINISHED

Vue Cli install Globally

npm install -g @vue/cli-service-global

for installing the project to local 
    go to the  root of project 
    
    cd frontend
    
    npm install
    
    npm run serve
    
    
After run backend spring application for backend service
    
    

