package AdvertPriceCalculator;

/**
 * Created by neil on 04/12/14.
 */
public class MainMenuItem {

    private int itemIndex;
    private String associatedProcess;
    private String displayText;


    public MainMenuItem(int itemIndex, String associatedProcess, String displayText){

        this.itemIndex = itemIndex;
        this.associatedProcess = associatedProcess;
        this.displayText = displayText;
    }

    public int getItemIndex() {
        return itemIndex;
    }


    public String getAssociatedProcess() {
        return associatedProcess;
    }

    public String getDisplayText() {
        return displayText;
    }
}
