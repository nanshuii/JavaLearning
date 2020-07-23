package jdbctest;

public class Test02Object {
    private int id;
    private String name;
    private int age;
    private int endlish;
    private int math;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getEndlish() {
        return endlish;
    }

    public void setEndlish(int endlish) {
        this.endlish = endlish;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Test02Object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", endlish=" + endlish +
                ", math=" + math +
                ", sex='" + sex + '\'' +
                '}';
    }
}
