package org.wcx.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wcx
 * @date 2023/5/22 15:02
 */
@Data
public class Wallet {
    private Long id;
    private Long user_id;
    private BigDecimal amount;
}
