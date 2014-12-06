/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvertPriceCalculator.Entities;

import AdvertPriceCalculator.Exceptions.ExtensionNotImplementedException;
import AdvertPriceCalculator.Processes.NewAdvert.NewAdvertUserValidationAdvertPosition;
import AdvertPriceCalculator.Processes.NewAdvert.NewAdvertUserValidationAdvertType;
import AdvertPriceCalculator.Processes.NewAdvert.NewAdvertUserValidationBase;

import java.util.ArrayList;
import java.util.Date;


public class Advert {

    private Date advertDate;
    private ArrayList<AdvertExtensionBase> advertTypes = new ArrayList<>();
    private ArrayList<AdvertExtensionBase> advertPositions = new ArrayList<>();
    private int advertHeight;
    private int advertWidth;
    private boolean isArtWorkRequired;
    private String advertReferenceNumber;
    private int advertPrice;
    private String advertClientName;

    //User validation
    public NewAdvertUserValidationBase correctAdvertTypeSelected;
    public NewAdvertUserValidationBase correctAdvertPositionSelected;


    public Advert(){

        //Set up advert types
        advertTypes.add(new AdvertType(1, "Black & White", false));
        advertTypes.add(new AdvertType(2, "Colour", false));
        advertTypes.add(new AdvertType(3, "Wrapper", false));

        //Set up advert positions
        advertPositions.add(new AdvertPosition(1, "Run", false));
        advertPositions.add(new AdvertPosition(2, "Front", false));
        advertPositions.add(new AdvertPosition(3, "Back", false));
        advertPositions.add(new AdvertPosition(4, "Wrapper", false));

        //User validation
        correctAdvertTypeSelected = new NewAdvertUserValidationAdvertType();
        correctAdvertPositionSelected = new NewAdvertUserValidationAdvertPosition();

    }

    private ArrayList<AdvertExtensionBase> GetExtensionListToAccess(AdvertExtensionType et) throws ExtensionNotImplementedException {

        switch (et){
            case POSITION:
                return advertPositions;
            case TYPE:
                return advertTypes;
            default:
                throw new ExtensionNotImplementedException("The extension " + et.toString() + " does not exist");
        }

    }

    /*
    Gets the instance selected extension type.
     */
    public AdvertExtensionBase GetSelectedExtension(AdvertExtensionType eType){
        AdvertExtensionBase result = null;
        try {
            for(AdvertExtensionBase et : GetExtensionListToAccess(eType)){
                if(et.IsSelected){
                    result = et;
                }
            }
        } catch (ExtensionNotImplementedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void SetAdvertExtension(int selection, AdvertExtensionType eType, NewAdvertUserValidationBase validation){

        //User validation
        validation.IsSelectionCorrect = false;


        try {
            for(AdvertExtensionBase at : GetExtensionListToAccess(eType)){

                if(at.Index == selection){
                    validation.IsSelectionCorrect = true;
                }

            }
        } catch (ExtensionNotImplementedException e) {
            e.printStackTrace();
        }
        //if a user has picked something other than what exists then exit this method.
        if(!validation.IsSelectionCorrect){
            return;
        }

        //iterate through all objects, setting each to false, preventing two being set as selected.
        try {
            for(AdvertExtensionBase ap : GetExtensionListToAccess(eType)){
                ap.IsSelected = false;
                //if this object is the new selection, set it to IsSelected.
                if(ap.Index == selection){
                    ap.IsSelected = true;
                }
            }
        } catch (ExtensionNotImplementedException e) {
            e.printStackTrace();
        }
    }



    public enum AdvertExtensionType{POSITION,TYPE}

    public String GetAdvertExtensionMenu(AdvertExtensionType selection) {
        StringBuilder result = new StringBuilder();
        ArrayList<AdvertExtensionBase> selectedList = null;

        try {selectedList = GetExtensionListToAccess(selection);}
        catch (ExtensionNotImplementedException e) { e.printStackTrace(); }

        for (AdvertExtensionBase at : selectedList){
            result.append(at.Index).append(") ").append(at.Name);
            result.append(System.lineSeparator());
        }
        return result.toString();
    }


    //region basic Setters and getters
    /**
     * @return the isArtWorkRequired
     */
    public boolean isIsArtWorkRequired() {
        return isArtWorkRequired;
    }

    /**
     * @param isArtWorkRequired the isArtWorkRequired to set
     */
    public void setIsArtWorkRequired(boolean isArtWorkRequired) {
        this.isArtWorkRequired = isArtWorkRequired;
    }

    /**
     * @return the advertReferenceNumber
     */
    public String getAdvertReferenceNumber() {
        return advertReferenceNumber;
    }

    /**
     * @param advertReferenceNumber the advertReferenceNumber to set
     */
    public void setAdvertReferenceNumber(String advertReferenceNumber) {
        this.advertReferenceNumber = advertReferenceNumber;
    }

    /**
     * @return the advertPrice
     */
    public int getAdvertPrice() {
        return advertPrice;
    }

    /**
     * @param advertPrice the advertPrice to set
     */
    public void setAdvertPrice(int advertPrice) {
        this.advertPrice = advertPrice;
    }

    /**
     * @return the advertClientName
     */
    public String getAdvertClientName() {
        return advertClientName;
    }

    /**
     * @param advertClientName the advertClientName to set
     */
    public void setAdvertClientName(String advertClientName) {
        this.advertClientName = advertClientName;
    }


    /* Complexities forced move to class instead.
    public enum AdvertType {BLACKANDWHITE(1), COLOUR(2), WRAPPER(3);
        public final int num;
        private AdvertType(int num) {
            this.num = num;
        }
        public static AdvertType getNumber(int i){
            for(AdvertType number : AdvertType.values()){
                if(i == number.num){
                    return number;
                }
            }
            throw new IllegalArgumentException("This AdvertType doesn't exist");
        }
    }
 */

    /* Complexities forced move to class instead.
    public enum AdvertPosition {RUN(1), FRONT(2), BACK(3), WRAPPER(4);
        private final int value;

        private AdvertPosition(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }

        //public void setValue(int value) {AdvertPosition = value;}

    }
  */

     /**
     * @return the advertDate
     */
    public Date getAdvertDate() {
        return advertDate;
    }
    
    /**
     * @param advertDate the advertDate to set
     */
    public void setAdvertDate(Date advertDate) {
        this.advertDate = advertDate;
    }


    /**
     * @return the advertHeight
     */
    public int getAdvertHeight() {
        return advertHeight;
    }

    /**
     * @param advertHeight the advertHeight to set
     */
    public void setAdvertHeight(int advertHeight) {


        this.advertHeight = advertHeight;
    }
    
      /**
     * @return the advertWidth
     */
    public int getAdvertWidth() {
        return advertWidth;
    }

    /**
     * @param advertWidth the advertWidth to set
     */
    public void setAdvertWidth(int advertWidth) {
        this.advertWidth = advertWidth;
    }
    //endregion




    
       

    
    
}
