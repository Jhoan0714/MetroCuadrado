# AUTOMATION-METRO CUADRADO

1. Estructura Del Proyecto.
	<p align="center">
		<img width="484" height="661" src="https://github.com/Jhoan0714/MetroCuadrado/blob/master/Informacion/Estructura.png">
	</p>
	•	Se crea el proyecto de automatización front end, ambiente web, para metro cuadrado, en el cual se utiliza:
	
		-	Java  Como lenguaje de programación.  
		-	Maven  Como herramienta de managment  y build del proyecto.  
		-	Page Object Model (POM)  Como patrón de diseño.  
		-	TestNG  como framework de testing.  
		-	Selenium Web Driver  Como herramienta de automatización de las pruebas.  
		-	Extent Report  Como framework de reportes html.  
		Notas: En el proyecto no se utilizo data-provider, ni otros silimares para aplicar técnicas como data driven, ya que no percibí que fuese necesario, para este ejemplo.

2. Configuración, ejecución y resultados.

	•	Se crea un archivo de ejecución TestNG.xml, el cual se encuentra en la raíz del proyecto. Este archivo ejecutara los test:  
	<p align="center">
		<img width="567" height="255" src="https://github.com/Jhoan0714/MetroCuadrado/blob/master/Informacion/ConfigureTestNg.png">
	</p>
	•	Para la ejecución en caso de estar en un IDE, ubicamos el archivo TestNG.xml en caso contrario ejecutamos en la raíz del proyecto el siguiente comando “mvn test -Dsurefire.suiteXmlFiles=TestNG.xml”.  
	•	La ejecución creara una carpeta con el nombre Reports y dentro de esta un archivo html con el reporte de ejecución.  
	<p align="center">
		<img width="567" height="270" src="https://github.com/Jhoan0714/MetroCuadrado/blob/master/Informacion/Dashboard.png">
	</p>
	<p align="center">
		<img width="567" height="270" src="https://github.com/Jhoan0714/MetroCuadrado/blob/master/Informacion/Reporte.png">
	</p>
	En este reporte se puede encontrar la información de los test, su estado si fallo, paso, no fue ejecutado, también su inicio y hora de ejecución, la evidencia a nivel de imagen y un dashboard inicial, que brinda la información a nivel general.
