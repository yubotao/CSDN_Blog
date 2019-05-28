package entity;

/**
 * Created by yubotao on 2017/09/24.
 */
public class FatherUser {
    
    private BabyUser babyUser;
    private String power;
    private Integer age;
    
    public BabyUser getBabyUser() {
        return babyUser;
    }
    
    public void setBabyUser(BabyUser babyUser) {
        this.babyUser = babyUser;
    }
    
    public String getPower() {
        return power;
    }
    
    public void setPower(String power) {
        this.power = power;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "FatherUser{" +
                "babyUser=" + babyUser +
                ", power='" + power + '\'' +
                ", age=" + age +
                '}';
    }
}
