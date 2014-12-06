package AdvertPriceCalculator.Entities;

/**
 * Created by Neil on 06/12/2014.
 */
public class AdvertType extends AdvertExtensionBase {

    public AdvertType(int index, String name, boolean isSelected){
        super(index, name, isSelected);
        isWrapper = false;
    }

    private boolean isWrapper;

    public boolean IsWrapper(){
        if (this.Name == "Wrapper"){
            isWrapper = true;
            return  true;
        }
        else {
            isWrapper = false;
            return  false;
        }

    }



}
