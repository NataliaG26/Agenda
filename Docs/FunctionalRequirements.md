## Requerimientos Funcionales para la gestión de una agenda electrónica

Lina Johanna Salinas Delgado

Natalia Isabel González Murillo

Luis Felipe Sánchez Vega

Juan José Valencia Jaramillo

Universidad Icesi

Cali, Valle del cauca

2020

_________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

Una agenda electrónica es una aplicación que permite la gestión de la información personal de un grupo de contactos, en la que el usuario puede usar varias funciones básicas como si lo estuviera haciendo en una versión física. Para la aplicación actual, los datos provienen de los estudiantes y las materias que están cursando en el momento. Ésta agenda debe tener una interface de grafica usuario que permita a los usuarios:

**REQUERIMIENTO FUNCIONAL #1**

| Nombre    | Crear la entrada de un contacto                              |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario crear la entrada de un nuevo contacto con la información básica de interés en la agenda cada vez que el usuario lo requiera. |
| Entradas  | Avatar, Nombre Completo, Edad, Fecha de cumpleaños (día/mes) , Correo (email), Número de teléfono. |
| Resultado | La nueva entrada de contacto ha sido añadida a la agenda y es posible visualizar el contacto en la interfaz. |

**REQUERIMIENTO FUNCIONAL #2**

| Nombre    | Visualizar la información de un contacto                     |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite desplegar la información de un contacto previamente creado cada vez que el usuario realice una consulta. |
| Entradas  |                                                              |
| Resultado | la información del contacto es mostrada al usuario.          |

**REQUERIMIENTO FUNCIONAL #3**

| Nombre    | Navegar a través de la información de los contactos          |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario navegar entre distintas entradas permitiendo así la búsqueda por páginas como si de una versión física se tratase. |
| Entradas  |                                                              |
| Resultado | la información es mostrada por páginas con una cantidad de 4 contactos por cada página. |

**REQUERIMIENTO FUNCIONAL #4**

| Nombre    | Actualizar la información de un contacto                     |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario actualizar la información de un contacto cada vez que sea requerido |
| Entradas  | Nueva información según los cambios deseados (Nuevo email, Nuevo teléfono, etc.) |
| Resultado | La información del contacto ha sido actualizada.             |

**REQUERIMIENTO FUNCIONAL #5**

| Nombre    | Eliminar la entrada de un contacto                           |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario eliminar la entrada de un contacto previamente creado. |
| Entradas  |                                                              |
| Resultado | la entrada del contacto ha sido eliminada permanentemente.   |

**REQUERIMIENTO FUNCIONAL #6**

| Nombre    | Crear una materia                                            |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario crear una materia con la información básica de interés cada vez que el usuario lo requiera, para ser añadida más tarde a la lista de materias de la entrada de un contacto. |
| Entradas  | Nombre, Número de créditos, Semestre asignado                |
| Resultado | la entrada del contacto ha sido eliminada permanentemente.   |

**REQUERIMIENTO FUNCIONAL #7**

| Nombre    | Visualizar la información de una materia                     |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite visualizar la información de una materia previamente creada cada vez que el usuario lo requiera. |
| Entradas  |                                                              |
| Resultado | la información de la materia es mostrada al usuario.         |

**REQUERIMIENTO FUNCIONAL #8**

| Nombre    | Actualizar la información de una materia                     |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permita al usuario actualizar la información de una materia cada vez que sea requerido |
| Entradas  | Nueva información según los cambios deseados (nombre nuevo, nuevo número de créditos, etc.) |
| Resultado | la información de la materia ha sido actualizada.            |

**REQUERIMIENTO FUNCIONAL #9**

| Nombre    | Añadir una materia a la lista de materias de un contacto     |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario añadir una(s) materia(s) previamente creada(s) a la lista de materias de la entrada de un contacto como información adicional, si la(s) materia(s) no existe(n) entonces primero se debe(n) crear antes de ser añadida(s). |
| Entradas  |                                                              |
| Resultado | la(s) materia(s) ha(n) sido añadida(s) a la lista de materia de la entrada de un contacto. |

**REQUERIMIENTO FUNCIONAL #10**

| Nombre    | Eliminar una materia a la lista de materias de un contacto   |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario eliminar una(s) materia(s) previamente creada(s) de la lista de materias de la entrada de un contacto, si la lista de materias de la entrada de un contacto se encuentra vacía entonces no se pueden eliminar materias. |
| Entradas  |                                                              |
| Resultado | la(s) materia(s) ha(n) sido eliminada(s) de la lista de materia de la entrada de un contacto. |

**REQUERIMIENTO FUNCIONAL #11**

| Nombre    | Buscar la(s) entrada(s) de contacto(s) por un nombre dado    |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario buscar la(s) entrada(s) de contacto(s) que comienza(n) con la cadena de texto ingresada o que concuerdan completamente con el nombre dado. |
| Entradas  | Nombre del contacto a buscar.                                |
| Resultado | La(s) entrada(s) de contacto(s) que comienza(n) con la cadena de texto ingresada o que concuerda(n) completamente con el nombre dado han sido encontradas y mostradas al usuario. |

