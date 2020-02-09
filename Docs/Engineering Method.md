## Método de la ingeniería para la solución de un problema que requiere modelar información

Natalia Isabel González

Lina Johanna Salinas Delgado

Luis Felipe Sánchez Vega

Juan José Valencia Jaramillo

Universidad Icesi

Cali, Valle del cauca

2020

_________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

*Tabla de contenidos.*

[TOC]

____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

## 1. Definición del problema

Actualmente los sistemas de gestión de información se han vuelto bastante populares entre las organizaciones pues permiten manejar la información de manera limpia, segura y prolongada. Estos sistemas son desarrollados según las necesidades del cliente y especialmente su experiencia de usuario está orientada a la forma más cómoda en la que el usuario requiere poder gestionar sus datos para la toma de decisiones.

Diana, hace parte del ***departamento de tecnologías de información y comunicación*** (TIC) de la ***universidad Icesi***, y trabaja como secretaría, especialmente en la gestión de espacios, horarios, eventos y el más importante el contacto con los estudiantes para los distintos servicios que se les ofrece, como espacios de estudio, cambios de matricula, etc. Diana actualmente cuenta con una base de datos de los estudiantes la cual puede consultar cada vez que requiere contactar a un estudiante, pero esta información no se presenta organizada y es simple y estática. Por esto Diana ha considerado que sería bueno si pudiera gestionar la misma información que es agregada a su base de datos de manera visual, permitiéndole manipular la información de mejor manera y visualizarla más cómodamente.

Diana requiere ayuda con el desarrollo de una aplicación que le permita usar la información de los estudiantes y poder:

- Realizar operaciones básicas sobre la información (creación, edición, búsqueda, ordenamiento, etc.) y poder facilitar su almacenamiento y manipulación.
- Realizar operaciones básicas sobre información adicional del estudiante respecto a sus materias (edición, búsqueda, ordenamiento) y poder conocer de forma oportuna todo lo relacionado a las mismas.
- Realizar un análisis significativo de la información a través de un resumen que le permita generalizar sobre sus estudiantes guardados.

## 2. Recopilación de la información necesaria

Una vez definido el problema es importante realizar una identificación de los requerimientos funcionales con los cuales debe cumplir la aplicación a desarrollar, estos son: 

- El archivo respectivo que contiene toda la declaración de los requerimientos funcionales se puede encontrar adjunto a la carpeta de documentos del proyecto donde se encuentra también el presente informe.

**¿Qué es una base de datos?**

Una **base de datos** es una colección de información organizada de forma que un programa de ordenador pueda seleccionar rápidamente los fragmentos de datos que necesite. Una base de datos es un sistema de archivos electrónico.

Las bases de datos tradicionales se organizan por campos, registros y archivos. Un **campo** es una pieza única de información; un **registro** es un sistema completo de campos; y un **archivo** es una colección de registros. Por ejemplo, una guía de teléfono es análoga a un archivo. Contiene una lista de registros, cada uno de los cuales consiste en tres campos: nombre, dirección, y número de teléfono.

**¿Qué es gestionar información?**

Gestionar información es: ir en busca de nuevos significados, análisis, aplicar el principio de que el todo, es más que la suma de las partes. Es producir un impacto en el ambiente de cualquier organización.

Es un proceso que debe estar presente en cada uno de los pasos de la organización, es un proceso y a la vez un subproceso. Requiere acción, decisión y evaluación.

Mediante la gestión se proporcionan los recursos de información necesarios para una buena toma de decisiones, se desarrollan nuevos conocimientos que posibilitan calidad y eficiencia en los servicios y productos de las organizaciones.

## 3. Búsqueda de soluciones creativas 

Ahora que se tiene la información necesaria para el problema, es pertinente realizar la búsqueda de soluciones creativas que puedan dar solución al problema con las condiciones requeridas. Por lo anterior, a continuación se plantea una técnica de relación forzada para generar ideas.

