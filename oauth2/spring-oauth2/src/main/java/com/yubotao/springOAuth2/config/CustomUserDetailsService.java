package com.yubotao.springOAuth2.config;

import com.yubotao.springOAuth2.exception.CustomException;
import com.yubotao.springOAuth2.jpa.ARJpa;
import com.yubotao.springOAuth2.jpa.AccountJpa;
import com.yubotao.springOAuth2.model.Account;
import com.yubotao.springOAuth2.model.AccountRole;
import com.yubotao.springOAuth2.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:29 2018/12/17
 * @Modified By:
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    AccountJpa accountJpa;
    @Autowired
    ARJpa arJpa;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        String lowerUsername = username.toLowerCase();
        Account account = accountJpa.findAccountByUsername(lowerUsername);
        if (account == null) {
            throw new CustomException("User " + lowerUsername + " was not found in the database");
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<AccountRole> ars = arJpa.findAccountRolesByAccount(account);
        for (AccountRole ar : ars){
            Role role = ar.getRole();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
    }
}
