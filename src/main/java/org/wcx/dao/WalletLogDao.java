package org.wcx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.wcx.entity.WalletLog;

import java.util.List;

@Mapper
public interface WalletLogDao {
    List<WalletLog> getWalletLogListByWelletId(Integer wellet_id);
}
