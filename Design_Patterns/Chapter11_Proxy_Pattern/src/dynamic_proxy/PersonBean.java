package dynamic_proxy;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:30 2019/3/19
 * @Modified By:
 */
public interface PersonBean {
    String getName();
    String getGender();
    String getInterests();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);
}
