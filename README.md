# TheSmartWay

## Development team
| Name | Corporative email | Github user |
| - | - | - |
| Carlos Fernández López | c.fernandezl.2019@alumnos.urjc.es | ruky00 |
| Snezhan Buchelska Borislavova | s.buchelska.2018@alumnos.urjc.es | JaniURJC |
| Sara González Terroba |  s.gonzalezt.2018@alumnos.urjc.es | sara-glezt |
| Daniel Monje Fuente | dj.monje.2019@alumnos.urjc.es | Steyex |
| Adrián Peña García | a.penag.2018@alumnos.urjc.es | adroius |

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

## Screens
Screens have been added for the largest and most important functionalities. The application consists of the following screens:

+ MainPage_startScreen: Main page that all users will see upon entering.
![startScreen](https://user-images.githubusercontent.com/80918513/218333005-14b79d19-d16a-4e4e-83e1-eec2912ad3d3.png)

+ MainPage_possibleDiets: Scrolling through the main page, you can see a section with the available diets.
![posibleDiets](https://user-images.githubusercontent.com/80918513/218333210-9c0b4632-2ae0-4fa5-9fc4-45ca86af883c.png)

+ MainPage_form: There is a special section for the questionnaire on the main page.
![form](https://user-images.githubusercontent.com/80918513/218333303-199e3426-7aab-4002-a3fa-6cf51c74564a.png)

+ MainPage_nutritionist: Additionally, there is a section dedicated to nutritionists.
![nutritionist](https://user-images.githubusercontent.com/80918513/218335474-f972f0b1-a41c-4ddf-904d-986b32c4f926.png)


+ MainPage_howWeWork: Small part of the main page, dedicated to explaining how the app works.
![howWeWork](https://user-images.githubusercontent.com/80918513/218333555-d5f917a8-04ca-46c8-92f8-a8f032361dcc.png)

+ MainPage_contactUS: As in every web page, there is a Contact Us section.
![contactUs](https://user-images.githubusercontent.com/80918513/218333649-85a7d46e-b1ab-40f9-9e0e-a5fa6356f13b.png)

+ Test_FormToDo: Once you click on the "take test" button, it takes you to another page where you can fill out and submit the test.
![formToDo](https://user-images.githubusercontent.com/80918513/218333743-6637170d-68ce-4181-967c-e6d90b804dab.png)

+ USR_login: Also, on the main page and on the test page, there is a Login button that takes you to a new login screen.
![login](https://user-images.githubusercontent.com/80918513/218334033-c4a8ac81-3394-4679-aa2f-58f16e1ff4ac.png)

+ USR_adminDashboard: This page shows the different statistics the administrator is able to see.
![adminDashboard](https://user-images.githubusercontent.com/80918513/218334112-a53ebfde-1e49-47f9-9701-46e67c2ac37d.png)

+ USR_adminStats: Shows only Activity charts and other kind of graphs in-depth.
![adminStats](https://user-images.githubusercontent.com/80918513/218334348-60ad2160-66bd-4151-a784-62bb7e8cc253.png)

+ USR_adminWorkers: On this page, the admin can see all the workers on the page.
![adminWorkers](https://user-images.githubusercontent.com/80918513/218334813-824bc3ca-95bc-4d0b-9c14-0dc189bdc7e4.png)

+ USR_clientDiets: Each client can view their specific diet with all breakfast, lunch, and dinner recipes.
![clientDiets](https://user-images.githubusercontent.com/80918513/218334967-da45e016-1b03-43f6-ac30-aff1373e7ff2.png)

+ USR_clientStats:Each client has a section with goal compliance charts such as diet progress and weight.
![clientStats](https://user-images.githubusercontent.com/80918513/218335090-d0b6c542-f025-404f-8a28-eda58da13379.png)

+ USR_workerClients:Each nutritionist has a table with all the clients they are responsible for.
![workerClients](https://user-images.githubusercontent.com/80918513/218335214-19ed31c1-5ec7-463c-9733-99bd5b23a766.png)

+ USR_workerNewDiet:Workers can create a new specific diet based on the client's needs and add available recipes to those diets.
![workerNewDiet](https://user-images.githubusercontent.com/80918513/218335320-34a75f07-4299-41cb-8044-ab9e18fa5f3d.png)

+ USR_workerNewRecipe:Workers can upload a new recipe.
![workerNewRecipe](https://user-images.githubusercontent.com/80918513/218335264-8c2aa7bf-b78c-4c4b-b843-db8ffd6eddaf.png)



## Navegation Diagram
The following diagram shows how users can navigate through the different pages of the application according to their role. 
![Diagrama DAW F1](https://user-images.githubusercontent.com/61882490/218329039-56531846-79cf-4365-9ecf-caeb05a4530f.jpg)



## PHASE 2: WEB WITH HTML GENERATED IN SERVER AND AJAX

### EXECUTION INSTRUCTIONS

#### VERSIONS

The different technologies used for this phase are:
  * Java: 19.0.2
  * Maven: 4.0.0 
  * Spring Boot: 2.7.7
  * Itextpdf:  7.1.12
  * MySQL: 8.0.24


#### CONFIGURATION

In order to get our project code, you need to enter GitHub https://github.com/CodeURJC-DAW-2022-23/webapp10 , press code
button and download the zip.
The following steps are needed to install the Data base:

1. Go to the MySQL website (https://dev.mysql.com/downloads/workbench/) and click on "Download" under the MySQL Workbench
Community (GPL) section.

2. Select your operating system and click "Download" to start the download process.

3. Once the download is complete, open the installation file and follow the instructions to install MySQL Workbench on 
your computer.

4. Launch MySQL Workbench from your applications or start menu.

5. Click on the "Local instance 3306" under the "MySQL Connections" section to connect to the default local MySQL server.

6. Enter your MySQL server credentials if prompted.

7. Once connected, you can create or manage databases, tables, and execute SQL queries using the MySQL Workbench interface.

8. In order to use this DB you must insert new data to the DB by adding in DataSampleService info about the elements in tables.

9.Moreover, you should change the aplication.properties to create-drop instead of update.

#### EXECUTION
The IDE used to program the app is IntelliJ. In order to run the app you cave to press the button run located on the IDE
and make sure is located in backend directory. After that, it is needed to open a browser, preferable Google Chrome. To see the main page, write on the search bar http://localhost:8443/ . 


### DATA BASE ENTITIES DIAGRAM
![ER_model](https://user-images.githubusercontent.com/80918513/222978741-db3873a0-714e-4e74-a89e-de9016088ff7.png)


### CLASSES AND TEMPLATES DIAGRAM
![UMLdaw](https://user-images.githubusercontent.com/80918513/222978799-4b36ddf9-a689-4448-a0f0-811feda9568a.png)


### MEMBERS PARTICIPATION

#### Adrián Peña García

##### DESCRIPTION OF TASKS

I have worked on the functionalities of the admin, user and worker, i did part of the front-end development, focusing on the images of the web. I make the data structure of the diet, with the Triple entity, and also i have achived the form of how to show images on the web, that were saved in the data base.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Image web use and show (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/50e09c0bc30e34da3c95b983e516f3b5b901271a) |
| 2 | Charts admin and client (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/da8a90556fe74e4f802be1ddf6d1f3af224d3fd3) |
| 3 | Default avatar and addWorker admin in function (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/b00fbe9a72e6f9f55171060fd13a98f53f36a404) |
| 4 | Images load correctly from the data base (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/a6875016788ec2734eab3ae13d6d00d4eee1d5e9) |
| 5 | Triplet array Diet (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/14c3dafeac9ef7b75202868f4fbbf236f626ea24) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | WorkerController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/WorkerController.java) |
| 2 | Triplet.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/model/Triplet.java) |
| 3 | Diet.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/model/Diet.java) |
| 4 | AdminController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/AdminController.java) |
| 5 | ClientController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/ClientController.java) |


#### Daniel Monje Fuente

##### DESCRIPTION OF TASKS

I have worked mostly on the fron-end of the aplication. I fixed some buggs with the headers and links, and cared about the managment of controllers. Also helped to correct errors.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Profiles templates and controller updates (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/14cfef3f79d445b89ee2210a29c99d9afd40abe4) |
| 2 | Profile controllers and worker edit profile (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/799bfaf64bde1b28ac44a2d5250f8b86ce881478) |
| 3 | Profiles format and controllers(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/f9c048031dc68d2e6469c2dfda8466ecfcf80001) |
| 4 | PDF counter of downloads (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/2bac6a6d6843b14baed5f4e10dbda9bcaa7fe848) |
| 5 | Worker client table with mustache (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/faaad014a44bd70a69409176e5725c28fc64ab98) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | ClientController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/ClientController.java) |
| 2 | WorkerController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/WorkerController.java) |
| 3 | USR_AdminClientTable.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_AdminClientTable.html) |
| 4 | USR_ClientProfile.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_ClientProfile.html) |
| 5 | USR_WorkerEditProfile.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_WorkerEditProfile.html) |


#### Sara González Terroba

##### DESCRIPTION OF TASKS

I have carried out the generation of the PDFs the workers use to save recipes. I have worked on the front-end, mostly the templates of the test, non registered users, clients and workers.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Implementation of the Controllers and Templates for PDF Recipe (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/683731f367e2191d11535e9f134e899bccad70af) |
| 2 | First version of PDF Controller and dependencies (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/6c159fd9be76dc095a655901b9433afedcf7cff9) |
| 3 | Creation of worker template (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/9230f3bf8659e8f4d73571986345f07992fc6e36) |
| 4 | Implementation of Test template (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/2bad21fcc0a2d80c181e6bd62af066b1612f10b8) |
| 5 | Creation of Worker UploadDiets template (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/b0527ad4469373bca5334a0fa25c347a205423a4) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | PDFController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/PDFController.java) |
| 2 | GeneratePDFUsingHTML.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/GeneratePDFUsingHTML.java) |
| 3 | USR_WorkerDiets.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_WorkerDiets.html) |
| 4 | USR_NonRegForm.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_NonRegForm.html) |
| 5 | USR_WorkerUploadDiet.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_WorkerUploadDiets.html) |

#### Snezhana Borislavova Buchelska

##### DESCRIPTION OF TASKS

I have worked on the Worker features, mainly front-end. Also correcting errors or add wanted features on the rest of the program.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | All worker templates created and linked to Worker controller(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/90e187fbac11f3ce8e3164087c3b8c16d73ff77e) |
| 2 | Client diet changes (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/5873be8e63c03dfa05a47eed93d34461f9fdc34b) |
| 3 | Error creaton and linking to Initialitation controller (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/4eedcc5513776cbc654f8d19c8b5976811c85934) |
| 4 | View diets and recipes and Worker controller (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/97e5ca7a9b1d4677d06fcc965007d69fca28c38f) |
| 5 | Recipe tables with mustache and Worker controller updates with the data base (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/7b99fc2ea187e9c603286f17220dc44f3f4c741a) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | USR_ClientDiets.html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_ClientDiets.html) |
| 2 | USR_WorkerDiets.html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_WorkerDiets.html) |
| 3 | USR_WorkerViewRecipe.html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_WorkerViewRecipe.html) |
| 4 | USR_WorkerUploadDiets.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_WorkerUploadDiets.html) |
| 5 | USR_WorkerUploadRecipes.html(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/resources/templates/USR_WorkerUploadRecipes.html) |

#### Carlos Fernández López

##### DESCRIPTION OF TASKS

I have worked on almost all the features of the aplication, i did some things in the controllers, security configuration
model and services.  

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Merge branch 'Security' into main(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/57fe0858666440bd10eacb418aacc3b1af79de43)  |
| 2 | User Form cookie update(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/175cf3acde88ca3b7e8062850c44ffecb12494d8) |
| 3 | Merge branch 'MySQLTryouts' into main(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/052525ab921a0dd1c1cc612b9366aaba7510011c) |
| 4 | isPresent verification and chart update(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/452d5bcfd81efe6b71850c0676f083115de12074) |
| 5 | Some updates for AJAX and Post forms(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/6be0d95ac97473d813cf206eb6e5ba47d5ea1c7f) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | AdminController.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/AdminController.java)  |
| 2 | InitialationController.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/controller/InitialationController.java) |
| 3 | SecurityConfiguration.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/security/SecurityConfiguration.java) |
| 4 | DietService.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/service/DietService.java) |
| 5 | UserRepository.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/nutricion/src/main/java/com/nutri/backend/repositories/UserRepository.java) |

