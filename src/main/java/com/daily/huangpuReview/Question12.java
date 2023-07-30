package com.daily.huangpuReview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


/**
 * ATM System
 */
public class Question12 {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}

class ATM {
    private final ArrayList<Account> accounts = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private static Account loginAccount;

    /**
     * 启动
     */
    public void start() {
        while (true) {
            System.out.println("------------------欢迎进入ATM系统------------------");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.print("请输入命令：");
            String cmd = scanner.next();
            switch (cmd) {
                case "1":
                    login();
                    break;
                case "2":
                    createAccount();
                    break;
                default:
                    System.out.println("命令错误！");
            }
        }
    }

    /**
     * 登录
     */
    private void login() {
        checkAccounts();
        System.out.print("请输入账户户号：");
        String idCard = scanner.next();
        for (Account account : accounts) {
            if (account.getCardId().equals(idCard)) {
                int status = 0;
                while (true) {
                    System.out.print("请您输入密码：");
                    String password = scanner.next();
                    if (password.length() == 6) {
                        while (true) {
                            System.out.print("再次输入密码：");
                            String againPwd = scanner.next();
                            if (password.equals(againPwd)) {
                                account.setPassword(password);
                                break;
                            }

                            status++;
                            System.out.println("密码输入错误。还剩" + (3 - status) + "次机会");
                            if (status == 3) {
                                System.out.println("密码错误达到3次，请携带证件联系柜台取卡");
                                System.exit(1);
                            }
                        }
                        break;
                    }
                }
                System.out.print("登录成功！\n");
                menu();
            }
        }

    }

