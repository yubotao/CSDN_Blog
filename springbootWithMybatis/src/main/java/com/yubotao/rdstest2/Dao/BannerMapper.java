package com.yubotao.rdstest2.Dao;


import com.yubotao.rdstest2.POJO.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}