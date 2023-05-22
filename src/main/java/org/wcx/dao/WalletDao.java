package org.wcx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wcx.entity.Wallet;

import java.math.BigDecimal;

/**
 * @author wcx
 * @date 2023/5/22 15:03
 */
@Mapper
public interface WalletDao {
    Wallet getWalletByUserId(Integer userId);

    Integer updateWalletByUserId(@Param("userId") Integer userId, @Param("amount") BigDecimal amount);
}
