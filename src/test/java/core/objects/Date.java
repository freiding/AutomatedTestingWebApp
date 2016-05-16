package core.objects;

import core.data.Constants;

/**
 * Created by bogat on 5/9/2016.
 */
public class Date {

    private int year;
    private int month;
    private int day;

    /*************************************************************************************
     * *                                     Constructors                                **
     *************************************************************************************/

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    /*************************************************************************************
     * *                                     Others                                      **
     *************************************************************************************/

    @Override
    public String toString() {
        return day + Constants.DATE_SEPARATOR + month + Constants.DATE_SEPARATOR + year;
    }
}
