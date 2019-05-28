package ServiceImpl;

import Dao.AccountDao;
import POJO.User;
import Service.AccountService;

/**
 * Created by yubotao on 2017/09/25.
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    public void transfer(User outUser, User inUser, double account){
        // TODO Auto-generated method stub
        this.accountDao.outAccount(outUser.getUserID(), account);
        //模拟程序异常,无法执行inAccount方法
//        int i = 1 / 0;
        this.accountDao.inAccount(inUser.getUserID(), account);
    }
}
