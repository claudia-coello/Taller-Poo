package taller.clases;

import java.util.*;

public class CrudPeliculas {
    private String[] generos = {"Fantasia", "Accion", "Terror", "Ciencia Ficcion"};
    private List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

    //•	Evita que se agreguen películas repetidas gracias a HashSet.
    private Set<Pelicula> hashPeliculas = new HashSet<Pelicula>();

    //Cada género tiene una lista de películas almacenadas en un Map<String, List<Pelicula>>.
    private Map<String, List<Pelicula>> mapPeliculas = new HashMap<String, List<Pelicula>>();

//    • Agrega un TreeSet para ordenar las películas por nombre.
    private Set<Pelicula> treePeliculas = new TreeSet<>(Comparator.comparing(Pelicula::getNombre));

    private Scanner sc = new Scanner(System.in);

    public void agregarPelicula(Pelicula pelicula){
        if (pelicula == null) System.out.println("Por favor llene las informacion correspondiente");
        if (hashPeliculas.contains(pelicula)) System.out.println("Esa pelicula ya existe. Intentelo nuevamente");
        else {
            hashPeliculas.add(pelicula);

            listaPeliculas.add(pelicula);
//    • Ordena las películas por duración dentro de List.
            listaPeliculas.sort(Comparator.comparingDouble(Pelicula::getDuracion));

            treePeliculas.add(pelicula);
            mapPeliculas.computeIfAbsent(pelicula.getGenero(), k -> new ArrayList<>()).add(pelicula);
        }
    }

//    • Agrega funcionalidad para buscar una película dentro de List, Set y Map.
    public Pelicula buscarPeliculaLista(String nombre) {
        for (Pelicula p : listaPeliculas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrada en List: " + p);
                return p;
            }
        }
        System.out.println("No encontrada en List");
        return null;
    }
    public void buscarPeliculaSet(String nombre) {
        for (Pelicula p : hashPeliculas.toArray(new Pelicula[0])) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrada en Set: " + p);
                return;
            }
        }
        System.out.println("No encontrada en Set");
    }
    public void buscarPeliculaMap(String nombre) {
        for (List<Pelicula> listaGenero : mapPeliculas.values()) {
            for (Pelicula p : listaGenero) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Encontrada en Map: " + p);
                    return;
                }
            }
        }
        System.out.println("No encontrada en Map");
    }

    /**
     * Lista las peliculas por su duracion(list)
     */
    public void listarPeliculaDuracion(){
        for (Pelicula pelicula: listaPeliculas){
            System.out.println("Duracion: " + pelicula.getDuracion() + "\t\tNombre: " + pelicula.getNombre());
        }
    }

    /**
     * Lista las peliculas por su nombre(hash)
     */
    public void listarPeliculaNombre(){
        for(Pelicula p:treePeliculas) System.out.println("Nombre: " + p.getNombre());
    }

    /**
     * Lista las peliculas por genero(map)
     */
    public void listarPeliculaGenero(){
        for (String genero: mapPeliculas.keySet()){
            System.out.println("\n---Genero: " + genero + "---");
            System.out.println("Peliculas: \n" + mapPeliculas.get(genero));
        }
    }

    public void mostrarMenu(){
        inicializarListaPeliculas();

        int opc = -1;
        while (opc!=0){
            System.out.println("\t\t-----BIENVENIDO-----");
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
                    System.out.println("----Buscar pelicula en----");
                    System.out.println("1. List");
                    System.out.println("2. Set");
                    System.out.println("3. Map");
                    System.out.println("Opcion: ");

                    int opcionBusqueda = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese el nombre de la pelicula:");
                    String nombreBuscar = sc.nextLine();

                    switch (opcionBusqueda) {
                        case 1:
                            Pelicula encontradaLista = buscarPeliculaLista(nombreBuscar);
                            if (encontradaLista == null) System.out.println("No se encontro");
                            break;
                        case 2:
                            buscarPeliculaSet(nombreBuscar);
                            break;
                        case 3:
                            buscarPeliculaMap(nombreBuscar);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    break;
                case 3:
//    • Permite a los usuarios agregar nuevas películas dinámicamente con Scanner.
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
        agregarPelicula(new Pelicula("Bambi", "Disney", generos[0], 1.3));
        agregarPelicula(new Pelicula("El Hoyo", "Juan", generos[2], 2.1));
        agregarPelicula(new Pelicula("Sharknado", "Henry", generos[1], 1.45));
        agregarPelicula(new Pelicula("Tiburon", "Pedro", generos[3], 2.3));
    }
}
