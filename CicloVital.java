package Unidad9.PuebloDuerme;

import java.util.ArrayList;

// Interfaz que define los métodos y constantes relacionados con el ciclo vital de los seres vivos
public interface CicloVital {

    // Constantes para la natalidad y vitalidad máximas
    int NATALIDAD_MAXIMA = 1;    // Cada ser vivo puede tener un hijo como máximo
    int VITALIDAD_MAXIMA = 2;    // La esperanza de vida máxima para un ser vivo es de dos años

    // Permite que los seres vivos generen nuevos ciudadanos de su tipo
    void reproducir(ArrayList<Ciudadano> ciudadanos);

    // Reduce la vida del ser vivo en un año cada vez que se ejecute
    void envejecer(ArrayList<Ciudadano> ciudadanos);
}