**REQUERIMIENTO FUNCIONAL #12**

| Nombre    | Buscar la(s) entrada(s) de contacto(s) por una edad dada o un criterio de búsqueda |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario buscar la(s) entrada(s) de contacto(s) dado un valor de edad y un criterio de búsqueda. |
| Entradas  | Edad del contacto a buscar, criterio de búsqueda (Menores que la edad dada, Iguales que la edad dada, mayores que la edad dada). |
| Resultado | La(s) entrada(s) de contacto(s) que contiene(n) la edad dada o que cumple(n) con el criterio de búsqueda dado ha(n) sido encontrada(s) y mostrada(s) al usuario. |

**REQUERIMIENTO FUNCIONAL #13**

| Nombre    | Buscar la(s) entrada(s) de contacto(s) por una(s) fecha(s) de cumpleaños dada(s) o un criterio de búsqueda |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario buscar la(s) entrada(s) de contacto(s) dado el valor de una(s) fecha(s) de cumpleaños y un criterio de búsqueda. |
| Entradas  | fecha de cumpleaños del contacto a buscar, criterio de búsqueda singular (una fecha) (Mismo día, Mismo mes, Misma fecha (día y mes)), criterio de búsqueda plural (dos fechas) (Entre rango de días, entre rango de meses)). |
| Resultado | La(s) entrada(s) de contacto(s) que cumple(n) la fecha dada o que cumple(n) con el criterio de búsqueda dado ha(n) sido encontrada(s) y mostrada(s) al usuario. |

**REQUERIMIENTO FUNCIONAL #14**

| Nombre    | Buscar la(s) entrada(s) de contacto(s) por una(s) materia(s) seleccionada(s) |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario buscar la(s) entrada(s) de contacto(s) dada una(s) materia(s). |
| Entradas  | Materia(s) seleccionada(s) de el(los) contacto(s) a buscar.  |
| Resultado | La(s) entrada(s) de contacto(s) que tiene(n) la(s) materia(s) seleccionada(s) en su lista de materias ha(n) sido encontrada(s) y mostrada(s) al usuario. |

**REQUERIMIENTO FUNCIONAL #15**

| Nombre    | Ordenar los contactos alfabéticamente por su nombre          |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario ordenar las entradas de contacto por un criterio lexicográfico de su nombre. |
| Entradas  | Criterio de ordenamiento (criterio lexicográfico).           |
| Resultado | Las entradas de contacto en la agenda han sido ordenadas por su nombre con un criterio lexicográfico, permitiendo su visualización en la interfaz. |

**REQUERIMIENTO FUNCIONAL #16**

| Nombre    | Ordenar los contactos ascendentemente por su edad            |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario ordenar las entradas de contacto por su edad de forma ascendente. |
| Entradas  | Criterio de ordenamiento (criterio ascendente)               |
| Resultado | Las entradas de contacto en la agenda han sido ordenadas por su edad de forma ascendente, permitiendo su visualización en la interfaz. |

**REQUERIMIENTO FUNCIONAL #17**

| Nombre    | Ordenar los contactos ascendentemente por la fecha de su cumpleaños |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite al usuario ordenar las entradas de contacto por su fecha de cumpleaños de forma ascendente |
| Entradas  | Criterio de ordenamiento (criterio ascendente)               |
| Resultado | Las entradas de contacto en la agenda han sido ordenadas por su fecha de cumpleaños de forma ascendente, permitiendo su visualización en la interfaz. |

**REQUERIMIENTO FUNCIONAL #18**

| Nombre    | Calcular el promedio de materias registradas por los contactos. |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite calcular el promedio de materias registradas por todos los contactos cada vez que el usuario lo requiera, dando a conocer el valor aproximado de materias que cada contacto tiene en su lista de materias. |
| Entradas  |                                                              |
| Resultado | El valor promedio de materias que cada contacto tiene registrado es calculado y mostrado al usuario en la pestaña de resumen. |

**REQUERIMIENTO FUNCIONAL #19**

| Nombre    | Calcular cual es la materia más registrada por los contactos |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite calcular la materia más registrada en la lista de materias de los contactos, dando a conocer cual es la materia que al menos cada contacto tiene en su lista de materias y cuantos son los que la tienen agregada. |
| Entradas  |                                                              |
| Resultado | La materia más registrada y cuantos estudiantes la tienen en su lista de materias es calculada y mostrada al usuario en la pestaña de resumen. |

**REQUERIMIENTO FUNCIONAL #20**

| Nombre    | Calcular cual es la materia menos registrada por los contactos |
| --------- | ------------------------------------------------------------ |
| Resumen   | Permite calcular la materia menos registrada en la lista de materias de los contactos, dando a conocer cual es la materia que como mucho cada contacto no tiene en su lista de materias y cuantos son los que no la tienen agregada. |
| Entradas  |                                                              |
| Resultado | La materia menos registrada y cuantos estudiantes no la tienen en su lista de materias es calculada y mostrada al usuario en la pestaña de resumen. |