## PHASE 3: REST API INCORPORATION AND DOCKER DEPLOYMENT

### EXECUTION INSTRUCTIONS

#### DOCKERIZED APP EXECUTION

Firstly, install Docker in your computer. (You can download this program on: https://www.docker.com/get-started/)
Next, open command console. Change your working directory to the file where docker-compose.yml is. (/docker)
Execute 

```$ docker-compose up```

Once the app is running, open it in your browser on https://localhost:8443/

#### DOCKER IMAGE CONSTRUCTION

You need to log in to DockerHub before you execute the create_image.ps1 script (/docker). This script creates the new image and pushes it to DockerHub.

Create an account in DockerHub (https://hub.docker.com/signup) and execute in your command console:

``` $ docker login ```

Execute 

``` $ ./create_image.ps1  <name_of_the_new_image> ```

Note that you must edit the script in order to **add your DockerHub user**. If not, you won't be able to upload the image.

### API DOCS
The links to access to API DOCS documentation are:

* .yaml file (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/api-docs/api-docs.yaml)
* link to .html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/api-docs/api-docs.html)

### UPDATE DIAGRAM CLASS

![image](https://user-images.githubusercontent.com/80918513/227786424-f491f06c-074e-4d46-87d5-a9478d18ea64.png)


### MEMBERS PARTICIPATION
#### Adrián Peña García

##### DESCRIPTION OF TASKS

I have worked on the docker files and done the api's related with images.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Apis get diet post diet (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/4c4457437aecd587ee7e4d33c687c13ba89701f2) |
| 2 | Merge branch 'Docker' into apiRestDevelopment (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/fab87f264d14d3619ace1150a30c617e7b24bf5f) |
| 3 | Api image (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/f5f202d8544a943c5fd11f1722b3426f8a19f30a) |
| 4 | First try dockerfile (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/dedc02016f73184fb06618c1aab8dd9ccbfc31e3) |
| 5 | Api images (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/0a672c931e000eaa6cd2e138feeb313611ff2cf4) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | docker-compose.yml (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/docker/docker-compose.yml) |
| 2 | dockerfile (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/docker/dockerfile) |
| 3 | DietRestController.java  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/DietRestController.java) |
| 4 | RecepyRestController.java  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/RecepyRestController.java) |
| 5 | UserRestController.java  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/UserRestController.java) |


