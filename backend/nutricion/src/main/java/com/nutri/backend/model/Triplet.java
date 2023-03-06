package com.nutri.backend.model;

import java.io.Serializable;

// clase triplete
public class Triplet<String> implements Serializable
{
    public String Breakfast;       // el primer campo de un triplete
    public String Lunch;      // el segundo campo de un triplete
    public String Dinner;       // el tercer campo de un triplete

    // Construye un nuevo triplete con los valores dados
    public Triplet(String Breakfast, String Lunch, String Dinner)
    {
        this.Breakfast = Breakfast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;
    }

    @Override
    public boolean equals(Object o)
    {
        /* Comprueba que el objeto especificado es "igual" al objeto actual o no */

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triplet triplet = (Triplet) o;

        // llamar al método `equals()` de los objetos subyacentes
        if (!Breakfast.equals(triplet.Breakfast) ||
                !Lunch.equals(triplet.Lunch) ||
                !Dinner.equals(triplet.Dinner)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        /* Calcula el código hash de un objeto mediante el uso de códigos hash de
        los objetos subyacentes */

        int result = Breakfast.hashCode();
        result = 31 * result + Lunch.hashCode();
        result = 31 * result + Dinner.hashCode();
        return result;
    }

    @Override
    public java.lang.String toString() {
        return "(" + Breakfast + ", " + Lunch + ", " + Dinner + ")";
    }

    // Método de fábrica para crear una instancia inmutable tipificada de triplete
    public static <String> Triplet <String> of(String Breakfast, String Lunch, String Dinner) {
        return new Triplet <>(Breakfast, Lunch, Dinner);
    }
}
