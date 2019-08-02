package chatRoom.service;

import chatRoom.dao.AccountDao;
import chatRoom.entity.User;

public class AccountService {
    private AccountDao accountDao = new AccountDao();
    //用户登录
    public boolean userLogin(String username,String password){
        User user = new User();
        if (user == null){
            return false;
        }
        return true;
    }
    //用户注册

}