#### Carlos Fernández López

##### DESCRIPTION OF TASKS

I have worked on the API REST development and the docker image.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | API REST admin usage (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/301fd69ee8b523f0de1c499f3229b55661c87721) |
| 2 | jwt introduction and some RestSecurity creations(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/3086bbe5188133b237e65848474753993f7fe9b7) |
| 3 | API REST client functions and worker recipes update 2(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/87ff9d64c6f99188e49105c5b1359ed458285b01) |
| 4 | Merge remote-tracking branch 'origin/main' into main(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/723e077e60b9d483ee2ad6170478ae293477f6e7) |
| 5 | paged items in API REST(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/2e1bc8fab79bd05ed3a75d91dadde0f724b970d1) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | UserRestController.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/UserRestController.java)|
| 2 | LoginController.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/auth/LoginController.java) |
| 3 | DietRestController.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/DietRestController.java) |
| 4 | FormRestController.java(https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/FormRestController.java) |
| 5 | docker(https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/docker) |


#### Sara González Terroba

##### DESCRIPTION OF TASKS

I have carried out the generation of api-docs and the erasure of the diets in the worker page. I have participated a bit on API REST.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | First part of the generation of Api-docs (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/166a7a2c73cb1bbd4fe1639e562fabc11df301df) |
| 2 | Completed generation of Api-docs (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/519a039eb70aefc181fb270c88c33d355b5ba32f) |
| 3 | Implementation of Delete Diet (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/166242275827f38ed2ff338cc19c669f53c3fb52) |
| 4 | Implementation of Delete Diet (fixed error .- foreign key) (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/b8f3c81900d3998af49dc1ce11d3ee502f73e3b9) |
| 5 | API REST client functions and worker recipes update (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/f46ac8911ff5720d0afe14557ba5f7a42a89f001) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | WorkerController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/WorkerController.java) |
| 2 | UserRepository.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/repositories/UserRepository.java) |
| 3 | pom.xml (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/pom.xml) |
| 4 | api-docs.html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/api-docs/api-docs.html) |
| 5 | USR_WorkerViewDiet.html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/resources/templates/USR_WorkerViewDiet.html) |

