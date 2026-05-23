package taller.test;

import taller.clases.Pelicula;

import java.util.*;

public class Main {
    String[] generos = {"Fantasia", "Accion", "Terror", "Ciencia Ficcion"};
    List<Pelicula> peliculas = new ArrayList<Pelicula>();

    //•	Evita que se agreguen películas repetidas gracias a HashSet.
    Set<Pelicula> peliculasUnicas = new HashSet<Pelicula>(peliculas);

    //Cada género tiene una lista de películas almacenadas en un Map<String, List<Pelicula>>.
    Map<String, List<Pelicula>> listaPelisPorGenero = new HashMap<String, List<Pelicula>>();
    Scanner sc = new Scanner(System.in);

//    • Ordena las películas por duración dentro de List.
    public void ordenarPeliculaPorDuracion(List<Pelicula> lista){
        lista.sort(Comparator.comparingDouble(Pelicula::getDuracion));
    }

//    • Permite a los usuarios agregar nuevas películas dinámicamente con Scanner.
    public void agregarPelicula(){

    }

//    • Agrega funcionalidad para buscar una película dentro de List, Set y Map.
    public void buscarPelicula(){

    }

    public void listarPeliculas(){

    }

    public void mostrarMenu(){
        int opc = -1;
        while (opc!=0){
            System.out.println("Ingrese 1 para listar las peliculas");
            System.out.println("Ingrese 2 para buscar una pelicula");
            System.out.println("Ingrese 3 para agregar una pelicula");
            System.out.println("Ingrese 4 para");
            System.out.println("Ingrese 0 para salir: ");

            try {
                opc = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            switch (opc){
                case 1:
                    listarPeliculas();
                    break;
                case 2:
                    buscarPelicula();
                    break;
                case 3:
                    agregarPelicula();
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Gracias por usarnos.");
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida.");
                    break;
            }

        }
    }

    public void inicializarListaPeliculas(){
        peliculas.add(new Pelicula("Tiburon", "Pedro", generos[3], 2.3));
        peliculas.add(new Pelicula("El Hoyo", "Juan", generos[2], 1.5));
        peliculas.add(new Pelicula("Sharknado", "Henry", generos[1], 2));
        peliculas.add(new Pelicula("Bambi", "Disney", generos[0], 1.3));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.inicializarListaPeliculas();
        for(String genero:main.generos) main.listaPelisPorGenero.put(genero, new ArrayList<>());

//        for(String genero:main.listaPelisPorGenero.keySet()){
//
//        }
        main.mostrarMenu();


//    • Agrega un TreeSet para ordenar las películas por nombre.

    }
}
