package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.Comment;

import java.util.ArrayList;
import java.util.List;
import static ch.heg.ig.sda.io.FileDatabaseUtils.findColumnIndex;

public class CommentsCsvDatabaseLoader extends CommentsDatabaseLoader {

    /**
     * Input
     * @param filepath Full path of the file that will be loaded.
     */
    public CommentsCsvDatabaseLoader(final String filepath){
        super(filepath);
    }

    public void process() {
        this.comments = loadCleanDatabase(filepath);
    }

    /**
     * Load a clean database into a List<String[]>.
     * @param filename Document database filepath.
     */
    private List<Comment> loadCleanDatabase(final String filename){
        List<String[]> comments = ParserUtils.parseCSV(filename);
        return parseCommentsDatabase(comments);
    }

    /**
     * Parse a cleaned documents database.
     * Use Pattern.quote to parse "|" character.
     * @param loadedComments Cleaned documents database.
     * @return List of documents.
     */
    private List<Comment> parseCommentsDatabase(List<String[]> loadedComments){

        int reviewColumnIndex = findColumnIndex(loadedComments.get(0), CommentsDatabaseConstant.REVIEW.getColumnName());
        int ratingColumnIndex = findColumnIndex(loadedComments.get(0), CommentsDatabaseConstant.RATING.getColumnName());
        int notFoundColumnIndex = -1;

        int startIndex = 1; // Skip header

        // The size is known in advance, prevent array list unnecessary grow
        List<Comment> comments = new ArrayList<>(loadedComments.size()-1);

        for (int i = startIndex; i < loadedComments.size(); i++) {

            Comment comment = new Comment();

            if(reviewColumnIndex != notFoundColumnIndex) {
                comment.setReview(loadedComments.get(i)[reviewColumnIndex]);
            }

            if(ratingColumnIndex != notFoundColumnIndex) {
                comment.setRating(Integer.parseInt(loadedComments.get(i)[ratingColumnIndex]));
            }

            comments.add(comment);
        }

        return comments;
    }

}