#### Daniel Monje Fuente

##### DESCRIPTION OF TASKS

I worked on docker, generation of the docker file and image. Also I did some small changes on the rest of the app. 

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | New Image in DockerHub and DietService delete (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/5ebadd1181601016cf1e4c3ba38afc70dfa2121a) |
| 2 | docker try (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/e453aa2a0723f53d8aba55bd233bc599e70643ac) |
| 3 | docker working (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/b49ade487e18c79d40c6a0dc863370ad536096b1) |
| 4 | api images (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/0a672c931e000eaa6cd2e138feeb313611ff2cf4) |
| 5 | Mix of changes (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/3f33823c249d3a7c59931835c63d50f1733ebaed) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | dockerfile (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/docker/dockerfile) |
| 2 | NutricionApplicationTests.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/test/java/nutri/web/nutricion/NutricionApplicationTests.java) |
| 3 | RecepyRestController.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/RecepyRestController.java) |
| 4 | DietService.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/service/DietService.java) |
| 5 | DietRepository.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/repositories/DietRepository.java) |

#### Snezhana Borislavova Buchelska

##### DESCRIPTION OF TASKS

I worked on ApiRest development and helped with the app's correct starting.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Services Injection (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/6efc24b02d2d9defc722471b89170754516b8dcb) |
| 2 | Merge completed and some little changes (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/71d83ee9becc345032d2c6dd2bc65ee55614d64b) |
| 3 | API REST admin delete users (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/7d00ba070d213e28097ddf446edac9d28e468650) |
| 4 | Merge branch 'apiRestDevelopment' into main (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/23bd260992cbaa115e7063dca49da81d6a911a15) |
| 5 | Correct Starting of the aplication (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/60fbd0ccf464dc5ed6b1a174224433b374e24f25) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | DietService.java (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/service/DietService.java) |
| 2 | AdminController.java  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/AdminController.java) |
| 3 | WorkerController.java  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/WorkerController.java) |
| 4 | UserRestController.java  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/src/main/java/com/nutri/backend/controller/UserRestController.java) |
| 5 | pom.xml (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/backend/nutricion/pom.xml) |

