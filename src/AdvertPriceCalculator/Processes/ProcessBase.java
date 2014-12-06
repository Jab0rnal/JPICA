package AdvertPriceCalculator.Processes;

import java.util.Scanner;

/**
 * Created by neil on 04/12/14.
 */
public abstract class ProcessBase implements IProcess {

    protected Scanner kb;

    public ProcessBase(){
       kb = new Scanner(System.in);
    }

    protected void PrintToScreen(String toPrint){
        System.out.println(toPrint);
    }




    @Override
    public void close() throws Exception {

    }
}
