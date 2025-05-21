package Unidad9.PuebloDuerme;

import java.util.ArrayList;
import java.util.Random;

// Clase que representa a un Lobo en el pueblo dormido
public final class Lobo extends Ciudadano implements CicloVital{

    // Atributos de clase
    private static int totalLobos = 0;
    private static int ultimoLobo = 0;
    private static final Random ALEATORIO = new Random();

    // Atributos de instancia
    private final Vulnerable VULNERABLE = Vulnerable.HUMANO;
    private int vida;

    // Constructor
    public Lobo() {
        super("LOBO" + (++ultimoLobo));
        // La vida del lobo es el doble de la VITALIDAD_MAXIMA (aleatoria)
        this.vida = ALEATORIO.nextInt(VITALIDAD_MAXIMA * 2) + 1;
        totalLobos++;
    }

    // Devuelve el número total de lobos
    public static int getPoblacion() {
        return totalLobos;
    }

    // Actualiza el número total de lobos
    public static void setPoblacion(int numero) {
        totalLobos = numero;
    }

    // Realiza una batalla con un oponente y devuelve el perdedor
    @Override
    public Ciudadano combate(Ciudadano oponente) {
        System.out.println(this.getNombre() + " lucha contra " + oponente.getNombre());

        // Si el oponente es un humano, el lobo es vulnerable
        if (oponente.getVulnerable() == Vulnerable.LOBO) {
            System.out.println(this.getNombre() + " ha perdido contra " + oponente.getNombre());
            return this;
        } else {
            System.out.println(this.getNombre() + " ha ganado contra " + oponente.getNombre());
            return oponente;
        }
    }

    // Produce una reproducción con un número aleatorio de cachorros
    @Override
    public void reproducir(ArrayList<Ciudadano> ciudadanos) {
        // El doble de NATALIDAD_MAXIMA para los lobos
        int numCachorros = ALEATORIO.nextInt(NATALIDAD_MAXIMA * 2) + 1;
        System.out.println(this.getNombre() + " se reproduce y tiene " + numCachorros + " cachorro(s)");

        for (int i = 0; i < numCachorros; i++) {
            ciudadanos.add(new Lobo());
        }
    }

    // Indica el comportamiento de cuando un lobo muere
    @Override
    public void morir(ArrayList<Ciudadano> ciudadanos) {
        System.out.println(this.getNombre() + " ha muerto");
        ciudadanos.remove(this);
        totalLobos--;
        Ciudadano.setPoblacion(Ciudadano.getPoblacion() - 1);
    }

    // El tiempo pasa más deprisa para los caninos
    @Override
    public void envejecer(ArrayList<Ciudadano> ciudadanos) {
        // La vida de un lobo se reduce el doble rápido que la de un humano
        vida -= 2;
        System.out.println(this.getNombre() + " ahora tiene " + vida + " año(s) de vida restante");

        if (vida <= 0) {
            System.out.println(this.getNombre() + " muere de vejez");
            morir(ciudadanos);
        }
    }

    // Devuelve el tipo de vulnerabilidad del lobo
    @Override
    public Vulnerable getVulnerable() {
        return VULNERABLE;
    }

    // Devuelve una representación en cadena del lobo
    @Override
    public String toString() {
        return super.toString() + " - Tipo: Lobo, Vida: " + vida + ", Vulnerable a: " + VULNERABLE;
    }
}