## PHASE 4: IMPLEMENTATION OF THE WEB WITH SPA ARCHITECTURES

### PREPARTING ANGULAR DEVELOPMENT

#### The versions used on this part are:

+ Angular CLI: 15.2.5

+ Node: 18.15.0

+ Package Manager: npm 9.6.4

+ Angular: 15.2.6
... core

#### Package Version:

+ @angular-devkit/architect 0.1502.5

+ @angular-devkit/build-angular 15.2.5

+ @angular-devkit/core 15.2.5

+ @angular-devkit/schematics 15.2.5

+ @angular/cli 15.2.5

+ @schematics/angular 15.2.5


### IDE PREPARATION:

First, you need to install VSCode, then execute a series of commands to prepare the project.

After this, you need to install Angular CLI using the command: ```npm install -g @angular/cli```

Next, check the installed version with the command: ```ng version```

Then, install Angular: ```npm install @angular-devkit/build-angular```

Then, install Bootstrap: ```ng add @ng-bootstrap/ng-bootstrap```

Finally, install Charts: ```npm install ngx-echarts -S```

To ensure that we have all the necessary dependencies installed in the project, we will use the command: ```npm install```

To run the application, it will be necessary to configure a proxy with a file: ```proxy.conf.json```

![image](https://user-images.githubusercontent.com/80918478/233776086-98d49766-ca65-4560-8a37-6f557da524ea.png)

Finally, to run the application, you will need to use the command:
```ng serve --proxy-config proxy.conf.json```

In order to deploy the application in the private cluster:

1.- We connect to the machine with the command ```ssh -i PrivateKey vmuser@10.100.139.190```

2.- We install Docker and Docker Compose

3.- We clone the repository with the command ```git clone 'URL of the repository in main fork'```

4.- We deploy the application with the command ```sudo docker compose up -d```

Normal page: https://10.100.139.190:8443/

SPA page: https://10.100.130.190:8443/new

Video of the application:https://youtu.be/Z_nOpoTMvfg

### CLASS DIAGRAM AND TEMPLATES OF THE SPA
![image](https://user-images.githubusercontent.com/80918513/233783522-d78975bd-ab8f-4f27-92b7-14f0772aa875.png)

### MEMBERS PARTICIPATION
#### Adrián Peña García

##### DESCRIPTION OF TASKS

I have worked in the worker component and client componente.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Recetas client and images worker and client header and settigns (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/9de929cd764712f1a2f7970eb870e14f490fc896) |
| 2 | New diet (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/5dc4e1bb0be19090e8497441fb3b31e974c6bacb)|
| 3 | Register component (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/77d2932d7c35f37536d694e3fd8e7a7aaf466c3b)|
| 4 | Worker component (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/d82f2f7a84e65ba08327e13eed3ef204e49774ce)|
| 5 | Start services and models angular (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/3d8b3c25cb92e5469e87169e799e8bf3601db2d5)|

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | User.service.ts  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/frontend/src/app/services/User.service.ts)|
| 2 | Worker (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/modules/worker)|
| 3 | Register (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/components/register)|
| 4 | login.service.ts  (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/frontend/src/app/services/login.service.ts)|
| 5 | Settings (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/modules/client/components/settings)|

#### Daniel Monje Fuente

##### DESCRIPTION OF TASKS

I have worked on the profile settings and image upload. Also worked on worker diets and recipies uploads.
##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Readme (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/bbb43f3d8b31fbb5217fd3781dbc778be591a290) |
| 2 | Upload-recipe, recipe-table y cositas (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/36f7d9cebe8f1eb0088b51ab545f0b5920a0b043) |
| 3 | Recipe-table cosas(https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/cc545acce5048fb95174d90d2523762c760f2fe6) |
| 4 | Settings (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/7a43af50b5416c84490e4bb96514f3746f32db1b) |
| 5 | Image (settings) (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/e55387cc7b165e2ae8a7374baad268143b8a5683) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | user.service.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/frontend/src/app/services/User.service.ts) |
| 2 | recepie.model.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/frontend/src/app/models/Recepie.model.ts) |
| 3 | settings.component.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/frontend/src/app/modules/worker/components/settings/settings.component.ts) |
| 4 | diet.component.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/frontend/src/app/modules/client/components/diet/diet.component.ts) |
| 5 | upload-recipe.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/modules/worker/components/upload-recipe) |

