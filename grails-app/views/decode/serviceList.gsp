

<%@ page import="mcw.edu.crdw.domain.Decode" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  <g:set var="entityName" value="${message(code: 'decode.label', default: 'Decode')}" />
  <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
    <span class="menuButton"><g:link class="list" action="serviceList">Web Services</g:link></span>

  </div>
  <div class="body">
    <h1>Web Service Support</h1>
    <p>
      This Application not only has a page for testing the deidentification process 
      but also a set of REST based web services for requesting decoding of data in 
      and automated way.
    </p>
    <br>&nbsp;<br>
    <h3>JSON Web service</h3>
    The first web service returns JSON of the string being passed in using GET: 
    <br>&nbsp;<br>
    <a href="/DeIdentApp/decodeJSON/Dr%20Smith">/DeIdentApp/decode/decodeAsJSON/Dr Smith</a><br>
    <br>
    One can call this same url /DeIdentApp/decodeJSON/ and POST more data that a 
    GET supports . In this case specify the parameter "message" with the data to be decoded. 
        <br>&nbsp;<br>
    <h3>XML Web service</h3>
    The first web service returns JSON of the string being passed in using GET: 
    <br>&nbsp;<br>
    <a href="/DeIdentApp/decodeXML/Dr%20Smith">/DeIdentApp/decode/decodeAsXML/Dr Smith</a><br>
    <br>
    One can call this same url /DeIdentApp/decodeXML/ and POST more data that a 
    GET supports . In this case specify the parameter "message" with the data to be decoded. 
      <br>&nbsp;<br>
      <h3>Testing</h3>
      Testing can be done via the UNIX command line with curl: <br><br>
      <pre>
      $ curl -F "message=George Kowalski" http://server/DeIdentApp/decode/decodeAsJSON/
      Results in : 
        {"class":"mcw.edu.crdw.domain.Decode","id":null,"message":"**NAME[ZZZ YYY]\n\n"} 
  </pre>
     <h3>Security</h3>
    This application performs no security checking as it never stores or logs any HIPAA data. 
    All de-identification is performed in memory via a Secure (HTTPS) connection.<br>
    The only logging may be in the apache log if you use that to front end this Grails app. 
    In that case you should not use GET , but instead POST only for de-identification requests. 
    
  </div>
</body>
</html>
