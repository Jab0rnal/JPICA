package AdvertPriceCalculator.Entities;

/**
 * Created by Neil on 06/12/2014.
 */
public abstract class AdvertExtensionBase {

    public int Index;
    public String Name;
    public boolean IsSelected;

    public AdvertExtensionBase(int index, String name, boolean isSelected){
        this.Index = index;
        this.Name = name;
        this.IsSelected = isSelected;
    }


}
