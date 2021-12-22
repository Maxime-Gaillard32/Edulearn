package ch.heg.ig.sda;

import ch.heg.ig.sda.business.Comment;
import ch.heg.ig.sda.io.CommentsCsvDatabaseLoader;

import java.util.List;

public class CommentsAnalyzer implements ICommentsAnalyzer {

    private List<Comment> comments;

    public CommentsAnalyzer() {
    }

    @Override
    public void loadComments(String filepath) {
        CommentsCsvDatabaseLoader loader = new CommentsCsvDatabaseLoader(filepath);
        loader.process();
        this.comments = loader.getComments();
    }

    public List<Comment> getComments() {
        return comments;
    }

}