El objetivo de esta técnica es poder tomar un componente (entidad, producto, etc) relacionado al problema y un componente totalmente ajeno para luego realizar una conexión forzada entre ellos a partir de palabras que desarrollan el componente en sí mismo.

<u>Estudiante:</u> competencias, dedicación, aprendizaje, curiosidad

<u>Libro:</u> índice, búsqueda, palabras, significado

La relación entre curiosidad e índice nos conduce por ejemplo a la idea de realizar un sistema que permita manejar la información de una forma particular en la que se pueda consultar como lo hace un diccionario a través de indices. 

La relación entre dedicación y búsqueda nos conduce por ejemplo a la idea de realizar un sistema donde buscar la información de una buena forma sea lo fundamental.

La relación entre aprendizaje y palabras nos conduce por ejemplo a la idea de realizar un sistema que permita realizar un aprendizaje sobre si mismo, usando técnicas como la búsqueda por predicción.

La relación entre competencias y significado nos conduce por ejemplo a la idea de realizar un sistema que permita darle sentido a la información, en la que por ejemplo se le de al usuario un resumen con toda la información disponible.

## 4. Transición de la formulación de ideas a los diseños preliminares

Ya que las ideas han sido generadas, es momento de ampliarlas y realizar un análisis sobre los aspectos extra que conllevaría llevarlas a cabo, con el objetivo de poder realizar un descarte de aquellas ideas que no son del todo útiles.

1. **Diccionario**: Esta idea propone realizar un sistema en el que la información sea indexada con el objetivo de poder almacenar en estos indices la información pertinente a cada estudiante registrado en la base de datos, esto facilita la búsqueda de la misma pero limita bastante su gestión pues si se requiere indexar la información se debe hacer por un solo criterio. 
2. **Agenda e información con sentido:** Esta idea propone realizar un sistema en el que la búsqueda de la información se haga de manera dedicada es decir eficaz y exhaustiva, pero también con la fusión de la idea de realizar que la información tenga algún tipo de sentido para el usuario, esto puede recogerse en la idea de crear una agenda digital que presenta la información pero que tenga funciones extra como estás búsquedas que pueden realizarse por varios criterios para hacer más interesante su manipulación, o una página de resumen que recoja varios datos interesantes obtenidos a partir de toda la información registrada en el momento.
3. **Sistema de predicción:** Esta idea propone realizar un sistema de búsquedas por predicción, es decir que permita aprender sobre los datos que el usuario ha ingresado previamente en la aplicación, aunque prometedor esta idea es imposible de llevar a cabo por los escasos recursos de conocimiento que los autores poseen para su desarrollo, por eso se descarta.

## 5. Evaluación y selección de la mejor solución

Con el objetivo de poder seleccionar la mejor solución posible para el problema que se busca solucionar es considerable realizar un método de evaluación que permita decidir sobre cual es la mejor opción posible para ser desarrollada.

Para realizar la evaluación de ideas, se establecen los siguientes criterios basados en el significado que conllevan aplicar la solución planteada con un puntaje de 1 a 3 de la siguiente manera, bajo (La solución no es lo suficientemente relevante para el usuario y apenas presenta datos interesantes), intermedio (La solución es parcialmente significativa y presenta algunos datos interesantes), alto (La solución es totalmente significativa e incluye criterios de alto interés). Los criterios son los siguientes:

- Nivel de significado para el usuario:
  1. Bajo
  2. Intermedio
  3. Alto
- Nivel de significado en búsquedas:
  1. Bajo
  2. Intermedio
  3. Alto
- Nivel de significado en resumen:
  1. Bajo
  2. Intermedio
  3. Alto

Basado en esta consideración de significado la solución con más significado será la seleccionada y la mejor opción a implementar.

Consecuentemente, las respectivas soluciones posibles y los criterios de juicio desarrollados son agrupados en la siguiente tabla para poder llevar a cabo la evaluación.

