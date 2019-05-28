package Service;

import POJO.User;

/**
 * Created by yubotao on 2017/09/25.
 */
public interface AccountService {
    /*
    * 转账，实现从outUser转出account金额的钱到inUser
    */
    public void transfer(User outUser, User inUser, double account);
}
