package com.yubotao.springOAuth2.jpa;

import com.yubotao.springOAuth2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:59 2018/12/17
 * @Modified By:
 */
public interface AccountJpa extends JpaRepository<Account, String> {
    @Query("SELECT u FROM Account u WHERE LOWER(u.username) = LOWER(:username)")
    Account findAccountByUsername(@Param("username") String username);
}
