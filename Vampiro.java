package Unidad9.PuebloDuerme;
import java.util.ArrayList;

// Clase que representa a un Vampiro en el pueblo dormido
public final class Vampiro extends Ciudadano {

    // Atributos de clase
    private static int totalVampiros = 0;
    private static int ultimoVampiro = 0;

    // Atributos de instancia
    private final Vulnerable VULNERABLE = Vulnerable.LOBO;

    // Constructor
    public Vampiro() {
        super("VAMPIRO" + (++ultimoVampiro));
        totalVampiros++;
    }

    // Devuelve el número total de vampiros
    public static int getPoblacion() {
        return totalVampiros;
    }

    // Actualiza el número total de vampiros
    public static void setPoblacion(int poblacion) {
        totalVampiros = poblacion;
    }

    @Override
    public Vulnerable getVulnerable() {
        return null;
    }

    @Override
    public void morir(ArrayList<Ciudadano> ciudadanos) {

    }

    @Override
    public Ciudadano combate(Ciudadano oponente) {
        return null;
    }
}