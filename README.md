# TheSmartWay

## Development team (name, institutional mail, github user)
- Snezhan Buchelska Borislavova, s.buchelska.2018@alumnos.urjc.es, JaniURJC
- Carlos Fernández López, c.fernandezl.2019@alumnos.urjc.es, ruky00
- Sara González Terroba, s.gonzalezt.2018@alumnos.urjc.es, sara-glezt
- Daniel Monje Fuente, dj.monje.2019@alumnos.urjc.es, Steyex
- Adrián Peña García, a.penag.2018@alumnos.urjc.es, adroius

## Link to Trello
https://trello.com/b/jEYakjyN/daw

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

## Navegation Diagram
![Diagrama DAW F1](https://user-images.githubusercontent.com/61882490/218329039-56531846-79cf-4365-9ecf-caeb05a4530f.jpg)

