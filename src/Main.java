public class Main {

    public static void main(String[] args) {

        System.out.println("Tripadvisor comments");

        String filepath = "C:\\Users\\Travail\\IdeaProjects\\SDA-21-22\\SDA_Serie12_TextMining\\data\\tripadvisor_hotel_reviews.csv";

        ICommentsAnalyzer analyzer = new CommentsAnalyzer();
        analyzer.loadComments(filepath);

        for(Comment comment : analyzer.getComments())
            System.out.println(comment.toString());

    }

}