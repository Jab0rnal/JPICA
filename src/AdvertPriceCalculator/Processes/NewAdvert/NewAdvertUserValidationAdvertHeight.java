package AdvertPriceCalculator.Processes.NewAdvert;

import AdvertPriceCalculator.Entities.Advert;

/**
 * Created by Neil on 06/12/2014.
 */
public class NewAdvertUserValidationAdvertHeight extends NewAdvertUserValidationBase {

    Advert ad;

    public NewAdvertUserValidationAdvertHeight(Advert theAdvert){

        ad = theAdvert;

    }

    public void SetAdvertHeight(int value){
        if(value >= 10 && value <= 70){

            if(value % 5 == 0){
                this.IsSelectionCorrect = true;
                ad.setAdvertHeight(value);
            }
            else{
                this.IsSelectionCorrect = false;
                this.Print("This must be multiples of 5");
            }

        }
        else{
            this.IsSelectionCorrect = false;
            this.Print("The value must be between 10 and 70");
        }
    }

}
