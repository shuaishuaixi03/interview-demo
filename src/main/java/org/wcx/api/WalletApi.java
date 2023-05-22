package org.wcx.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcx.dao.WalletDao;
import org.wcx.entity.Wallet;

import java.math.BigDecimal;

/**
 * @author wcx
 * @date 2023/5/22 15:01
 */
@RestController
public class WalletApi {

    @Autowired
    private WalletDao walletDao;

    @GetMapping("/wallets")
    public Wallet getWallet() {
        Integer userId = getCurrentUserId();
        Wallet wallet = walletDao.getWalletByUserId(userId);
        return wallet;
    }

    @GetMapping("/consumes")
    @Transactional
    public String consume() {
        //下单操作，判断判断商品是否上架、数量是否足够，然后计算总价
        BigDecimal consumeAmount = new BigDecimal(100);
        Integer userId = getCurrentUserId();
        Wallet wallet = walletDao.getWalletByUserId(userId);
        //消费100元
        walletDao.updateWalletByUserId(userId, wallet.getAmount().subtract(consumeAmount));
        //把消费信息写入wallet_log表中
        //然后生成订单、减库存
        //如果中间发生异常，可以抛出一个异常，把错误信息返回给前端，记得添加事务注解，防止出现数据不一致错误
        return "消费成功, 当前Wallet信息为" + walletDao.getWalletByUserId(userId).toString();
    }

    @GetMapping("/refunds")
    @Transactional
    public String refund() {
        //首先查询订单能不能退款
        //然后计算退款金额
        BigDecimal refundAmount = new BigDecimal(20);
        Integer userId = getCurrentUserId();
        Wallet wallet = walletDao.getWalletByUserId(userId);
        //退款20元
        walletDao.updateWalletByUserId(userId, wallet.getAmount().add(refundAmount));
        //把退款信息写入wallet_log表中
        //增加商品库存
        //如果中间发生异常，可以抛出一个异常，让controller层去处理，记得添加事务注解，防止出现数据不一致错误
        return "退款成功, 当前Wallet信息为" + walletDao.getWalletByUserId(userId).toString();
    }


    Integer getCurrentUserId() {
        //这里根据当前的cookie或者token，取出登录用户user_id
        //这里简单返回1为当前用户userId
        return 1;
    }
}
