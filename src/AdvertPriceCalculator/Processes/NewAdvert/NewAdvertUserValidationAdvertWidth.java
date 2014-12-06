package AdvertPriceCalculator.Processes.NewAdvert;

import AdvertPriceCalculator.Entities.Advert;

/**
 * Created by Neil on 06/12/2014.
 */
public class NewAdvertUserValidationAdvertWidth extends NewAdvertUserValidationBase {

    Advert ad;

    public NewAdvertUserValidationAdvertWidth(Advert theAdvert){

        ad = theAdvert;

    }

    public void SetAdvertWidth(int value){
        if(value >= 1 && value <= 5){

            this.IsSelectionCorrect = true;
            ad.setAdvertWidth(value);

        }
        else{
            this.IsSelectionCorrect = false;
            this.Print("The value must be between 1 and 5");
        }
    }

}
