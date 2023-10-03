import Controlador.FormateoArchivos2;
import Controlador.TramitacionArchivos2;
import Model.Caso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        TramitacionArchivos2.casosMes(casos);
        int valor;
        String año="",mes;
        Pattern pattern=Pattern.compile("^(\\d{4})casosm100\\.csv$");
        Pattern pattern2=Pattern.compile("^(\\d{4})(0[1-9]|1[0-2])casom70\\.csv$");
        Scanner sys=new Scanner(System.in);
        do {
            System.out.println("1 por año");
            System.out.println("2 por mes");
            valor=sys.nextInt();
            switch (valor){
                case 1:
                    System.out.println("Escriba el archivo");
                    año=sys.next();
                    Matcher matcher= pattern.matcher(año);
                    if (matcher.matches()){
                        if (Files.exists(Path.of(año))) {
                            String line = "";
                            try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf((Path.of(año)))))) {
                                while ((line = br.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }else{
                        System.out.println("Mal escrito");
                    }

                    break;
                case 2:
                    System.out.println("Pon el mes deseado en 2 digitos");
                    mes=sys.next();
                    Matcher matcher2=pattern2.matcher(mes);
                    if(matcher2.matches()) {
                        String line="";
                        if (Files.exists(Path.of(mes))) {
                        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(Path.of(mes))))) {
                            while (){

                            }
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        }
                    }
                    break;
                default:
                    System.out.println("Insertar 1 o 2");
            }

        }while (valor!=3);
    }
}
