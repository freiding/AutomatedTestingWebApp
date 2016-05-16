package core.objects;

/**
 * Created by bogat on 5/9/2016.
 */
public class GEvent {

    private String title;
    private core.objects.Date date;
    private core.objects.Time time;
    private String location;
    private String description;
    private String forWhom;

    /*************************************************************************************
     * *                                     Constructors                                **
     *************************************************************************************/
    public GEvent(String title, core.objects.Date date, core.objects.Time time, String location, String description, String forWhom) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.forWhom = forWhom;
    }

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getForWhom() {
        return forWhom;
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }
}
