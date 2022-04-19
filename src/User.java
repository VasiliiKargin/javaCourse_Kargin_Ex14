public class User {
    private String name;
    private int age;
    private String login;
    private String city;
    private String gender;

    public User(String name, int age, String login, String city, String gender) {
        this.name = name;
        this.age = age;
        this.login = login;
        this.city = city;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
