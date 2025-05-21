package Unidad9.PuebloDuerme;

import java.util.*;

public final class Humano extends Ciudadano implements CicloVital{

    // Atributos de clase
    private static int totalHumanos = 0;
    private static int ultimoHumano = 0;
    private static final Random ALEATORIO = new Random();

    // Atributos de instancia
    private final Vulnerable VULNERABLE = Vulnerable.VAMPIRO;
    private int vida;

    // Constructor
    public Humano() {
        super("HUMANO" + (++ultimoHumano));
        this.vida = ALEATORIO.nextInt(VITALIDAD_MAXIMA) + 1;
        totalHumanos++;
    }

    // Devuelve el número total de humanos
    public static int getPoblacion() {
        return totalHumanos;
    }

    // Actualiza el número total de humanos
    public static void setPoblacion(int poblacion) {
        totalHumanos = poblacion;
    }

    // Realiza una batalla con un oponente y devuelve el perdedor
    @Override
    public Ciudadano combate(Ciudadano oponente) {
        System.out.println(this.getNombre() + " lucha contra " + oponente.getNombre());

        // Si el oponente es un vampiro, el humano es vulnerable
        if (oponente.getVulnerable() == Vulnerable.HUMANO) {
            System.out.println(this.getNombre() + " ha perdido contra " + oponente.getNombre());
            return this;
        } else {
            System.out.println(this.getNombre() + " ha ganado contra " + oponente.getNombre());
        }
        return oponente;
    }

    // Genera la reproducción con un número aleatorio de hijos
    @Override
    public void reproducir(ArrayList<Ciudadano> ciudadanos) {
        int numHijos = ALEATORIO.nextInt(NATALIDAD_MAXIMA) + 1;
        System.out.println(this.getNombre() + " se reproduce y tiene " + numHijos + " hijo(s)");

        for (int i = 0; i < numHijos; i++) {
            ciudadanos.add(new Humano());
        }
    }

    // Crea el comportamiento cuando un humano muere
    @Override
    public void morir(ArrayList<Ciudadano> ciudadanos) {
        System.out.println(this.getNombre() + " ha muerto");
        ciudadanos.remove(this);
        totalHumanos--;
        Ciudadano.setPoblacion(Ciudadano.getPoblacion() - 1);
    }

    // Reduce la vida de un humano uno por uno y lo mata si la vida llega a cero
    @Override
    public void envejecer(ArrayList<Ciudadano> ciudadanos) {
        vida--;
        System.out.println(this.getNombre() + " ha envejecido y ahora tiene " + vida + " año(s) de vida restante");

        if (vida <= 0) {
            System.out.println(this.getNombre() + " muere de vejez");
            morir(ciudadanos);
        }
    }

    // Devuelve el tipo de vulnerabilidad del humano
    @Override
    public Vulnerable getVulnerable() {
        return VULNERABLE;
    }

    // Devuelve una representación en cadena del humano
    @Override
    public String toString() {
        return super.toString() + " - Tipo: " + getClass().getSimpleName() +  ", Vida: " + vida + ", Vulnerable a: " + VULNERABLE;
    }
}