package AdvertPriceCalculator;
import AdvertPriceCalculator.Processes.IProcess;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author M1305814
 */
public class MainMenu {
    
    
    private Map<Integer, MainMenuItem> menuItems;
    
    
    public MainMenu(){
        
        menuItems = new HashMap<Integer, MainMenuItem>();
        CreateMenuItems();


        
    }
    
    
    private void CreateMenuItems(){
        menuItems.put(1, new MainMenuItem(1, "AdvertPriceCalculator.Processes.NewAdvert.NewAdvertProcess", "1) Enter New Advert"));
        menuItems.put(2, new MainMenuItem(2, "","2) Display Summary of Adverts"));
        menuItems.put(3, new MainMenuItem(3, "","3) Display Summary of Adverts for Selected Month"));
        menuItems.put(4, new MainMenuItem(4, "","4) Find and display Adverts"));
        menuItems.put(5, new MainMenuItem(5, "AdvertPriceCalculator.Processes.Close.CloseProcess","5) Exit"));

    }
    
    
    public void DisplayMenuToScreen(){
        for(Entry<Integer, MainMenuItem> e : menuItems.entrySet()){
            System.out.println(e.getValue().getDisplayText());
        }
    }

    public void DisplayUserPrompt(){
        System.out.println("Please Select an option (1-5) and press return.");
    }


    public IProcess ItemSelection(int selectedItem) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        if(!(selectedItem > 0 && selectedItem <= 6)){
            System.out.println("Please select an option between 1 and 5");
            return null;
        }


        IProcess result;

        MainMenuItem itemSelected = (MainMenuItem)menuItems.get(selectedItem);

        result = (IProcess) Class.forName(itemSelected.getAssociatedProcess()).newInstance();

        return result;


    }
    
   
    
    
    
}
