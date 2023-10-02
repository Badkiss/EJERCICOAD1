import Controlador.FormateoArchivos2;
import Controlador.TramitacionArchivos2;
import Model.Caso;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Caso> casos =FormateoArchivos2.inicializarArchivo();
        List<Caso>valdias=TramitacionArchivos2.diasMas(casos);
        valdias.stream().forEach((n)->System.out.println(n.getFecha()+" Num Casos "+n.getCasosValencia()));
        long numMasHombres=TramitacionArchivos2.masHombres(casos);
        System.out.println(numMasHombres);
        long numMasMujeres=TramitacionArchivos2.masMujeres(casos);
        System.out.println(numMasMujeres);
        long igual=TramitacionArchivos2.mismos(casos);
        System.out.println(igual);
        TramitacionArchivos2.casosAño(casos);
    }
}
