package Dao;

/**
 * Created by yubotao on 2017/09/25.
 */
public interface AccountDao {
    public void addAccount(int id, double account);
    public void inAccount(int id, double account);
    public void outAccount(int id, double account);
}
