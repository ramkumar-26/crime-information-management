# Crime Information Management (Console Based)
* Domain Description: 
To live in a peaceful society, we need low crime rates and to reduce the crime rates we need police officers. 
As a police officer, they need to manage all the crimes and criminals in a effective. To help those officers
we need a "Crime Inforamtion Mangement" software. This is were our software kicks in and provide all the 
neccessary functions to manage and maintain crimes as well criminals data.

* Type of User: Police Officer

* Role of Police officer: -Login -Register -RegisterCrime -RegisterCriminal -LinkCriminal -UpdateStatus 
-ViewCrime -ViewCriminal -GenerateReport 

* Tables:
Crime_Records:
- Crime_ID, - CrimeDate, - ShortDesc, - DetailedDesc, - AreaOfCrime, - PoliceStationCode, - Victim_Name,
- Victim_Age, - Victim_Address, - Victim_Gender, - Victim_MobileNumber

Crimina_Records:
- Criminal_id, - Criminal_Name, - Age, - Gender, - Mark_In_Face, - First_Arrest_Place

Police_Records:
- Police_id, - Name, - Reporting_PoliceStation, - Password, - Access_Status

Investigation_Details:
- Investigation_ID, - Crime_ID, - Criminal_ID, - Status, - Investigation_Status
