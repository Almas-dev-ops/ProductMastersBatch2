public class Post {
    private static int nextId = 1;
    private final int id;
    private final String content;
    private final User author;
    private int likes;
    private int reposts;

    public Post(User author, String content){
        this.id = nextId++;
        this.author = author;
        this.content = content;
        this.likes = 0;
        this.reposts =0;
    }
    public int getId(){
        return id;
    }
    public User getAuthor(){
        return author;
    }
    public String getContent(){
        return content;
    }
    public int getLikes(){
        return likes;
    }
    public int getReposts(){
        return reposts;
    }
    public void like(){
        likes++;
    }
    public void repost(){
        reposts++;
    }

    @Override
    public String toString() {
        return "Post { ID: "+ id+ ",Author; " +
                author.getName() + ". Content: " + content +
                ". Likes: " + likes + ". Reposts: " + reposts + "}" ;
    }
}
