
/*CrimeTable*/
CREATE TABLE Crime_Records
(
Crime_ID INTEGER PRIMARY KEY,
CrimeDate DATE,
ShortDesc VARCHAR(20),
DetailedDesc VARCHAR(200),
AreaOfCrime VARCHAR(20),
PoliceStation_Code VARCHAR(30),
Victim_Name VARCHAR(20),
Victim_Address VARCHAR(30),
Victim_Age int,
Victim_Gender VARCHAR(10),
Victim_Mobilenumber VARCHAR(10)
);


/*CriminalRecords*/
CREATE TABLE Criminal_Records
(
Criminal_ID INTEGER PRIMARY KEY,
Criminal_Name VARCHAR(20),
Age INTEGER,
Gender VARCHAR(10),
Mark_In_Face VARCHAR(20),
First_Arrest_Place VARCHAR(20)
);

/*Investigation_Details*/
CREATE TABLE Investigation_Details
(
Investigation_ID INTEGER PRIMARY KEY,
Crime_ID INTEGER,
Criminal_ID INTEGER,
status VARCHAR(10),
Investigation_Officer_ID INTEGER,
FOREIGN KEY(Crime_ID) REFERENCES Crime_Records(Crime_ID),
FOREIGN KEY(Criminal_ID) REFERENCES Criminal_Records(Criminal_ID)
);

/*PoliceTable*/
CREATE TABLE Police_Records
(
Police_ID INTEGER PRIMARY KEY,
Name VARCHAR(20),
Reporting_PoliceStation VARCHAR(30),
Password VARCHAR(20),
Acces_Status VARCHAR(10)
);

/*RequestTable*/
CREATE TABLE Request_List
(
Request_ID INTEGER PRIMARY KEY,
Police_ID INTEGER,
Access_Status VARCHAR(10),
FOREIGN KEY(Police_ID) REFERENCES Police_Records(Police_ID)
);
