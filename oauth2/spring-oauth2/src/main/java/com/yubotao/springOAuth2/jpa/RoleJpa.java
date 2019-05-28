package com.yubotao.springOAuth2.jpa;

import com.yubotao.springOAuth2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:13 2018/12/17
 * @Modified By:
 */
public interface RoleJpa extends JpaRepository<Role, String> {
    @Query("SELECT role FROM Role role WHERE LOWER(role.id) = LOWER(:id)")
    Role findRoleById(@Param("id") String id);
}
