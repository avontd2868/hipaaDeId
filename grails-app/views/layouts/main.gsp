<!DOCTYPE html>
<html>
  <head>
    <title><g:layoutTitle default="HIPAA De-Identification Service" /></title>
    <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
    <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <g:layoutHead />
  <g:javascript library="application" />
</head>
<body>
  <div id="spinner" class="spinner" style="display:none;">
    <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
  </div>
  <table width="200" >
    <tr>
      <td><a href="/"><img class="logoImage" src="${resource(dir:'images',file:'Combination_discs.png')}" alt="HIPAA De-Identification Service" border="0" width="100"/></a></td>
      <td valign="center"><div class="large">HIPAA De-Identification Service</div></td>
    </tr>
  </table>
<g:layoutBody />
</body>
</html>