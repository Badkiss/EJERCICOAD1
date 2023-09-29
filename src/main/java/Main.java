import Controlador.FormateoArchivos;
import Controlador.TramitacionArchivos;
import Model.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Pelicula> pls=new ArrayList<>();
        pls=FormateoArchivos.formateoArchivo("peliculas.csv");
        Map<Integer,Integer> mes;
       mes=TramitacionArchivos.recaudacionPorMes(pls);
       mes.forEach((n,s)->System.out.println(n+" "+s));
       Map<Integer,Long>mesc;
       mesc=TramitacionArchivos.peliculasPorMes(pls);
       mesc.forEach((n,s)->System.out.println(n+" "+s));
       Optional min=TramitacionArchivos.peliculaConMayorRecaudacionMenosCines(pls);
       System.out.println(min);
       Map<String,Long> distribuidorasPelis = TramitacionArchivos.numeroPeliculasPorDistribuidoras(pls);
       distribuidorasPelis.forEach((n,s)->System.out.println(n+" "+s));
       Map<String,Integer> menoresGanacias=TramitacionArchivos.menorDinero(pls);
       menoresGanacias.forEach((p,s)->System.out.println(p+" "+s));
    }
}