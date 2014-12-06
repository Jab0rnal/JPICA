package AdvertPriceCalculator.Processes.Close;

import AdvertPriceCalculator.Main;
import AdvertPriceCalculator.Processes.ProcessBase;

/**
 * Created by Neil on 06/12/2014.
 */
public class CloseProcess extends ProcessBase {

    //could be used for any further clean up or logging etc.

    @Override
    public void Run() {
        Main.ProcessIsValid = false;
    }



}
