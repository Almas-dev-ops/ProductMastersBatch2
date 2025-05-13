public class UserData
{
    private int id;
    private String name;
    private String email;



    public UserData(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Информация о пользователе.\n" +
                "=========================\n"+
                "Номер id: " + id + "\n" +
                "Имя пользователя: " + name +"\n"+
                "Электронная почта: " + email;
    }
}
