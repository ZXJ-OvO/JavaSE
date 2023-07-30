package com.zxj.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 定义银行卡：主卡和副卡类，完成下列功能
 * 1、完成银行卡-主卡的存取款方法
 * 主卡卡有余额，卡号，户主等属性
 * 有存款和取款的方法（取款时候余额不足要有提示）
 * 2、完成银行卡-副卡的取款方法
 * 副卡额外有透支额度属性(副卡可用主卡中余额，且余额不够，可以透支额度)
 * 副卡重写取款方法（取款时候余额不足要有提示）
 * 3、写测试案例，分别测试主卡和副卡的存取款功能（存取款后显示余额）
 */
public class Question21 {
    public static void main(String[] args) {
        MasterCard masterCard = new MasterCard();
        SecondaryCard secondaryCard = new SecondaryCard();

        masterCard.setId(getCardId());
        masterCard.setUser("食蜂操祈");
        masterCard.setBalance(1000.0);
        secondaryCard.setId(getCardId());
        secondaryCard.setUser("上条当麻");
        secondaryCard.setBalance(masterCard.getBalance());

        System.out.println("-----------------------------------------");

        masterCard.deposit(1000.0);
        masterCard.withDraw(1000.0);

        secondaryCard.deposit(1000.0);
        secondaryCard.withDraw(3000.0);

    }

    public static String getCardId() {
        Random random = new Random();
        StringBuilder cardId = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            cardId.append(random.nextInt(9));
        }
        return cardId.toString();
    }
}


@EqualsAndHashCode(callSuper = true)
@Data
class MasterCard extends BankCard {

    {
        this.id = super.getId();
        super.setBalance(0.0);
        this.user = super.getUser();
        System.out.println("初始 银行卡 - 主卡 余额为：" + super.balance);
    }

    public void deposit(double usd) {
        super.balance += usd;
        System.out.println("用 主卡 存" + usd);
        System.out.println("卡号为：" + super.id + " 户主为：" + super.user);
        System.out.println("存款成功，余额为：" + super.balance);
    }

    public void withDraw(double usd) {
        if (usd <= super.balance) {
            BigDecimal balance = new BigDecimal(super.balance);
            BigDecimal drawMoney = new BigDecimal(usd);
            BigDecimal subtract = balance.subtract(drawMoney);
            System.out.println("用 主卡 取" + usd);
            System.out.println("卡号为：" + super.id + " 户主为：" + super.user);
            System.out.println("取款成功，余额为：" + subtract);
            return;
        }
        System.out.println("余额不足");
    }
}

@EqualsAndHashCode(callSuper = true)
@Data
class SecondaryCard extends BankCard {
    public Double overDraft;

    public SecondaryCard() {

    }

    {
        this.id = super.getId();
        super.setBalance(0.0);
        this.user = super.getUser();
        System.out.println("初始 银行卡 - 副卡 余额为：" + super.balance);
    }

    public void deposit(double usd) {
        super.balance += usd;
        System.out.println("用 副卡 存" + usd);
        System.out.println("卡号为：" + super.id + " 户主为：" + super.user);
        System.out.println("存款成功，余额为：" + super.balance);
    }

    public void withDraw(double usd) {
        if (usd <= super.balance) {
            BigDecimal balance = new BigDecimal(super.balance);
            BigDecimal drawMoney = new BigDecimal(usd);
            BigDecimal subtract = balance.subtract(drawMoney);
            System.out.println("用 副卡 取" + usd);
            System.out.println("卡号为：" + super.id + " 户主为：" + super.user);
            System.out.println("取款成功，余额为：" + subtract);
            return;
        }
        System.out.println("余额不足");
        overdraft(usd);
    }

    public void overdraft(double usd) {
        double v = this.getBalance() - usd;
        this.setBalance(v);
        System.out.println("本w次透支金额：" + Math.abs(this.getBalance()));

    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class BankCard {
    public Double balance;
    public String id;
    public String user;

}
