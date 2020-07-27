package jdbctest;

public class Test02Object {
    private Integer id;
    private String name;
    private Integer age;
    private Integer endlish;
    private Integer math;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEndlish() {
        return endlish;
    }

    public void setEndlish(Integer endlish) {
        this.endlish = endlish;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
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