#### Sara González Terroba

##### DESCRIPTION OF TASKS

I have worked on the module of the client from the beggining, I've created the files and implemented most of them.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Client components (dashboard, form, diet and recipes) (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/6f257c8448d60f090af4029751cfad249310349a) |
| 2 | Client components changes (added charts and overall style) (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/760a8ac991d96fe57605f6d10bdb5f10cbe06cf9) |
| 3 | Client charts (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/83a3366839318ab855dad2ce59954a81ff315b3b) |
| 4 | Client recipes (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/83454f9ebc60a50b82b506d09ce9b0126c5a18e2) |
| 5 | Client profile settings (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/85fecfd4d233a9b108e8306e6336bdb7524fe3b3) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | client-routing.module.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/client/client-routing.module.ts) |
| 2 | client.module.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/client/client.module.ts) |
| 3 | diet.component.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/client/components/diet/diet.component.ts) |
| 4 | recipes.component.spec.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/client/components/recipes/recipes.component.spec.ts) |
| 5 | recipes.component.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/client/components/recipes/recipes.component.ts) |

#### Snezhana Borislavova Buchelska

##### DESCRIPTION OF TASKS

Due to technical issues with VS Code, I've worked only on few stuff,such as worker, HTML details and also Readme.

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | Diets HTML (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/604100fb6223fcfe829d0ffcec300427224ae221) |
| 2 | Header,Recipes, Diet,Service (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/772f0ee2b8afb77fd5d6dbde89df84bcc2ae09ca) |
| 3 | Worker (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/0734696cd38c8667d06d69c8fe2a8165738f5fd0) |
| 4 | Auth Service (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/5d8b411d499ef8c8315f5f603bc2ab30476e2706) |
| 5 | Diagram UML Readme (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/0f71bcb8b5dc6c43fff39f3d7d6d153d1ff46530) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | diet.components.html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/client/components/diet/diet.component.html) |
| 2 | auth.service.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/services/auth.service.ts) |
| 3 | recipes.component.html (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/worker/components/recipes/recipes.component.html) |
| 4 | worker-dashboard.component.spec.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/worker/components/worker-dashboard/worker-dashboard.component.spec.ts) |
| 5 | worker.module.ts (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/AngularDevelepment/frontend/src/app/modules/worker/worker.module.ts) |

