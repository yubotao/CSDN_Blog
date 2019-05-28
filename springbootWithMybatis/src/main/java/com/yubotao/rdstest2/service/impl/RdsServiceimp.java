package com.yubotao.rdstest2.service.impl;


import com.yubotao.rdstest2.Dao.BannerMapper;
import com.yubotao.rdstest2.POJO.Banner;
import com.yubotao.rdstest2.service.RdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:36 2018/6/4
 * @Modified By:
 */
@Service
public class RdsServiceimp implements RdsService {
    @Autowired
    BannerMapper bannerMapper;

    public Banner getOne(String id){
        return bannerMapper.selectByPrimaryKey(id);
    }
}
