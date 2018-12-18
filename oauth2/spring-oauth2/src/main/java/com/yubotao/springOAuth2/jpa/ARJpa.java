package com.yubotao.springOAuth2.jpa;

import com.yubotao.springOAuth2.model.Account;
import com.yubotao.springOAuth2.model.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:14 2018/12/17
 * @Modified By:
 */
public interface ARJpa extends JpaRepository<AccountRole, String> {
    @Query("SELECT ar FROM AccountRole ar WHERE LOWER(ar.account) = LOWER(:account)")
    List<AccountRole> findAccountRolesByAccount(@Param("account") Account account);
}