#### Carlos Fernández López

##### DESCRIPTION OF TASKS

I have worked on most of the things in this sprint such as guards, admin, general components, docker and correction of other components my teammates worked on

##### COMMITS DONE

| Name | Description |
| - | - |
| 1 | router navigation (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/c3a485f1c05cfbb8ff7e5a4105819050b54c18d9) |
| 2 | Guards, admin Component intro and other component (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/15dc4bab5e84b82af730b185873caefbe69d3a33) |
| 3 | charts on update, next step: connect with API data (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/8d293636fa0bb1686c61c8a8b1747c8eea7430a7) |
| 4 | finished admin stats component (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/98521e480b119be26bb3f09aba29d6c379e75d07) |
| 5 | Correct Guard and Admin list implementation (https://github.com/CodeURJC-DAW-2022-23/webapp10/commit/955fd3199692744273153c39ab3b789998a1b22f) |

##### FILES PARTICIPATED

| File name | Link to github |
| - | - |
| 1 | admin (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/modules/admin) |
| 2 | components (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/components) |
| 3 | dockerfile (https://github.com/CodeURJC-DAW-2022-23/webapp10/blob/main/docker/dockerfile) |
| 4 | guards (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/guards) |
| 5 | client (https://github.com/CodeURJC-DAW-2022-23/webapp10/tree/main/frontend/src/app/modules/client) |

