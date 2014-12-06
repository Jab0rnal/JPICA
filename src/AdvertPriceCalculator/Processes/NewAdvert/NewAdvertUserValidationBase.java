package AdvertPriceCalculator.Processes.NewAdvert;

/**
 * Created by Neil on 06/12/2014.
 */
public abstract class NewAdvertUserValidationBase {

    public boolean IsSelectionCorrect;

    public NewAdvertUserValidationBase(){
        this.IsSelectionCorrect = false;
    }

    protected void Print(String toPrint){
        System.out.println(toPrint);
    }
}
