package com.yubotao.autoSerial.jpa;

import com.yubotao.autoSerial.model.AutoSerial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 13:42 2019/5/29
 * @Modified By:
 */
public interface AutoSerialJpa extends JpaRepository<AutoSerial, String> {
    @Query("SELECT s FROM AutoSerial s WHERE LOWER(s.strategy) = LOWER(:strategy)")
    AutoSerial findAutoSerialByStrategy(@Param("strategy") String strategy);
}
