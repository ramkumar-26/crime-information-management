
/*CrimeTable*/
CREATE TABLE CrimeRecords
(
Crime_ID INTEGER PRIMARY KEY,
CrimeDate DATE,
ShortDesc VARCHAR(20),
DetailedDesc VARCHAR(200),
AreaOfCrime VARCHAR(20),
PoliceStation_Code VARCHAR(30),
Victim_ID INTEGER,
FOREIGN KEY(Victim_ID) REFERENCES VictimRecords(Victim_ID)
);

/*VictimTable*/
CREATE TABLE VictimRecords
(
Victim_ID INTEGER PRIMARY KEY,
Victim_Name VARCHAR(20),
Address VARCHAR(40),
Contact_Number INTEGER,
Gender VARCHAR(20),
Age INTEGER
);

/*CriminalRecords*/
CREATE TABLE CriminalRecords
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
Investigation_Officer_ID INTEGER,
FOREIGN KEY(Crime_ID) REFERENCES CrimeRecords(Crime_ID),
FOREIGN KEY(Criminal_ID) REFERENCES CriminalRecords(Criminal_ID)
);

/*PoliceTable*/
CREATE TABLE PoliceRecords
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
FOREIGN KEY(Police_ID) REFERENCES PoliceRecords(Police_ID)
);
