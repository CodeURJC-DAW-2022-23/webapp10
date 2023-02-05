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

+ Usuario anónimo: Aquel usuario que visita la web y no introduce ningún tipo de credenciales para consultar contenido y realizar búsquedas. 

  - Permisos: En nuestro caso tendrá acceso a la parte gratuita y sin registro de la web. Podrá ver la web en su totalidad, realizar el cuestionario de dieta recomendada (sin acceder al resultado), y utilizar la calculadora de IMC (Índice de masa corporal). No podrá acceder a las dietas, recetas o nutricionistas



+ Usuario registrado: Aquel usuario que tiene que usar sus credenciales para acceder a la web.  Hay dos tipos de usuarios registrados, el trabajador y el cliente.
Ambos usuarios tendrán datos personalizados como su nombre y una imagen. En el caso del trabajador, habrá también información sobre su formación profesional y su puesto de trabajo. La web deberá permitir el registro de nuevos usuarios. 

  - Permisos:

    + Cliente: puede hacer modificaciones en sus datos personales, ver los planes y gestionar sus suscripciones (ya sean mensuales, trimestrales o anuales), tiene acceso a las recetas de la dieta recomendada. Puede elegir y comunicarse con los profesionales nutricionistas que forman parte del equipo.

    + Trabajador: aparte de tener sus datos personales con foto y cargo. Tendrán acceso a la página completa y permiso para gestionar las dietas y las recetas. Podrán modificar, añadir y editar dietas y recetas, así como acceder al perfil de sus clientes y al gestor de mensajes con ellos.

+ Usuario administrador: Aquel usuario que tiene control total sobre la información de la web. Este usuario será único y capaz de gestionar la página web.

  - Permisos: Puede dar el alta y la baja de nuevos usuarios, y aprobar los cambios de la web (dietas u otros que acepten al aspecto general). También lleva un registro con estadísticas de la web.


## Imágenes
La web permite la subida de imágenes desde el navegador web para que los usuarios registrados puedan actualizar su foto de perfil. Además, si es un usuario trabajador, podrá subir fotos complementarias a las recetas.

## Gráficos 
Se van a usar gráficos (charts) para mostrar de forma personalizada la frecuencia con la que el usuario ha seguido la dieta. 
Además, se generarán gráficos a nivel de administrador con los porcentajes de cuántos de nuestros usuarios pertenecen a cada tipo de dieta y otro gráfico que muestre cuántos usuarios realizan el test cada día en comparación con cuántos se suscriben.

## Tecnología complementaria
Se hará uso de la generación de PDFs para que el usuario pueda guardar o imprimir las dietas que se le planteen y las recetas que guste.

## Algoritmo de consulta avanzada
Se utilizará un algoritmo que permita establecer una dieta personalizada para cada cliente en base a las respuestas que le proporcione al cuestionario. Con ello también se le actualizarán las recetas recomendadas para su tipo de dieta.

## Features
1. Log-In: Subscribed user should be able to log in and access their account and diet.
2. Subscribe: New user should be able to subscribe to one of the available plans to access to ala the application’s features
3. Trial Period: All subscribed users will have the possibility of a trial period where a certain number of days will pass from the registration to the first payment.
4. Test: Any user should be able to access a test that shows their body mass index and the type of diet indicated according to their needs. If the user is anonymous, only the essential information of the result will be shown, while if the user is subscribed, they will have access to all the information of that new diet.
5. Profile: The registered user will be able to access a private and personal section containing their data, a message manager and, in case of being a subscribed user, their diet and analysis. In the case of a worker user, they will be able to add the recipes and diets they want and the data of the clients under their care and manage these aspects.
6. Specific tracking: The subscribed user will have access to graphs that allow them to observe their progress with the diets and be able to request help from a nutritionist.
7. Goals achievement: The subscribed user will be able to enter weekly data such as their weight, which will allow the responsible nutritionist to know if they are meeting their goals or if their diet needs to be updated.
8. Consultation with nutritionist: The subscribed user should have the possibility to communicate with a professional nutritionist through a message manager. 
9. Example recipes for each subset of recipes: The user should be able to view a set of recipes that serve as examples or options for the diet established for them.
10. View diets: The available diets must be visible to registered and subscribed users of the application. Each subscribed user will be able to view specific information regarding their diet.
11. Contact and About Us: The user needs a general section on the page that allows them to know the organization and get in touch with it in case of any doubts or difficulties.

## Entities
+	User: This entity corresponds to users who access the website, we divide them into three types:
   + Anonymous User
   + Registered User
   + Administrator
+ Diets: This entity represents the possible diets available on our website.
+	Recipes: This entity represents examples of meals based on the recommended diet. These recipes will be found on the web.
+	Test: This entity represents the optional questionnaire that will be proposed to each user. It will be common to all users and based on it a diet will be recommended.
The relationship is established when a user sees recommended recipes based on the diet that was established for them after taking the questionnaire.

## Types of users and their corresponding permissions
The web application will consider three types of users:

+ Anonymous user: That user who visits the website and does not enter any credentials to view content and perform searches.

  - Permissions: In our case, it will have access to the free and unregistered part of the website. They can view the entire website, take the recommended diet questionnaire (without accessing the result), and use the BMI calculator (Body Mass Index). They will not be able to access diets, recipes, or nutritionists.
  
  
+ Registered user: That user who has to use their credentials to access the website. There are two types of registered users, the worker and the client. Both users will have personalized data such as their name and an image. In the case of the worker, there will also be information about their professional training and their job. The website must allow for the registration of new users.

  - Permissions:
      + Client: can make changes to their personal data, view the plans, and manage their subscriptions (whether monthly, quarterly, or annually), has access to the recipes of the recommended diet. They can choose and communicate with the nutrition professionals who are part of the team.
      
       + Worker: in addition to having their personal data with photo and position. They will have access to the full page and permission to manage the diets and recipes. They can modify, add, and edit diets and recipes, as well as access their clients' profiles and the message manager with them.
    
+ Administrator user: That user who has total control over the website information. This user will be unique and capable of managing the website.

  - Permissions: They can give new users the go-ahead and take them down, and approve changes to the website (diets or others that accept the general appearance). They also keep a record of website statistics.

## Images
The website allows the upload of images from the web browser so that registered users can update their profile picture. Additionally, if it is a worker user, he or she can upload complementary photos to the recipes.

## Graphs
Charts will be used to show the frequency with which the user has followed the diet in a personalized way. Additionally, administrator-level charts will be generated showing the percentages of how many of our users belong to each type of diet and another chart showing how many users take the test each day compared to how many subscribe.

## Complementary technology
The generation of PDFs will be used so that the user can save or print the diets proposed and the recipes they like.

## Advanced Query Algorithm
An algorithm will be used that allows establishing a personalized diet for each client based on the answers provided in the questionnaire. With this, the recommended recipes for their type of diet will also be updated.
