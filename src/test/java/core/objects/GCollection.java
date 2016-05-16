package core.objects;

/**
 * Created by bogat on 5/9/2016.
 */
public class GCollection {

    private String title;
    private String description;
    private GUser author;

    /*************************************************************************************
     * *                                     Constructors                                     **
     *************************************************************************************/

    public GCollection(String title, String description, GUser author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public GUser getAuthor() {
        return author;
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(GUser author) {
        this.author = author;
    }
}
