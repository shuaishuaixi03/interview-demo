package org.wcx.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wcx
 * @date 2023/5/22 16:33
 */
@Data
public class WalletLog {
    private Integer id;
    private Integer walletId;
    private Date log_time;
    private String op;
    private BigDecimal amount;
}
