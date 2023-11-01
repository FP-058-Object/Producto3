/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OnlineStoreConsola.otros;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
/**
 *
 * @author Israel
 */
public class DniCorrecto {
        private String dniIntroducido = null;
        Scanner miScanner = new Scanner(System.in);
        Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
    
        public DniCorrecto(String dni) {
             this.dniIntroducido = dni;
        }
        public DniCorrecto() {
        }
        public String getDniIntroducido() {
            return dniIntroducido;
        }

    public void setDniIntroducido(String dniIntroducido) {
        
         Matcher mat = pat.matcher(dniIntroducido);
       while(!mat.matches()){
           System.out.println("El Dni introducido es incorrecto, por favor "

                   + "introduzca un Dni válido.");
           System.out.print("Introduce un Dni correcto:");
           dniIntroducido = miScanner.nextLine();
           mat = pat.matcher(dniIntroducido);
       }
        System.out.println("Bien, el Dni " + dniIntroducido + " es un Dni válido");
        this.dniIntroducido = dniIntroducido;
    }
    
}