    /**
     * 菜单
     */
    private void menu() {
        System.out.println("------------------账户操作页面------------------");
        System.out.println("1、查询");
        System.out.println("2、存款");
        System.out.println("3、取款");
        System.out.println("4、转账");
        System.out.println("5、改密");
        System.out.println("6、退出");
        System.out.println("7、销户");
        while (true) {
            System.out.print("请输入操作指令：");
            String cmd = scanner.next();
            switch (cmd) {
                case "1":
                    selectAccount();
                    break;
                case "2":
                    saveMoney();
                    break;
                case "3":
                    withDraw();
                    break;
                case "4":
                    transferMoney();
                    break;
                case "5":
                    updatePassword();
                    break;
                case "6":
                    exitATMSystem();
                    break;
                case "7":
                    accountCancellation();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    /**
     * 退出
     */
    private void exitATMSystem() {
        System.out.print("输入yes/no确认是否退出ATM系统：");
        String cmd = scanner.next();
        if (cmd.equals("no")) {
            menu();
        }
        if (cmd.equals("yes")) {
            System.exit(1);
        }
    }

    /**
     * 转账
     */
    private void transferMoney() {
        while (true) {
            System.out.println("请您输入需要转账的账户名");
            String targetCardId = scanner.next();
            for (int i = 0; i < accounts.size(); i++) {
                if (!accounts.get(i).getCardId().equals(targetCardId)) {
                    System.out.println("不存在该账户，请重新输入！");
                }else {
                    String targetUserName = accounts.get(i).getUserName();
                    String substringName = targetUserName.substring(1);
                    String name = "*" + substringName;
                    System.out.println("收款方：" + name);
                    System.out.print("请输入完整的对方账户的姓名：");
                    String inputName = scanner.next();
                    if (!inputName.equals(targetUserName)) {
                        System.out.println("姓名输入错误，请仔细确认！");
                        continue;
                    }
                    int money;
                    OUT:
                    while (true) {
                        System.out.print("请输入您要转账的金额：");
                        money = scanner.nextInt();
                        for (int m = 0; m < accounts.size(); m++) {
                            if (accounts.get(m).getCardId().equals(loginAccount.getCardId())) {
                                accounts.get(m).setBalance(accounts.get(m).getBalance() - money);
                                accounts.get(i).setBalance(accounts.get(i).getBalance() + money);
                                for (Account account : accounts) {
                                    if (account.getCardId().equals(loginAccount.getCardId())) {
                                        account.setBalance(account.getBalance() - money);
                                    }
                                }
                                break OUT;
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * 改密
     */
    private void updatePassword() {
        System.out.print("请输入旧密码：");
        for (Account account : accounts) {
            if (account.getCardId().equals(loginAccount.getCardId())) {
                int status = 0;
                while (true) {
                    System.out.print("请您输入新密码：");
                    String password = scanner.next();
                    if (password.length() == 6) {
                        while (true) {
                            System.out.print("再次输入密码：");
                            String againPwd = scanner.next();
                            if (password.equals(againPwd)) {
                                account.setPassword(password);
                                break;
                            }

                            status++;
                            System.out.println("密码输入错误。还剩" + (3 - status) + "次机会");
                            if (status == 3) {
                                System.out.println("密码错误达到3次，请携带证件联系柜台取卡");
                                System.exit(1);
                            }
                        }
                        break;
                    }
                }
                System.out.println("密码修改成功！请重新登录本系统！");
                login();
            }
        }
    }

    /**
     * 销户
     */
    private void accountCancellation() {
        System.out.println("销户操作不可逆，请谨慎操作！");
        System.out.print("您确定要销户吗？输入yes/no：");
        String cmd = scanner.next();
        if ("no".equals(cmd)) {
            System.out.println("销户操作取消");
            menu();
        }

        if ("yes".equals(cmd)) {
            System.out.println("请输入账户户号");
            Iterator<Account> iterator = accounts.iterator();
            for (Account account : accounts) {
                if (account.getCardId().equals(loginAccount.getCardId())) {
                    iterator.remove();
                    System.out.println("销户操作执行成功！");
                    start();
                }
            }
        }
    }

    /**
     * 取款
     */
    private void withDraw() {
        OUT:
        while (true) {
            System.out.println("请输入取现金额，本系统仅接受100整纸钞且最低取款100元");
            int withDrawMoney = scanner.nextInt();
            for (Account account : accounts) {
                if (account.getCardId().equals(loginAccount.getCardId())) {
                    if (account.getBalance() < withDrawMoney) {
                        System.out.println("余额不足");
                        continue;
                    }

                    if (account.getBalance() >= withDrawMoney) {
                        account.setBalance(account.getBalance() - withDrawMoney);
                        break OUT;
                    }
                }
            }
            System.out.println("不存在该账户！");
        }
        System.out.println("取现成功！");
    }

    /**
     * 存款
     */
    private void saveMoney() {
        while (true) {
            System.out.print("请输入存钱额度，本系统仅接受100整纸钞且最低存入100元：");
            int money = scanner.nextInt();
            if (money % 100 != 0) {
                System.out.println("输入违规，请重新输入金额");
                continue;
            }
            if (money % 100 == 0) {

                System.out.println("正在验钞中，请稍后...");
                System.out.print("您本次存款金额为：" + money);
                for (Account account : accounts) {
                    if (account.getCardId().equals(loginAccount.getCardId())) {
                        account.setBalance(account.getBalance() + money);
                    }
                }
                break;
            }
        }
        System.out.println("存款成功！");
    }

    /**
     * 查询
     */
    private void selectAccount() {
        System.out.println("------------------个人信息预览------------------");
        System.out.println("户号：" + loginAccount.getCardId());
        System.out.println("余额：" + loginAccount.getBalance());
        System.out.println("性别：" + loginAccount.getGender());
        System.out.println("姓名：" + loginAccount.getUserName());
        System.out.println("今日最大取现额度" + loginAccount.getWithDraw());
    }

    /**
     * 检查
     */
    private void checkAccounts() {
        while (true) {
            if (accounts.isEmpty()) {
                System.out.println("当前系统无账户，请先开户");
                createAccount();
                continue;
            }
            return;
        }
    }

    /**
     * 开户
     */
    private void createAccount() {
        System.out.println("------------------开户------------------");
        Account account = new Account();

        // 账户名
        System.out.print("请输入账户名：");
        String inputName = scanner.next();
        account.setUserName(inputName);

        // 性别
        OUT:
        while (true) {
            System.out.print("请输入性别（男/女）：");
            String genderString = scanner.next();
            char[] genderCharArray = genderString.toCharArray();
            char gender = genderCharArray[0];
            switch (gender) {
                case '男':
                case '女':
                    account.setGender(gender);
                    break OUT;
                default:
                    System.out.println("本系统不欢迎变性人");
            }
        }

        // 账户密码
        int status = 0;
        while (true) {
            System.out.print("请您输入六位账户密码：");
            String password = scanner.next();
            if (password.length() == 6) {
                while (true) {
                    System.out.print("再次输入确认密码：");
                    String againPwd = scanner.next();
                    if (password.equals(againPwd)) {
                        account.setPassword(password);
                        break;
                    }

                    status++;
                    System.out.println("密码输入错误。还剩" + (3 - status) + "次机会");
                    if (status == 3) {
                        System.out.println("密码错误达到3次，请携带证件联系柜台取卡");
                        System.exit(1);
                    }
                }
                break;
            }
        }

        // 每次取现额度
        while (true) {
            System.out.print("请您输入每次取现额度（最低1000整）：");
            int withDraw = scanner.nextInt();
            if (withDraw < 1000) {
                System.out.println("提现额度设置非法");
                continue;
            }
            account.setWithDraw(withDraw);
            break;
        }

        // 生成卡号 19位
        Date date = new Date();
        long time = date.getTime();
        StringBuilder idCard = new StringBuilder(time + "");
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            idCard.append(random.nextInt(9));
        }
        System.out.println("开户卡号：" + idCard);

        account.setCardId(idCard.toString());

        accounts.add(account);
        loginAccount = account;

        System.out.println("开户成功! \t");
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Account {
    private String cardId;
    private String userName;
    private Character gender;
    private String password;
    private double balance = 0;
    private Integer withDraw;
}