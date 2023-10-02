import Controlador.FormateoArchivos;
import Controlador.TramitacionArchivos;
import Model.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main1 {
    public static void main(String[] args) {
        List<Pelicula> pls=new ArrayList<>();
        pls=FormateoArchivos.formateoArchivo("peliculas.csv");
        Map<Integer,Integer> mes;
       mes=TramitacionArchivos.recaudacionPorMes(pls);
       mes.forEach((n,s)->System.out.println(n+1+" "+s));
       Map<Integer,Long>mesc;
       mesc=TramitacionArchivos.peliculasPorMes(pls);
       mesc.forEach((n,s)->System.out.println(n+1+" "+s));
       Optional min=TramitacionArchivos.peliculaConMayorRecaudacionMenosCines(pls);
       System.out.println(min);
       Map<String,Long> distribuidorasPelis = TramitacionArchivos.numeroPeliculasPorDistribuidoras(pls);
       distribuidorasPelis.forEach((n,s)->System.out.println(n+" "+s));
        List<Map.Entry<String, Integer>> menor=TramitacionArchivos.menorDinero(pls);
       menor.stream().forEach((n)->System.out.println(n.getKey()+" "+n.getValue()));
       List<List<Pelicula>> masYmenos =TramitacionArchivos.mejorPeor(pls);
        for (int i = 0; i < masYmenos.size(); i++) {
            System.out.println(masYmenos.get(i).get(0).getDistribuidora());
            for (int j = 0; j < 2; j++) {
                if (j==0){
                    System.out.print("Menor recaudacion = ");
                }else{
                    System.out.print("Mayor recaudadcion = ");
                }
                System.out.println(masYmenos.get(i).get(j));
            }
        }
        TramitacionArchivos.peorMes(pls);
    }
}