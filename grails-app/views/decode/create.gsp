

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
    <h1>De-Identify a message</h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${decodeInstance}">
      <div class="errors">
        <g:renderErrors bean="${decodeInstance}" as="list" />
      </div>
    </g:hasErrors>
    <g:form action="save" >
      <div class="dialog">
        <table>
          <tbody>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="message"><g:message code="decode.message.label" default="Message" /></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: decodeInstance, field: 'message', 'errors')}">
          <g:textArea name="message" value="${decodeInstance?.message}" />
          </td>
          </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <span class="button"><g:submitButton name="DeIdentify" class="save" value="DeIdentify" /></span>
      </div>
    </g:form>
  </div>
</body>
</html>
