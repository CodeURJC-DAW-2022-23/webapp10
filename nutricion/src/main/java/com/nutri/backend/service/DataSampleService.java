package com.nutri.backend.service;


import com.nutri.backend.controller.InitialationController;
import com.nutri.backend.model.*;
import com.nutri.backend.repositories.DietRepository;
import com.nutri.backend.repositories.RecepyRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nutri.backend.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class DataSampleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RecepyRepository recepyRepository;

    @Autowired
    private DietRepository dietRepository;


    @PostConstruct
    public void init() throws IOException {
        //Admin
        this.userRepository.save(new User("ejemplo@yahoo.es", passwordEncoder.encode("1234")));

        //Workers
        User[] workers = {
                new User("Worker", "Garcia", "ejemploworker@yahoo.es", "Expert", passwordEncoder.encode("1234")),
                new User("Laura", "Martinez", "laura.martinez@example.com", "Beginner", passwordEncoder.encode("Password2")),
                new User("Carlos", "Fernandez", "carlos.fernandez@example.com", "Intermediate", passwordEncoder.encode("Password3")),
                new User("Pedro", "Gomez", "pedro.gomez@example.com", "Intermediate", passwordEncoder.encode("Password5")),
                new User("Elena", "Perez", "elena.perez@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Pablo", "Martinez", "pablo.martinez@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Maria", "Gonzalez", "maria.gonzalez@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Antonio", "Lopez", "antonio.lopez@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Ana", "Ruiz", "ana.ruiz@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Carlos", "Fernandez", "carlos.fernandez@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Lucia", "Sanchez", "lucia.sanchez@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Sergio", "Jimenez", "sergio.jimenez@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Laura", "Gomez", "laura.gomez@example.com", "Expert", passwordEncoder.encode("Password1"))
        };

        for (User usuario : workers) {
            setUserImage(usuario,new ClassPathResource("static/images/undraw_profile.jpg").getPath());
            userRepository.save(usuario);
        }

        //Usuarios
        User[] usuarios = {
                new User("Cliente", "Pena", "ejemploclient@yahoo.es", passwordEncoder.encode("1234")),
                new User("Juan", "Perez", "juan.perez@example.com", passwordEncoder.encode("Password1")),
                new User("Maria", "Garcia", "maria.garcia@example.com", passwordEncoder.encode("Password2")),
                new User("Pedro", "Sanchez", "pedro.sanchez@example.com", passwordEncoder.encode("Password3")),
                new User("Ana", "Martinez", "ana.martinez@example.com", passwordEncoder.encode("Password4")),
                new User("Luis", "Rodriguez", "luis.rodriguez@example.com", passwordEncoder.encode("Password5")),
                new User("Elena", "Fernandez", "elena.fernandez@example.com", passwordEncoder.encode("Password6")),
                new User("Pablo", "Gomez", "pablo.gomez@example.com", passwordEncoder.encode("Password7")),
                new User("Carmen", "Lopez", "carmen.lopez@example.com", passwordEncoder.encode("Password8")),
                new User("Miguel", "Torres", "miguel.torres@example.com", passwordEncoder.encode("Password9")),
                new User("Isabel", "Navarro", "isabel.navarro@example.com", passwordEncoder.encode("Password10")),
                new User("Pedro", "Gonzalez", "pedro.gonzalez@example.com", passwordEncoder.encode("Password10")),
                new User("Sofia", "Sanchez", "sofia.sanchez@example.com", passwordEncoder.encode("Password10")),
                new User("Carlos", "Martinez", "carlos.martinez@example.com", passwordEncoder.encode("Password10")),
                new User("Laura", "Perez", "laura.perez@example.com", passwordEncoder.encode("Password10")),
                new User("Miguel", "Garcia", "miguel.garcia@example.com", passwordEncoder.encode("Password10")),
                new User("Ana", "Rodriguez", "ana.rodriguez@example.com", passwordEncoder.encode("Password10")),
                new User("Jose", "Fernandez", "jose.fernandez@example.com", passwordEncoder.encode("Password10")),
                new User("Maria", "Lopez", "maria.lopez@example.com", passwordEncoder.encode("Password10")),
                new User("David", "Ruiz", "david.ruiz@example.com", passwordEncoder.encode("Password10")),
                new User("Isabel", "Navarro", "isabel.navarro@example.com", passwordEncoder.encode("Password10"))
        };

        for (User usuario : usuarios) {
            setUserImage(usuario,new ClassPathResource("static/images/undraw_profile.jpg").getPath());
            userRepository.save(usuario);
        }

        //Recetas desayuno
        this.recepyRepository.save(new Recepy("Huevos revueltos con aguacate", "Huevos revueltos con aguacate y tostadas", "1. Batir los huevos en un tazon.\n2. Calentar una sarten y anadir los huevos batidos.\n3. Revolver los huevos hasta que esten cocidos.\n4. Cortar el aguacate en cubos.\n5. Servir los huevos revueltos con aguacate y tostadas.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Tostadas francesas con frutas", "Tostadas francesas con frutas frescas y miel", "1. Batir los huevos con leche en un tazon.\n2. Sumergir las rebanadas de pan en la mezcla de huevo y leche.\n3. Calentar una sarten y dorar las rebanadas de pan.\n4. Cortar las frutas en cubos.\n5. Servir las tostadas francesas con las frutas frescas y la miel.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Batido de frutas con avena", "Batido de frutas con avena y yogur", "1. Cortar las frutas en cubos.\n2. Anadir las frutas, la avena y el yogur en una licuadora.\n3. Licuar todos los ingredientes hasta obtener una mezcla suave.\n4. Servir el batido de frutas con avena y yogur.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Tortilla de champinones y espinacas", "Tortilla de champinones y espinacas con queso y pan tostado", "1. Saltear los champinones y las espinacas en una sarten.\n2. Batir los huevos en un tazon.\n3. Anadir los champinones y espinacas a los huevos batidos.\n4. Calentar una sarten y verter la mezcla de huevo y verduras.\n5. Anadir el queso rallado por encima.\n6. Servir la tortilla de champinones y espinacas con pan tostado.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Waffles con tocino y huevo", "Waffles con tocino, huevo frito y sirope de arce", "1. Cocinar el tocino y reservar.\n2. Batir los huevos en un tazon y hacer un huevo frito.\n3. Calentar la plancha de waffles y cocinar los waffles.\n4. Servir los waffles con el tocino, el huevo frito y el sirope de arce.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Huevos revueltos con tocino", "Huevos revueltos con tocino, cebolla y queso", "1. Cocinar el tocino y dejar escurrir sobre papel absorbente.\n2. Batir los huevos con sal y pimienta.\n3. Saltear la cebolla hasta que este dorada.\n4. Agregar los huevos a la sarten y revolver constantemente.\n5. Cuando los huevos esten casi listos, anadir el tocino y el queso.\n6. Servir caliente.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Tostadas francesas", "Tostadas francesas con canela y azucar glass", "1. Batir los huevos con leche, canela y azucar.\n2. Remojar el pan en la mezcla de huevo.\n3. Cocinar las tostadas en una sarten con mantequilla hasta que esten doradas.\n4. Espolvorear azucar glass sobre las tostadas.\n5. Servir caliente.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Hotcakes con frutas", "Hotcakes con frutas frescas y miel", "1. Mezclar la harina, la sal, el polvo para hornear y el azucar.\n2. Batir los huevos con la leche y la vainilla.\n3. Agregar la mezcla de harina a los huevos y mezclar bien.\n4. Cocinar los hotcakes en una sarten con mantequilla hasta que esten dorados.\n5. Servir los hotcakes con frutas frescas y miel.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Yogurt con granola", "Yogurt natural con granola, frutas y miel", "1. Mezclar el yogurt con miel.\n2. Agregar la granola y las frutas.\n3. Servir frio.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Huevos Benedict", "Huevos Benedict con jamon y salsa holandesa", "1. Cocinar el jamon y dejar escurrir sobre papel absorbente.\n2. Preparar la salsa holandesa batiendo y calentando mantequilla, yemas de huevo y jugo de limon.\n3. Cocinar los huevos pochados.\n4. Tostar el pan y colocar el jamon y los huevos encima.\n5. Agregar la salsa holandesa sobre los huevos.\n6. Servir caliente.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Batido de frutas", "Batido de frutas con leche y miel", "1. Mezclar las frutas con la leche y la miel en la licuadora.\n2. Licuar hasta que este suave.\n3. Servir frio.", "Breakfast"));

        //Recetas Comida
        this.recepyRepository.save(new Recepy("Ensalada Cesar con pollo", "Ensalada de lechuga romana, pollo, queso parmesano y crutones", "1. Cocinar la pechuga de pollo y cortarla en tiras.\n2. Mezclar la lechuga con el aderezo Cesar, queso parmesano y crutones.\n3. Anadir las tiras de pollo y servir.", "Lunch"));
        this.recepyRepository.save(new Recepy("Tacos de carne asada", "Tacos de carne asada con cebolla, cilantro y limon", "1. Marinar la carne con sal, pimienta y jugo de limon.\n2. Cocinar la carne a la parrilla hasta que este dorada.\n3. Cortar la carne en tiras y servir en tortillas de maiz con cebolla y cilantro.", "Lunch"));
        this.recepyRepository.save(new Recepy("Pasta Alfredo con pollo", "Pasta con salsa Alfredo y pollo", "1. Cocinar la pasta siguiendo las instrucciones del paquete.\n2. Cortar la pechuga de pollo en cubos y cocinar en una sarten.\n3. Mezclar la pasta con la salsa Alfredo y agregar el pollo.\n4. Servir caliente.", "Lunch"));
        this.recepyRepository.save(new Recepy("Ensalada de pollo y aguacate", "Ensalada de pollo, aguacate, tomate y lechuga", "1. Cocinar la pechuga de pollo y cortar en cubos.\n2. Mezclar la lechuga con el pollo, aguacate y tomate.\n3. Alinar con aceite de oliva y jugo de limon.\n4. Servir frio.", "Lunch"));
        this.recepyRepository.save(new Recepy("Pechuga de pollo a la plancha", "Pechuga de pollo a la plancha con arroz y verduras", "1. Cocinar la pechuga de pollo a la plancha con sal y pimienta.\n2. Cocinar arroz y verduras al vapor.\n3. Servir la pechuga de pollo junto con el arroz y las verduras.", "Lunch"));
        this.recepyRepository.save(new Recepy("Wrap de pollo y queso", "Wrap de tortilla de trigo con pollo, queso cheddar y aguacate", "1. Cocinar la pechuga de pollo y cortar en tiras.\n2. Colocar el pollo, queso cheddar y aguacate sobre la tortilla de trigo.\n3. Enrollar el wrap y calentar en una sarten.\n4. Servir caliente.", "Lunch"));
        this.recepyRepository.save(new Recepy("Pollo a la parrilla con ensalada de tomate", "Pechuga de pollo a la parrilla con ensalada de tomate, cebolla y pepino", "1. Marinar la pechuga de pollo en aceite de oliva, sal y pimienta.\n2. Cocinar el pollo a la parrilla hasta que este dorado.\n3. Cortar los tomates, la cebolla y el pepino en cubos.\n4. Mezclar los vegetales con aceite de oliva, sal y pimienta.\n5. Servir el pollo con la ensalada de tomate.", "Lunch"));
        this.recepyRepository.save(new Recepy("Ensalada de quinoa con pollo", "Ensalada de quinoa con pollo, aguacate y tomate cherry", "1. Cocinar la quinoa y dejar enfriar.\n2. Cocinar la pechuga de pollo y cortarla en tiras.\n3. Cortar el aguacate y los tomates cherry en cubos.\n4. Mezclar la quinoa con el pollo, aguacate, tomate y aderezo de limon y cilantro.\n5. Servir la ensalada de quinoa con pollo.", "Lunch"));
        this.recepyRepository.save(new Recepy("Arroz frito con camarones", "Arroz frito con camarones, guisantes y zanahoria", "1. Cocinar el arroz y dejar enfriar.\n2. Pelar y desvenar los camarones.\n3. Saltear los camarones con guisantes y zanahoria en una sarten.\n4. Anadir el arroz y mezclar todo junto.\n5. Servir caliente.", "Lunch"));
        this.recepyRepository.save(new Recepy("Hamburguesa de pollo con aguacate", "Hamburguesa de pollo con aguacate, queso y cebolla caramelizada", "1. Cocinar la hamburguesa de pollo a la parrilla.\n2. Cortar el aguacate en rodajas.\n3. Saltear la cebolla hasta que este caramelizada.\n4. Anadir el queso sobre la hamburguesa de pollo y dejar que se derrita.\n5. Colocar la hamburguesa de pollo sobre el pan y anadir las rodajas de aguacate y la cebolla caramelizada.\n6. Servir caliente.", "Lunch"));

        //Recetas Dinner
        this.recepyRepository.save(new Recepy("Ensalada de salmon y espinacas", "Ensalada de hojas de espinacas frescas con salmon a la parrilla, aguacate, tomates cherry y aderezo de mostaza y miel.", "1. Prepara el aderezo mezclando mostaza, miel, vinagre balsamico, sal y pimienta en un tazon. 2. Lava y corta las espinacas y los tomates. 3. Asa el salmon en una sarten con aceite de oliva. 4. En un plato, coloca las espinacas, agrega el salmon, el aguacate y los tomates. 5. Rocia el aderezo sobre la ensalada.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pollo al limon y perejil", "Pechugas de pollo con un sabor fresco de limon y perejil, cocidas en el horno.", "1. Precalienta el horno a 190°C. 2. En un tazon, mezcla el jugo de limon, el aceite de oliva, el ajo, la sal y el perejil. 3. Coloca las pechugas de pollo en una fuente para hornear. 4. Vierte la mezcla de limon y perejil sobre las pechugas. 5. Hornea durante 25 minutos o hasta que esten bien cocidas.", "Dinner"));
        this.recepyRepository.save(new Recepy("Sopa de calabaza", "Sopa cremosa de calabaza con un toque de jengibre y canela.", "1. En una olla grande, sofrie la cebolla en aceite de oliva hasta que este dorada. 2. Agrega la calabaza cortada en cubos, el jengibre y la canela. 3. Cubre los ingredientes con caldo de pollo y lleva a ebullicion. 4. Reduce el fuego y deja cocinar a fuego lento durante 20 minutos. 5. Licua la sopa con una batidora de inmersion hasta que quede suave y cremosa. 6. Sirve caliente.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pasta con salsa de tomate y albahaca", "Fideos de pasta con salsa de tomate y albahaca fresca.", "1. Cocina la pasta en agua con sal hasta que este al dente. 2. En una sarten grande, sofrie ajo en aceite de oliva hasta que este dorado. 3. Agrega tomates en cubos y cocine a fuego lento durante 10 minutos. 4. Agrega albahaca fresca picada y sal. 5. Escurre la pasta y agregala a la sarten. 6. Mezcla la pasta con la salsa de tomate.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pollo asado con verduras", "Delicioso pollo asado con zanahorias, papas y cebolla", "1. Precalentar el horno a 200°C.\n2. En una bandeja para hornear, colocar las piezas de pollo y agregar las verduras.\n3. Salpimentar y agregar un poco de aceite de oliva.\n4. Hornear por 45 minutos o hasta que el pollo este dorado.", "Dinner"));
        this.recepyRepository.save(new Recepy("Sopa de pollo y verduras", "Sopa caliente de pollo con zanahorias, apio y cebolla", "1. Cocer el pollo en agua con sal y retirarlo del caldo.\n2. Agregar las verduras cortadas en cubos y cocinar por unos minutos.\n3. Agregar el pollo deshebrado y cocinar por 10 minutos mas.\n4. Servir caliente.", "Dinner"));
        this.recepyRepository.save(new Recepy("Espaguetis a la bolonesa", "Espaguetis con salsa de carne, tomate y cebolla", "1. Cocinar la pasta al dente en agua con sal.\n2. En una sarten, dorar la carne con cebolla y ajo.\n3. Agregar el tomate pelado y picado.\n4. Cocinar a fuego lento por 15 minutos.\n5. Servir sobre los espaguetis y espolvorear con queso rallado.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pescado al horno con ensalada", "Filetes de pescado horneados con ensalada fresca", "1. Precalentar el horno a 180°C.\n2. Colocar los filetes de pescado en una bandeja para hornear.\n3. Salpimentar y rociar con aceite de oliva.\n4. Hornear por 20 minutos.\n5. Servir con ensalada fresca.", "Dinner"));
        this.recepyRepository.save(new Recepy("Lasana de verduras", "Deliciosa lasana vegetariana con berenjenas, calabacines y tomate", "1. Cocinar las berenjenas y calabacines a la parrilla.\n2. En una sarten, cocinar el tomate con ajo y cebolla.\n3. En un molde para hornear, colocar una capa de berenjenas, luego una de calabacines y otra de tomate.\n4. Repetir el proceso hasta que se terminen los ingredientes.\n5. Cubrir con queso y hornear por 30 minutos.", "Dinner"));

        //Diet
        Triplet arrayObjetos[] = new Triplet[7];

        for (int i = 0; i < arrayObjetos.length; i++) {
            //Indicamos cada uno de los parametros del objeto
            String Breakfast = "Huevos";

            String Lunch = "Mas huevos";

            String Dinner = "Huevos otra vez si";

            arrayObjetos[i] = new Triplet(Breakfast, Lunch, Dinner);
        }

        this.dietRepository.save(new Diet("Bulking", arrayObjetos, "Bulking"));

        this.dietRepository.save(new Diet("Definition", arrayObjetos, "Cutting"));


    }
    public void setUserImage(User user, String classpathResource) throws IOException {
        Resource image = new ClassPathResource(classpathResource);
        user.setImage("Default");
        user.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }

}
