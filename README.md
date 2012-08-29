This Grails Web Application wraps the DeIdent software from the de-idata.com Corporation
======

- This software will be used to de-identify text fields within the CRDW project. 

Requirements
======

- Needs to run on a windows machine as it uses JNI to talk to a C++ library
- Project built with Netbeans IDE
- Assumes the de-idata software has already been installed and configured. Install
  it to the C:\Program Files\DeID directory for the rest of this configuration 
  to work. 
- Uses grails 1.3.7 

Installation
============

Install the de-idata.com software using the default location on your windows machine. 

Install the following on the PC : 
- Oracle Java JDK 1.6 or higher 
- Groovy
- Grails 1.3.7
- Netbeans IDE 7.2 ( optional ) 

Download the source from github

git clone https://github.com/gkowalski/hipaaDeId.git

Follow the Next section on Configuration to modify / add 2 *System* Environment 
variables. 

Finally one can run the app with: 
- grails run-app to run with internal server on port 8080

Or to run in a web application server like tomcat or glassfish
- grails prod war
- copy the ~project/prod.war to the deploy directory or your web application.

    
Configuration needed to the PC running the de-ident software 
==============================================================


Prepend the System PATH as : 

 PATH= C:\Progra~1\DeID;%PATH%

Make sure it goes first ! 

Set the Java CLASSPATH System Variable to : 

 CLASSPATH=C:\Progra~1;.;


Testing
=======

To test this application one can run the following command form a UNIX shell: 

$ curl -F "message=George Kowalski" http://server:8080/DeIdentApp/decode/decodeAsJSON/

Should Return: 

{"class":"mcw.edu.crdw.domain.Decode","id":null,"message":"**NAME[ZZZ YYY]\n\n"} 



History
======

- 8/27/2012 - Received / Installed 6.24.00 version of software
- 8/28/2012 - Testing showed that reading from Staging, deidentifying , and writing
    to DEIDENT database was going to be too slow. Thus this web application was 
    created to provide JSON / XML services to do this . No Security for this app 
    as this no data is stored or logged by this application. 
