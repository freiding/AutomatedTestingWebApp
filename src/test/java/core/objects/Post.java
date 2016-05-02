package core.objects;

/**
 * Created by bogat on 5/2/2016.
 */
public class Post {

    private String text;
    private User author;

    public Post(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }
}
