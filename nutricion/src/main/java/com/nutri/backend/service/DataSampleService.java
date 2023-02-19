package com.nutri.backend.service;


import com.nutri.backend.model.Recepy;
import com.nutri.backend.repositories.RecepyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class DataSampleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RecepyRepository recepyRepository;

    @PostConstruct
    public void init() {
        //Admin
        this.userRepository.save(new User("ejemplo@yahoo.es",passwordEncoder.encode("1234")));

        //Workers
        User[] workers = {
                new User("Adrian", "Garcia", "adrian.garcia@example.com", "Expert", passwordEncoder.encode("Password1")),
                new User("Laura", "Martínez", "laura.martinez@example.com", "Beginner", passwordEncoder.encode("Password2")),
                new User("Carlos", "Fernández", "carlos.fernandez@example.com", "Intermediate", passwordEncoder.encode("Password3")),
                new User("Lucía", "Sánchez", "lucia.sanchez@example.com", "Expert", passwordEncoder.encode("Password4")),
                new User("Pedro", "Gómez", "pedro.gomez@example.com", "Intermediate", passwordEncoder.encode("Password5"))
        };

        for (User usuario : workers) {
            userRepository.save(usuario);
        }

        //Usuarios
        User[] usuarios = {
                new User("Adrian", "Pena", "ejemploclient@yahoo.es", passwordEncoder.encode("1234")),
                new User("Juan", "Pérez", "juan.perez@example.com", passwordEncoder.encode("Password1")),
                new User("María", "García", "maria.garcia@example.com", passwordEncoder.encode("Password2")),
                new User("Pedro", "Sánchez", "pedro.sanchez@example.com", passwordEncoder.encode("Password3")),
                new User("Ana", "Martínez", "ana.martinez@example.com", passwordEncoder.encode("Password4")),
                new User("Luis", "Rodríguez", "luis.rodriguez@example.com", passwordEncoder.encode("Password5")),
                new User("Elena", "Fernández", "elena.fernandez@example.com", passwordEncoder.encode("Password6")),
                new User("Pablo", "Gómez", "pablo.gomez@example.com", passwordEncoder.encode("Password7")),
                new User("Carmen", "López", "carmen.lopez@example.com", passwordEncoder.encode("Password8")),
                new User("Miguel", "Torres", "miguel.torres@example.com", passwordEncoder.encode("Password9")),
                new User("Isabel", "Navarro", "isabel.navarro@example.com", passwordEncoder.encode("Password10"))
        };

        for (User usuario : usuarios) {
            userRepository.save(usuario);
        }

        //Recetas desayuno
        this.recepyRepository.save(new Recepy("Huevos revueltos con aguacate", "Huevos revueltos con aguacate y tostadas", "1. Batir los huevos en un tazón.\n2. Calentar una sartén y añadir los huevos batidos.\n3. Revolver los huevos hasta que estén cocidos.\n4. Cortar el aguacate en cubos.\n5. Servir los huevos revueltos con aguacate y tostadas.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Tostadas francesas con frutas", "Tostadas francesas con frutas frescas y miel", "1. Batir los huevos con leche en un tazón.\n2. Sumergir las rebanadas de pan en la mezcla de huevo y leche.\n3. Calentar una sartén y dorar las rebanadas de pan.\n4. Cortar las frutas en cubos.\n5. Servir las tostadas francesas con las frutas frescas y la miel.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Batido de frutas con avena", "Batido de frutas con avena y yogur", "1. Cortar las frutas en cubos.\n2. Añadir las frutas, la avena y el yogur en una licuadora.\n3. Licuar todos los ingredientes hasta obtener una mezcla suave.\n4. Servir el batido de frutas con avena y yogur.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Tortilla de champiñones y espinacas", "Tortilla de champiñones y espinacas con queso y pan tostado", "1. Saltear los champiñones y las espinacas en una sartén.\n2. Batir los huevos en un tazón.\n3. Añadir los champiñones y espinacas a los huevos batidos.\n4. Calentar una sartén y verter la mezcla de huevo y verduras.\n5. Añadir el queso rallado por encima.\n6. Servir la tortilla de champiñones y espinacas con pan tostado.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Waffles con tocino y huevo", "Waffles con tocino, huevo frito y sirope de arce", "1. Cocinar el tocino y reservar.\n2. Batir los huevos en un tazón y hacer un huevo frito.\n3. Calentar la plancha de waffles y cocinar los waffles.\n4. Servir los waffles con el tocino, el huevo frito y el sirope de arce.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Huevos revueltos con tocino", "Huevos revueltos con tocino, cebolla y queso", "1. Cocinar el tocino y dejar escurrir sobre papel absorbente.\n2. Batir los huevos con sal y pimienta.\n3. Saltear la cebolla hasta que esté dorada.\n4. Agregar los huevos a la sartén y revolver constantemente.\n5. Cuando los huevos estén casi listos, añadir el tocino y el queso.\n6. Servir caliente.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Tostadas francesas", "Tostadas francesas con canela y azúcar glass", "1. Batir los huevos con leche, canela y azúcar.\n2. Remojar el pan en la mezcla de huevo.\n3. Cocinar las tostadas en una sartén con mantequilla hasta que estén doradas.\n4. Espolvorear azúcar glass sobre las tostadas.\n5. Servir caliente.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Hotcakes con frutas", "Hotcakes con frutas frescas y miel", "1. Mezclar la harina, la sal, el polvo para hornear y el azúcar.\n2. Batir los huevos con la leche y la vainilla.\n3. Agregar la mezcla de harina a los huevos y mezclar bien.\n4. Cocinar los hotcakes en una sartén con mantequilla hasta que estén dorados.\n5. Servir los hotcakes con frutas frescas y miel.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Yogurt con granola", "Yogurt natural con granola, frutas y miel", "1. Mezclar el yogurt con miel.\n2. Agregar la granola y las frutas.\n3. Servir frío.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Huevos Benedict", "Huevos Benedict con jamón y salsa holandesa", "1. Cocinar el jamón y dejar escurrir sobre papel absorbente.\n2. Preparar la salsa holandesa batiendo y calentando mantequilla, yemas de huevo y jugo de limón.\n3. Cocinar los huevos pochados.\n4. Tostar el pan y colocar el jamón y los huevos encima.\n5. Agregar la salsa holandesa sobre los huevos.\n6. Servir caliente.", "Breakfast"));
        this.recepyRepository.save(new Recepy("Batido de frutas", "Batido de frutas con leche y miel", "1. Mezclar las frutas con la leche y la miel en la licuadora.\n2. Licuar hasta que esté suave.\n3. Servir frío.", "Breakfast"));

        //Recetas Comida
        this.recepyRepository.save(new Recepy("Ensalada César con pollo", "Ensalada de lechuga romana, pollo, queso parmesano y crutones", "1. Cocinar la pechuga de pollo y cortarla en tiras.\n2. Mezclar la lechuga con el aderezo César, queso parmesano y crutones.\n3. Añadir las tiras de pollo y servir.", "Lunch"));
        this.recepyRepository.save(new Recepy("Tacos de carne asada", "Tacos de carne asada con cebolla, cilantro y limón", "1. Marinar la carne con sal, pimienta y jugo de limón.\n2. Cocinar la carne a la parrilla hasta que esté dorada.\n3. Cortar la carne en tiras y servir en tortillas de maíz con cebolla y cilantro.", "Lunch"));
        this.recepyRepository.save(new Recepy("Pasta Alfredo con pollo", "Pasta con salsa Alfredo y pollo", "1. Cocinar la pasta siguiendo las instrucciones del paquete.\n2. Cortar la pechuga de pollo en cubos y cocinar en una sartén.\n3. Mezclar la pasta con la salsa Alfredo y agregar el pollo.\n4. Servir caliente.", "Lunch"));
        this.recepyRepository.save(new Recepy("Ensalada de pollo y aguacate", "Ensalada de pollo, aguacate, tomate y lechuga", "1. Cocinar la pechuga de pollo y cortar en cubos.\n2. Mezclar la lechuga con el pollo, aguacate y tomate.\n3. Aliñar con aceite de oliva y jugo de limón.\n4. Servir frío.", "Lunch"));
        this.recepyRepository.save(new Recepy("Pechuga de pollo a la plancha", "Pechuga de pollo a la plancha con arroz y verduras", "1. Cocinar la pechuga de pollo a la plancha con sal y pimienta.\n2. Cocinar arroz y verduras al vapor.\n3. Servir la pechuga de pollo junto con el arroz y las verduras.", "Lunch"));
        this.recepyRepository.save(new Recepy("Wrap de pollo y queso", "Wrap de tortilla de trigo con pollo, queso cheddar y aguacate", "1. Cocinar la pechuga de pollo y cortar en tiras.\n2. Colocar el pollo, queso cheddar y aguacate sobre la tortilla de trigo.\n3. Enrollar el wrap y calentar en una sartén.\n4. Servir caliente.", "Lunch"));
        this.recepyRepository.save(new Recepy("Pollo a la parrilla con ensalada de tomate", "Pechuga de pollo a la parrilla con ensalada de tomate, cebolla y pepino", "1. Marinar la pechuga de pollo en aceite de oliva, sal y pimienta.\n2. Cocinar el pollo a la parrilla hasta que esté dorado.\n3. Cortar los tomates, la cebolla y el pepino en cubos.\n4. Mezclar los vegetales con aceite de oliva, sal y pimienta.\n5. Servir el pollo con la ensalada de tomate.", "Lunch"));
        this.recepyRepository.save(new Recepy("Ensalada de quinoa con pollo", "Ensalada de quinoa con pollo, aguacate y tomate cherry", "1. Cocinar la quinoa y dejar enfriar.\n2. Cocinar la pechuga de pollo y cortarla en tiras.\n3. Cortar el aguacate y los tomates cherry en cubos.\n4. Mezclar la quinoa con el pollo, aguacate, tomate y aderezo de limón y cilantro.\n5. Servir la ensalada de quinoa con pollo.", "Lunch"));
        this.recepyRepository.save(new Recepy("Arroz frito con camarones", "Arroz frito con camarones, guisantes y zanahoria", "1. Cocinar el arroz y dejar enfriar.\n2. Pelar y desvenar los camarones.\n3. Saltear los camarones con guisantes y zanahoria en una sartén.\n4. Añadir el arroz y mezclar todo junto.\n5. Servir caliente.", "Lunch"));
        this.recepyRepository.save(new Recepy("Hamburguesa de pollo con aguacate", "Hamburguesa de pollo con aguacate, queso y cebolla caramelizada", "1. Cocinar la hamburguesa de pollo a la parrilla.\n2. Cortar el aguacate en rodajas.\n3. Saltear la cebolla hasta que esté caramelizada.\n4. Añadir el queso sobre la hamburguesa de pollo y dejar que se derrita.\n5. Colocar la hamburguesa de pollo sobre el pan y añadir las rodajas de aguacate y la cebolla caramelizada.\n6. Servir caliente.", "Lunch"));

        //Recetas Dinner
        this.recepyRepository.save(new Recepy("Ensalada de salmón y espinacas", "Ensalada de hojas de espinacas frescas con salmón a la parrilla, aguacate, tomates cherry y aderezo de mostaza y miel.", "1. Prepara el aderezo mezclando mostaza, miel, vinagre balsámico, sal y pimienta en un tazón. 2. Lava y corta las espinacas y los tomates. 3. Asa el salmón en una sartén con aceite de oliva. 4. En un plato, coloca las espinacas, agrega el salmón, el aguacate y los tomates. 5. Rocía el aderezo sobre la ensalada.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pollo al limón y perejil", "Pechugas de pollo con un sabor fresco de limón y perejil, cocidas en el horno.", "1. Precalienta el horno a 190°C. 2. En un tazón, mezcla el jugo de limón, el aceite de oliva, el ajo, la sal y el perejil. 3. Coloca las pechugas de pollo en una fuente para hornear. 4. Vierte la mezcla de limón y perejil sobre las pechugas. 5. Hornea durante 25 minutos o hasta que estén bien cocidas.", "Dinner"));
        this.recepyRepository.save(new Recepy("Sopa de calabaza", "Sopa cremosa de calabaza con un toque de jengibre y canela.", "1. En una olla grande, sofríe la cebolla en aceite de oliva hasta que esté dorada. 2. Agrega la calabaza cortada en cubos, el jengibre y la canela. 3. Cubre los ingredientes con caldo de pollo y lleva a ebullición. 4. Reduce el fuego y deja cocinar a fuego lento durante 20 minutos. 5. Licua la sopa con una batidora de inmersión hasta que quede suave y cremosa. 6. Sirve caliente.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pasta con salsa de tomate y albahaca", "Fideos de pasta con salsa de tomate y albahaca fresca.", "1. Cocina la pasta en agua con sal hasta que esté al dente. 2. En una sartén grande, sofríe ajo en aceite de oliva hasta que esté dorado. 3. Agrega tomates en cubos y cocine a fuego lento durante 10 minutos. 4. Agrega albahaca fresca picada y sal. 5. Escurre la pasta y agrégala a la sartén. 6. Mezcla la pasta con la salsa de tomate.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pollo asado con verduras", "Delicioso pollo asado con zanahorias, papas y cebolla", "1. Precalentar el horno a 200°C.\n2. En una bandeja para hornear, colocar las piezas de pollo y agregar las verduras.\n3. Salpimentar y agregar un poco de aceite de oliva.\n4. Hornear por 45 minutos o hasta que el pollo esté dorado.", "Dinner"));
        this.recepyRepository.save(new Recepy("Sopa de pollo y verduras", "Sopa caliente de pollo con zanahorias, apio y cebolla", "1. Cocer el pollo en agua con sal y retirarlo del caldo.\n2. Agregar las verduras cortadas en cubos y cocinar por unos minutos.\n3. Agregar el pollo deshebrado y cocinar por 10 minutos más.\n4. Servir caliente.", "Dinner"));
        this.recepyRepository.save(new Recepy("Espaguetis a la boloñesa", "Espaguetis con salsa de carne, tomate y cebolla", "1. Cocinar la pasta al dente en agua con sal.\n2. En una sartén, dorar la carne con cebolla y ajo.\n3. Agregar el tomate pelado y picado.\n4. Cocinar a fuego lento por 15 minutos.\n5. Servir sobre los espaguetis y espolvorear con queso rallado.", "Dinner"));
        this.recepyRepository.save(new Recepy("Pescado al horno con ensalada", "Filetes de pescado horneados con ensalada fresca", "1. Precalentar el horno a 180°C.\n2. Colocar los filetes de pescado en una bandeja para hornear.\n3. Salpimentar y rociar con aceite de oliva.\n4. Hornear por 20 minutos.\n5. Servir con ensalada fresca.", "Dinner"));
        this.recepyRepository.save(new Recepy("Lasaña de verduras", "Deliciosa lasaña vegetariana con berenjenas, calabacines y tomate", "1. Cocinar las berenjenas y calabacines a la parrilla.\n2. En una sartén, cocinar el tomate con ajo y cebolla.\n3. En un molde para hornear, colocar una capa de berenjenas, luego una de calabacines y otra de tomate.\n4. Repetir el proceso hasta que se terminen los ingredientes.\n5. Cubrir con queso y hornear por 30 minutos.", "Dinner"));

        //Diet


    }

}
