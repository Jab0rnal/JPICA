package AdvertPriceCalculator.Processes.NewAdvert;

import AdvertPriceCalculator.Entities.Advert;
import AdvertPriceCalculator.Entities.AdvertType;
import AdvertPriceCalculator.Processes.ProcessBase;


public class NewAdvertProcess extends ProcessBase {

    private Advert ad;


    @Override
    public void Run() {

        ad = new Advert();

        this.PrintToScreen("NEW ADVERT");
        this.PrintToScreen("Please enter a client name:");

        NewAdvertUserValidationAdvertClient clientVal = new NewAdvertUserValidationAdvertClient(ad);
        while(!clientVal.IsSelectionCorrect){
            clientVal.SetAdvertClientName(kb.nextLine());
        }

        while (!ad.correctAdvertTypeSelected.IsSelectionCorrect){
            DisplayAdvertExtension("Please select an advert type:", Advert.AdvertExtensionType.TYPE, ad.correctAdvertTypeSelected);
        }
        this.PrintToScreen("You selected:");
        this.PrintToScreen(ad.GetSelectedExtension(Advert.AdvertExtensionType.TYPE).Name);

        //if the wrapper selection is set from above then we should automatically set the position to Wrapper.
        if(((AdvertType)ad.GetSelectedExtension(Advert.AdvertExtensionType.TYPE)).IsWrapper()){
            this.PrintToScreen("You selected Wrapper. The position will automatically be set to Wrapper.");
            this.PrintToScreen("The height and width have been set to 0");
            ad.SetAdvertExtension(4, Advert.AdvertExtensionType.POSITION, ad.correctAdvertPositionSelected);
            ad.setAdvertHeight(0);
            ad.setAdvertWidth(0);
        }
        else{
            while (!ad.correctAdvertPositionSelected.IsSelectionCorrect){
                DisplayAdvertExtension("Please select a advert position:", Advert.AdvertExtensionType.POSITION, ad.correctAdvertPositionSelected);
            }
            this.PrintToScreen("You selected:");
            this.PrintToScreen(ad.GetSelectedExtension(Advert.AdvertExtensionType.POSITION).Name);

            //advert height.
            NewAdvertUserValidationAdvertHeight valHeight = new NewAdvertUserValidationAdvertHeight(ad);
            this.PrintToScreen("Please select a height. Multiples of 5 and between 10 and 70:");
            while(!valHeight.IsSelectionCorrect){
                while (!kb.hasNextInt()){
                   this.PrintToScreen("Please only use numbers.");
                    kb.next();
                }
                valHeight.SetAdvertHeight(kb.nextInt());
            }

            //advert width
            NewAdvertUserValidationAdvertWidth valWidth = new NewAdvertUserValidationAdvertWidth(ad);
            this.PrintToScreen("Please select a width. Between 1 and 5, inclusive:");
            while(!valWidth.IsSelectionCorrect){
                while (!kb.hasNextInt()){
                    this.PrintToScreen("Please only use numbers.");
                    kb.next();
                }
                valWidth.SetAdvertWidth(kb.nextInt());
            }

        }

        this.PrintToScreen("Please enter a reference:");
        NewAdvertUserValidationAdvertReference refVal = new NewAdvertUserValidationAdvertReference(ad);
        while(!refVal.IsSelectionCorrect){

            /*a hacky method of preventing the console from registering a next line input
            *that is passing through to the method and firing it...*/
            String inputCapture = kb.nextLine();

            refVal.SetAdvertReference(kb.nextLine());
        }



    }


    private void DisplayAdvertExtension(String textToDisplay, Advert.AdvertExtensionType eType, NewAdvertUserValidationBase validator) {

        this.PrintToScreen(textToDisplay);
        this.PrintToScreen(ad.GetAdvertExtensionMenu(eType));

            /*Implementation of http://stackoverflow.com/questions/2912817/how-to-use-scanner-to-accept-only-valid-int-as-input
            * which seems like a good way of testing for number values with the scanner class.*/
        while (!kb.hasNextInt()){
            this.PrintToScreen("Please only select a number");
            this.PrintToScreen(ad.GetAdvertExtensionMenu(eType));
            kb.next();
        }
        ad.SetAdvertExtension(kb.nextInt(), eType, validator);




    }


}