| Idea                             | Nivel de significado para el usuario | Nivel de significado en búsquedas | Nivel de significado en resumen | Total |
| -------------------------------- | ------------------------------------ | --------------------------------- | ------------------------------- | ----- |
| Diccionario                      | 2                                    | 3                                 | 1                               | 6     |
| Agenda e información con sentido | **3**                                | **3**                             | **3**                           | **9** |

A partir de la evaluación anterior, la idea con más significado en todos los aspectos de interés es la de implementar una agenda que tenga a su vez información con sentido para el usuario, permitiéndole no sólo guardar todas las entradas necesarias sino también poder obtener un resumen con datos relevantes a partir de las mismas.

## 6. Preparación de los informes y especificaciones

Finalmente una vez elegida la solución definitiva a ser desarrollada es importante realizar un diseño que permita el direccionamiento de la misma hacia la implementación, para esto se desarrolla el siguiente diagrama de clases:

- El diagrama de clases se puede encontrar adjunto a la carpeta de documentos del proyecto donde se encuentra también el presente informe.

Por otro lado con el fin de comprender la manera en la que se gestionan los datos se desarrolla el siguiente flujo de datos:

- El flujo de datos se puede encontrar adjunto a la carpeta de documentos del proyecto donde se encuentra también el presente informe.

Además para entender como se realiza la manutención de los datos y su prolongación se desarrolla el siguiente diseño de la persistencia:

- El diseño de la persistencia se puede encontrar adjunto a la carpeta de documentos del proyecto donde se encuentra también el presente informe.

Ahora como parte del desarrollo lógico del presente informe se realiza una ***síntesis reflexiva*** que permita aportar una perspectiva autoconsciente sobre los autores y su proceso de aprendizaje y trabajo a la hora de escribirlo:

A través del desarrollo del método de la ingeniería se pudo encontrar de una manera estructurada una forma de poder llegar a la solución de un problema dado, poniendo en evidencia que para lograr un buen análisis de un proyecto es necesario seguir una secuencia que permita lograr llegar a algo con sentido.

Para el problema definido, el plantear soluciones fue algo más complejo de lo esperado, pues la consideración de presentar una información de manera significativa lleva consigo limitadas maneras de realizarlo, y por lo tanto pocas opciones de las cuales disponer, pero el objetivo era poder conseguir alguna que fuera lo suficientemente sencilla y que pudiera cumplir con ofrecer al usuario la manipulación y la facilidad de gestionar la información. Es por eso que se debió analizar la situación planteada para considerar el significado y el impacto en como se realiza esta gestión que gira en torno a la problemática en si misma y así poder clarificar las soluciones posibles. Esto permite considerar que es bueno ver las cosas desde otras perspectivas como los problemas que hay dentro de los mismos problemas para que una vez reconocidos sea más fácil elaborar una solución que asegure lograr resultados esperados con un alto desempeño.

## 7. Implementación

La debida implementación de la aplicación solicitada, con las funciones requeridas y la solución seleccionada se llevarán a cabo en el lenguaje de programación (Java) con la lista de las siguientes tareas a desarrollar:

- Permitir la gestión de contactos a través de operaciones básicas como creación, eliminación, edición y búsqueda.
- Permitir la gestión de materias a través de operaciones básicas como creación, edición y búsqueda.
- Diseñar una interfaz de usuario gráfica interactiva que permita el uso de todo lo anterior.

La implementación del proyecto se incluye en el siguiente repositorio de GitHub:

https://github.com/NataliaG26/Agenda

## 8. Referencias

1. (2020, Feb 6). ¿Qué es una base de datos? - Definición de base de datos [En línea]. Disponible en: https://www.masadelante.com/faqs/base-de-datos

2. (2019, Jun 27). Gestión de la información [En línea]. Disponible en [https://www.ecured.cu/Gesti%C3%B3n_de_la_Informaci%C3%B3n](https://www.ecured.cu/Gestión_de_la_Información)

   

