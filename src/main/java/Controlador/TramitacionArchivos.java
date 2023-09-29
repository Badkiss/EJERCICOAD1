package Controlador;

import Model.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TramitacionArchivos {

    public static Map<Integer,Integer> recaudacionPorMes(List<Pelicula>peliculas){
        return peliculas.stream().collect(Collectors.groupingBy((n)-> n.getFechaDeEstreno().getMonth(),Collectors.summingInt(n->n.getTotalGanado())));
    };
    public static Map<Integer,Long> peliculasPorMes(List<Pelicula>peliculas){
        return peliculas.stream().collect(Collectors.groupingBy(n->n.getFechaDeEstreno().getMonth(),Collectors.counting()));
    }
    public static java.util.Optional<Pelicula> peliculaConMayorRecaudacionMenosCines(List<Pelicula>peliculas){
        return peliculas.stream().collect(Collectors.minBy(Pelicula.minCines));

    }
    public static Map<String,Long> numeroPeliculasPorDistribuidoras(List<Pelicula>peliculas){
        return peliculas.stream().collect(Collectors.groupingBy((n-> n.getDistribuidora()),Collectors.counting()));
    }
public static Map<String,Integer> menorDinero(List<Pelicula>peliculas){

    Map<String,Integer> bruto=new TreeMap<>();
            bruto= peliculas.stream().collect(Collectors.groupingBy((n)->n.getDistribuidora(),Collectors.summingInt(n->n.getTotalGanado())));
    List<Map.Entry<String, Integer>> list=new ArrayList<>(bruto.entrySet());
    System.out.println("-------------------------------------------------------------------");
    System.out.println(list);
            System.out.println();
            System.out.println("---------------------------------------");
         return bruto;
}
}
