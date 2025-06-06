import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwitterService {
    private final List<Post> posts = new ArrayList<>();

    public void initializePosts(){
        posts.add(new Post(new User("Талгат"),"Я хочу в Дубай!"));
        posts.add(new Post(new User("Лена"),"Как же жарко, хочу на море..."));
        posts.add(new Post(new User("Бригада <У>"),"Всех с праздником!"));
    }

    public void createPost(User user, String content){
        Post post = new Post (user, content);
        posts.add(post);
        System.out.println("Пост добавлен. ID: " + post.getId() + ". " + user.getName() + ". Написал пост: " + content );
    }

    public void likePost(int postId){
        Post post = findPostById(postId);
        if ( post != null){
            post.like();
            System.out.println("Пост лайкнут.");
        }else{
            System.out.println("Пост не найден.");
        }
    }

    public void repost(User user, int postId){
        Post original = findPostById(postId);
        if(original != null){
            original.repost();
            Post repost = new Post(user,"Репост: " + original.getContent());
            posts.add(repost);
            System.out.println("Репост выполнен.");
        } else {
            System.out.println("Пост не найден.");
        }
    }

    public void showAllPosts(){
        if(posts.isEmpty()){
            System.out.println("Нет постов.");
            return;
        }
        System.out.println("\n--- Все посты ---");
        for (Post post : posts){
            System.out.println(post);
            System.out.println();
        }
    }

    public void showPopularPosts(){
        if(posts.isEmpty()){
            System.out.println("Нет постов.");
            return;
        }
        System.out.println("\n --- Популярные посты ---");
        posts.stream()
                .sorted(Comparator.comparingInt(
                        (Post p) -> p.getLikes() +
                p.getReposts()).reversed()).limit(5).forEach(post ->{
            System.out.println(post);
            System.out.println();
        });
    }

    public void showUserPost(User user) {
        boolean found = false;
        System.out.println("\n--- Ваши посты ---");
        for (Post post : posts){
            if
            (post.getAuthor().getName().equals(user.getName())){
                System.out.println(post);
                System.out.println();
                found = true;
            }
        }
        if(!found){
            System.out.println("У вас пока нет постов");
        }
    }
    private Post findPostById(int id){
        return posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
