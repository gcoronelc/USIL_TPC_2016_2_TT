
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <title>.:: PROMEDIO ::.</title>
  </head>
  <body>
    <div class="egcc_page">
      <header class="egcc_header">
        <jsp:include page="header.jsp" />
      </header>
      <section class="egcc_menu">
        <jsp:include page="menu.jsp" />
      </section>
      <section class="egcc_content">
        <h1>VIDEO</h1>
        <div style="text-align: center;">
          <iframe width="750" height="360" 
                src="https://www.youtube.com/embed/clBK-R8LChM" frameborder="0" allowfullscreen></iframe>
        </div>
        
        <h1>PDF</h1>
        <div style="text-align: center;">
          <iframe src="http://myslide.es/embed/javapoo-01-clases-y-objetos.html" width="750" height="600" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border:1px solid #CCC; border-width:1px; margin-bottom:5px; max-width: 100%;" allowfullscreen> </iframe> 
        </div>
        
      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>
