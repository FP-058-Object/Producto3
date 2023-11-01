/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjectFp_Otros;
import java.util.Scanner;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.AWTException;
import java.util.ArrayList;
/**
 *
 * @author Israel
 */
public class LimpiarPantalla {
    
    
    public void ClearConsole() {
        
       try{
            System.out.println("Presione Enter para continuar...");
            new java.util.Scanner(System.in).nextLine();
            //System.out.println("\n");
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
            
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }
}
