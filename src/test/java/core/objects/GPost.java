package core.objects;

/**
 * Created by bogat on 5/2/2016.
 */
public class GPost {

    private String text;
    private GUser author;

    /*************************************************************************************
     * *                                     Constructors                                 **
     *************************************************************************************/

    public GPost(GUser author, String text) {
        this.author = author;
        this.text = text;
    }

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public String getText() {
        return text;
    }

    public GUser getAuthor() {
        return author;
    }

    /*************************************************************************************
     * *                                     Other                                        **
     *************************************************************************************/

    public boolean equals(GPost gPost) {
        if (this.author.equals(gPost.author) & this.text.equals(gPost.getText()))
            return true;
        else
            return false;
    }
}
