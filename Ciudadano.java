package Unidad9.PuebloDuerme;
import java.util.ArrayList;

public abstract class Ciudadano implements Batalla{

    private static int poblacion = 0;
    private String nombre;

    public Ciudadano(String nombre) {
        this.nombre = nombre;
        poblacion++;
    }

    // Metodo de clase que devuelve el número total de ciudadanos
    public static int getPoblacion() {
        return poblacion;
    }

    // Metodo de clase que actualiza el número total de ciudadanos
    public static void setPoblacion(int numero) {
        poblacion = numero;
    }

    // Devuelve el nombre del ciudadano
    public String getNombre() {
        return nombre;
    }

    // Actualiza el nombre del ciudadano
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el tipo de vulnerabilidad del humano
    public abstract Vulnerable getVulnerable();

    // Devuelve una representación en cadena del ciudadano
    @Override
    public String toString() {
        return "Nombre del ciudadano: " + nombre;
    }

    // Imprime el censo total de ciudadanos, humanos, lobos y vampiros
    public static void poblacionesTotales(ArrayList<Ciudadano> ciudadanos) {
        System.out.println("==== POBLACIÓN TOTAL ====");
        System.out.println("Total de ciudadanos: " + poblacion);
        System.out.println("Total de humanos: " + Humano.getPoblacion());
        System.out.println("Total de lobos: " + Lobo.getPoblacion());
        System.out.println("Total de vampiros: " + Vampiro.getPoblacion());
    }

    // Imprime el censo de ciudadanos y las poblaciones totales
    public static void censar(ArrayList<Ciudadano> ciudadanos) {
        System.out.println("==== CENSO DE CIUDADANOS ====");
        for (Ciudadano censo : ciudadanos) {
            System.out.println(censo);
        }
    }

    // Metodo abstracto que define el comportamiento cuando un ciudadano muere
    public abstract void morir(ArrayList<Ciudadano> ciudadanos);
}