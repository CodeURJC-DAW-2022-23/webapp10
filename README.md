# webapp10
## Funcionalidades
1. Log-In: El usuario suscrito ha de poder hacer log in para poder acceder a la información de su cuenta y su dieta.
2. Suscribirse: El usuario nuevo tiene que poder suscribirse a un plan de los posibles para acceder a todas las funcionalidades de la aplicación.
3. Período de prueba: Todo usuario suscrito va a tener la posibilidad de contar con un periodo de prueba de tal forma que pasarán ciertos días desde el registro hasta su primer cobro.
4. Cuestionario: Cualquier usuario debe poder acceder a un cuestionario que le muestre su índice de masa corporal y el tipo de dieta indicado según sus necesidades. Si es un usuario anónimo sólo se le mostrará la información esencial del resultado, mientras que si es un usuario suscrito tendrá acceso a toda la información de esa nueva dieta.
5. Perfil: El usuario registrado podrá tener acceso a una parte privada y personal que contendrá sus datos, un gestor de mensajes y, en caso de ser usuario suscrito, su dieta y análisis. En caso de usuario trabajador, las recetas y dietas que quiere añadir y los datos de los clientes a su cargo. Podrá gestionar estos aspectos.
6. Seguimiento específico: El usuario suscrito tendrá acceso a gráficos que le permitan observar su progreso con las dietas, además de poder pedir ayuda a un profesional nutricionista.
7. Cumplimiento de objetivos: El usuario suscrito podrá introducir datos semanales como su peso que permita al nutricionista a cargo saber si este está cumpliendo sus objetivos o es necesario actualizar su dieta.
8. Consultas nutricionistas: El usuario suscrito debe contar con la posibilidad comunicarse con un profesional nutricionista mediante un gestor de mensajes.
9. Recetas de ejemplo por cada subconjunto de recetas: El usuario ha de poder visualizar un conjunto de recetas que le sirvan de ejemplo o como opciones para la dieta que se les ha establecido.
10. Visualizar las dietas: Las dietas disponibles tendrán que ser visibles para los usuarios registrados y suscritos a la aplicación. Cada usuario suscrito podrá ver información específica referente a su dieta.
11. Contacto y about us: El usuario necesita un apartado general en la página que le permita conocer la organización y ponerse en contacto con ella ante cualquier duda o contratiempo.

## Entidades: 
+ Usuario: Esta entidad corresponde a los usuarios que accedan a la pagina web, los dividimos en tres tipos:
  + Usuario Anonimo
  + Usuario Registrado
  + Administrador
+ Dietas: Esta entidad representa las posibles dietas disponibles en nuestra página web.
+ Recetas: Esta entidad representa los ejemplos de comidas en función a la dieta recomendada. Estas recetas se encontrarán en la web.
+ Cuestionario: Esta entidad representa el cuestionario opcional que se propondrá a cada usuario. Este cuestionario será común a todos los usuarios y en base a él se recomendará una dieta.

La relación se establece cuando un usuario ve unas recetas recomendadas según la dieta que se le ha establecido al realizar el cuestionario.

## Tipos de usuarios y sus permisos correspondientes
La aplicación web deberá considerar tres tipos de usuarios:

+ Usuario anónimo: Aquél usuario que visita la web y no introduce ningún tipo de credenciales para consultar contenido y realizar búsquedas. 

  - Permisos: En nuestro caso tendrá acceso a la parte gratuita y sin registro de la web. Podrá ver la web en su totalidad, realizar el cuestionario de dieta recomendada (sin acceder al resultado), y utilizar la calculadora de IMC (Índice de masa corporal). No podrá acceder a las dietas, recetas o nutricionistas



+ Usuario registrado: Aquél usuario que tiene que usar sus credenciales para acceder a la web.  Hay dos tipos de usuarios registrados, el trabajador y el cliente.
Ambos usuarios tendrán datos personalizados como su nombre y una imagen. En el caso del trabajador, habrá también información sobre su formación profesional y su puesto de trabajo. La web deberá permitir el registro de nuevos usuarios. 

  - Permisos:

    + Cliente: puede hacer modificaciones en sus datos personales, ver los planes y gestionar sus suscripciones (ya sean mensuales, trimestrales o anuales), tiene acceso a las recetas de la dieta recomendada. Puede elegir y comunicarse con los profesionales nutricionistas que forman parte del equipo.

    + Trabajador: aparte de tener sus datos personales con foto y cargo. Tendrán acceso a la página completa y permiso para gestionar las dietas y las recetas. Podrán modificar, añadir y editar dietas y recetas, así como acceder al perfil de sus clientes y al gestor de mensajes con ellos.

+ Usuario administrador: Aquél usuario que tiene control total sobre la información de la web. Este usuario será único y capaz de gestionar la página web.

  - Permisos: Puede dar el alta y la baja de nuevos usuarios, y aprobar los cambios de la web (dietas u otros que acepten al aspecto general). También lleva un registro con estadísticas de la web.


## Imágenes
La web permite la subida de imágenes desde el navegador web para que los usuarios registrados puedan actualizar su foto de perfil. Además, si es un usuario trabajador, podrá subir fotos complementarias a las recetas.

## Gráficos 
Se van a usar gráficos (charts) para mostrar de forma personalizada la frecuencia con la que el usuario ha seguido la dieta. 
Además, se generarán gráficos a nivel de administrador con los porcentajes de cuántos de nuestros usuarios pertenecen a cada tipo de dieta y otro gráfico que muestre cuántos usuarios realizan el test cada día en comparación con cuántos se suscriben.

## Tecnología complementaria
Se hará uso de la generación de PDFs para que el usuario pueda guardar o imprimir las dietas que se le planteen y las recetas que guste.

## Algoritmo o consulta avanzada
Se utilizará un algoritmo que permita establecer una dieta personalizada para cada cliente en base a las respuestas que le proporcione al cuestionario. Con ello también se le actualizarán las recetas recomendadas para su tipo de dieta.
