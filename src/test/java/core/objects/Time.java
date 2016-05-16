package core.objects;

import core.data.Constants;

/**
 * Created by bogat on 5/9/2016.
 */
public class Time {

    private int hours;
    private int minuts;

    /*************************************************************************************
     * *                                     Constructors                                 **
     *************************************************************************************/

    public Time(int hours, int minuts) {
        this.hours = hours;
        this.minuts = minuts;
    }

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public int getHours() {
        return hours;
    }

    public int getMinuts() {
        return minuts;
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinuts(int minuts) {
        this.minuts = minuts;
    }

    /*************************************************************************************
     * *                                     Others                                      **
     *************************************************************************************/

    @Override
    public String toString() {
        return hours + Constants.TIME_SEPARATOR + minuts;
    }
}
