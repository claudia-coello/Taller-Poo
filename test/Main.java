package taller.test;

import taller.clases.Pelicula;

import java.util.*;

public class Main {
    String[] generos = {"Fantasia", "Accion", "Terror", "Ciencia Ficcion"};
    List<Pelicula> peliculas = new ArrayList<Pelicula>();

    //•	Evita que se agreguen películas repetidas gracias a HashSet.
    Set<Pelicula> peliculasUnicas = new HashSet<Pelicula>();

    //Cada género tiene una lista de películas almacenadas en un Map<String, List<Pelicula>>.
    Map<String, List<Pelicula>> listaPelisPorGenero = new HashMap<String, List<Pelicula>>();

//    • Agrega un TreeSet para ordenar las películas por nombre.
    Set<Pelicula> peliculasOrdenadas = new TreeSet<>(Comparator.comparing(Pelicula::getNombre));

    Scanner sc = new Scanner(System.in);

//    • Ordena las películas por duración dentro de List.
    public void ordenarPeliculaPorDuracion(List<Pelicula> lista){

    }

//    • Permite a los usuarios agregar nuevas películas dinámicamente con Scanner.
    public void agregarPelicula(Pelicula pelicula){
        if (peliculasUnicas.contains(pelicula)) System.out.println("Esa pelicula ya existe. Intentelo nuevamente");
        else {
            peliculasUnicas.add(pelicula);

            peliculas.add(pelicula);
            peliculas.sort(Comparator.comparingDouble(Pelicula::getDuracion));

            peliculasOrdenadas.add(pelicula);
            listaPelisPorGenero.computeIfAbsent(pelicula.getGenero(),k -> new ArrayList<>()).add(pelicula);
        }
    }

//    • Agrega funcionalidad para buscar una película dentro de List, Set y Map.
    public void buscarPelicula(String pelicula){

    }

    /**
     * Lista las peliculas por su duracion(list)
     */
    public void listarPeliculaDuracion(){
        for (Pelicula pelicula:peliculas){
            System.out.println("Duracion: " + pelicula.getDuracion() + "\t\tNombre: " + pelicula.getNombre());
        }
    }

    /**
     * Lista las peliculas por su nombre(hash)
     */
    public void listarPeliculaNombre(){

    }

    /**
     * Lista las peliculas por genero(map)
     */
    public void listarPeliculaGenero(){
        for (String genero:listaPelisPorGenero.keySet()){
            System.out.println("\n---Genero: " + genero + "---");
            System.out.println("Peliculas: \n" + listaPelisPorGenero.get(genero));
        }
    }

    public void mostrarMenu(){
        int opc = -1;
        while (opc!=0){
            System.out.println("\t\t-----BIENVENIDO----");
            System.out.println("1. Listar peliculas");
            System.out.println("2. Buscar una pelicula");
            System.out.println("3. Agregar una pelicula");
            System.out.println("0. Salir: ");

            try {
                opc = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            switch (opc){
                case 1:
                    System.out.println("----Listar en orden segun----");
                    System.out.println("1. Nombre");
                    System.out.println("2. Duracion");
                    System.out.println("3. Genero");
                    System.out.println("Opcion: ");

                    switch (sc.nextInt()){
                        case 1:
                            listarPeliculaNombre();
                            break;
                        case 2:
                            listarPeliculaDuracion();
                            break;
                        case 3:
                            listarPeliculaGenero();
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                    break;
                case 2:
                    buscarPelicula("");
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la pelicula");
                    System.out.println("Ingrese el nombre del director de la pelicula");
                    System.out.println("Ingrese el genero de la pelicula");
                    System.out.println("Ingrese la duracion de la pelicula");
                    agregarPelicula(new Pelicula("", "", "", 2));
                    break;
                case 0:
                    System.out.println("Gracias por preferirnos.");
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida.");
                    break;
            }

        }
    }

    public void inicializarListaPeliculas(){
        agregarPelicula(new Pelicula("Tiburon", "Pedro", generos[3], 2.3));
        agregarPelicula(new Pelicula("El Hoyo", "Juan", generos[2], 1.5));
        agregarPelicula(new Pelicula("Sharknado", "Henry", generos[1], 2));
        agregarPelicula(new Pelicula("Bambi", "Disney", generos[0], 1.3));
        agregarPelicula(new Pelicula("Bambi", "Disney", generos[0], 1.3));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.inicializarListaPeliculas();
        main.mostrarMenu();
    }
}
