package AdvertPriceCalculator.Processes.NewAdvert;

import AdvertPriceCalculator.Entities.Advert;

/**
 * Created by Neil on 06/12/2014.
 */
public class NewAdvertUserValidationAdvertReference extends NewAdvertUserValidationBase {

    Advert ad;

    public NewAdvertUserValidationAdvertReference(Advert theAdvert){

        ad = theAdvert;

    }

    public void SetAdvertReference(String value){

        if(value.length() == 6){

            if(value.charAt(0) == 'A' || value.charAt(0) == 'C'){

                if(IsNumbers(value.substring(1,4)) && IsDoubleUppercase(value.substring(4,6))){

                    this.IsSelectionCorrect = true;
                    ad.setAdvertClientName(value);
                }
                else{
                    DisplayError();
                }
            }
            else{
                DisplayError();
            }
        }
        else{
            DisplayError();
        }
    }


    private void DisplayError(){
        String errorMessage = "Please use the following format - A letter followed by three digits and two letters. The first letter can only be A for Account Transaction or C for Cash Transaction. e.g. A123ED";
        this.Print(errorMessage);
    }

    private boolean IsNumbers(String s) {
        return s.matches("([0-9])+");
    }


    private boolean IsDoubleUppercase(String s){
        return s.matches("([A-Z])+");
    }


}
