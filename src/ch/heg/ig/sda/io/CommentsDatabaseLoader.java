package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.Comment;
import java.util.List;

public abstract class CommentsDatabaseLoader {

    protected String filepath;

    protected List<Comment> comments;

    public CommentsDatabaseLoader(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public List<Comment> getComments() {
        return comments;
    }

}
