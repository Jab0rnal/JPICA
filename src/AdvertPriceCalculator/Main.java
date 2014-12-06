/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvertPriceCalculator;

import AdvertPriceCalculator.Processes.IProcess;
import java.util.Scanner;

/**
 *
 * @author M1305814
 */
public class Main {

    public static boolean ProcessIsValid;

    public static void main(String[] args) throws Exception {

        ProcessIsValid = true;

        //Create a MainMenu instance.
        MainMenu mm = new MainMenu();

        //create a keyboard scanner.
        Scanner kb = new Scanner(System.in);

        //Keep displaying the main menu while the process is still valid.
        while (ProcessIsValid) {
            //Display the menu
            mm.DisplayMenuToScreen();
            //display the user prompt
            mm.DisplayUserPrompt();
            //run the selected process using the AutoCloseable implementation
            try (IProcess proc = mm.ItemSelection(kb.nextInt())) {
                proc.Run();
            }
        }
    }





}
