package AdvertPriceCalculator.Processes.NewAdvert;

import AdvertPriceCalculator.Entities.Advert;

/**
 * Created by Neil on 06/12/2014.
 */
public class NewAdvertUserValidationAdvertClient extends NewAdvertUserValidationBase {

    Advert ad;

    public NewAdvertUserValidationAdvertClient(Advert theAdvert){

        ad = theAdvert;

    }

    public void SetAdvertClientName(String value){
        if(value.length() > 0  && value.length() <= 30){
                this.IsSelectionCorrect = true;
                ad.setAdvertClientName(value);
        }
        else{
            this.IsSelectionCorrect = false;
            this.Print("The client name must be something and less than or equal to 30 characters.");
        }
    }

}
