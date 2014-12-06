package AdvertPriceCalculator.Exceptions;

/**
 * Created by Neil on 06/12/2014.
 */
public class ExtensionNotImplementedException extends Exception {

    private String message;

    public ExtensionNotImplementedException(String mess){
        this.message = mess;
    }



}
