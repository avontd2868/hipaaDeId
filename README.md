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

Configuration to run from the command line and within the IDE:
======


Prepend the System PATH as : 

 PATH= C:\Progra~1\DeID;%PATH%

Make sure it goes first ! 

Set the Java CLASSPATH System Variable to : 

 CLASSPATH=C:\Progra~1;.;


Servers in this process 
======


History
======

- 8/27/2012 - Received / Installed 6.24.00 version of software from Brad
- 8/28/2012 - Testing showed that reading from Staging, deidentifying , and writing
    to DEIDENT database was going to be too slow. Thus this web application was 
    created to provide JSON / XML services to do this . No Security for this app 
    as this no data is stored or logged by this application. 
