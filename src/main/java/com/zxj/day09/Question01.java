package com.zxj.day09;

import lombok.*;

import java.util.*;


public class Question01 {

    public static void main(String[] args) throws Exception {
        ATM.welcomePage();
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Account {
    private String cardNumber;
    private String name;
    private String gender;
    private String password;
    private Double balance = 0.0;
    private Double withdraw;
}

@Data
@AllArgsConstructor
class ATM {
    private static final Random random = new Random();
    private static final Date date = new Date();
    private static final Thread thread = new Thread();
    private static List<Account> accounts = new ArrayList<>();

    public static void welcomePage() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n==========欢迎使用ATM系统==========");
        System.out.println("1、用户登录");
        System.out.println("2、用户开户");
        System.out.println("请选择您要操作的命令：");
        thread.sleep(1000);
        String command = sc.nextLine();

        switch (command) {
            case "1":
                userLogin(accounts);
                break;
            case "2":
                openAccount(random, date, accounts);
                break;
            default:
                System.out.println("命令输入错误，请重新输入！");
                welcomePage();
        }
    }

    private static void openAccount(Random random, Date date, List<Account> accounts) throws Exception {
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.println("==========系统开户操作==========");
        System.out.println("请输入您的姓名：");
        String name = sc.nextLine();
        account.setName(name);
        System.out.println("请输入您的性别：");
        String gender = sc.nextLine();
        account.setGender(gender);
        System.out.println("请输入您的密码：");
        String pwd = sc.nextLine();
        account.setPassword(pwd);
        System.out.println("请输入您的单次最大体现额度：");
        Double withdraw = sc.nextDouble();
        account.setWithdraw(withdraw);
        String cardNumber = "";
        for (int i = 0; i < 3; i++) {
            cardNumber += random.nextInt(10);
        }
        String time = String.valueOf(date.getTime());
        cardNumber += time.substring(time.length() - 5);
        System.out.println("开户成功！您的账号为：" + cardNumber);
        account.setCardNumber(cardNumber);
        accounts.add(account);
        System.out.println("\n==================================");
        thread.sleep(1000);
        welcomePage();
    }

    private static void userLogin(List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (accounts == null || accounts.size() == 0) {
            System.out.println("系统中没有账户，请先开户！");
            System.out.println("\n==================================");
        }
        System.out.println("==========系统登录操作==========");
        System.out.println("请输入您的账号：");
        String cardNumber = sc.nextLine();
        Account account = null;
        for (Account value : accounts) {
            if (cardNumber.equals(value.getCardNumber())) {
                account = value;
            }
        }
        if (!cardNumber.equals(account.getCardNumber())) {
            System.out.println("账号输入错误");
            System.out.println(account.toString());
            System.out.println(accounts.toString());
            userLogin(accounts);
        }
        System.out.println("请输入您的密码：");
        if (!sc.nextLine().equals(account.getPassword())) {
            System.out.println("密码输入错误");
        }
        System.out.println("\n==================================\n");
        userMenu(account, accounts);
    }

    private static void userMenu(Account account, List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========系统登录成功==========");
        System.out.println("1、查询");
        System.out.println("2、存款");
        System.out.println("3、取款");
        System.out.println("4、转账");
        System.out.println("5、改密");
        System.out.println("6、退出");
        System.out.println("7、销户");
        System.out.println("请选择您要操作的命令：");
        String command = sc.nextLine();
        switch (command) {
            case "1":
                query(account, accounts);
                break;
            case "2":
                deposit(account, accounts);
                break;
            case "3":
                withdraw(account, accounts);
                break;
            case "4":
                transfer(account, accounts);
                break;
            case "5":
                changePwd(account, accounts);
                break;
            case "6":
                exitSystem(account, accounts);
                break;
            case "7":
                deleteAccount(account, accounts);
                break;
            default:
                System.out.println("命令输入错误，请重新输入！");
                userMenu(account, accounts);
        }
    }

    private static void exitSystem(Account account, List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========退出系统==========");
        System.out.println("您确定要退出系统吗？（Y/N）");
        String command = sc.nextLine();
        if (command.equals("Y")) {
            System.out.println("系统退出成功！");
            System.exit(0);
        } else if (command.equals("N")) {
            userMenu(account, accounts);
        } else {
            System.out.println("命令输入错误，请重新输入！");
            exitSystem(account, accounts);
        }

    }

    private static void deleteAccount(Account account, List<Account> accounts) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========销户操作==========");
        System.out.println("请输入您的账号：");
        String cardNumber = sc.nextLine();
        if (!cardNumber.equals(account.getCardNumber())) {
            System.out.println("账号输入错误");
            deleteAccount(account, accounts);
        }
        System.out.println("请输入您的密码：");
        if (!sc.nextLine().equals(account.getPassword())) {
            System.out.println("密码输入错误");
        }
        accounts.remove(account);
        System.out.println("账户销户成功！");
        System.out.println("\n==================================");
    }

    private static void changePwd(Account account, List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========改密操作==========");
        System.out.println("请输入您的新密码：");
        String pwd = sc.nextLine();
        System.out.println("请再次输入您的新密码：");
        if (!sc.nextLine().equals(pwd)) {
            System.out.println("两次密码输入不一致，请重新输入！");
            changePwd(account, accounts);
        }
        account.setPassword(pwd);
        System.out.println("密码修改成功！");
        System.out.println("\n==================================");
        userMenu(account, accounts);
    }

    private static void transfer(Account account, List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========转账操作==========");
        System.out.println("请输入您要转账的账号：");
        String cardNumber = sc.nextLine();
        System.out.println("请输入您要转账的金额：");
        Double money = sc.nextDouble();
        if (money > account.getBalance()) {
            System.out.println("余额不足！");
            transfer(account, accounts);
        }
        for (Account a : accounts) {
            if (a.getCardNumber().equals(cardNumber)) {
                a.setBalance(a.getBalance() + money);
                account.setBalance(account.getBalance() - money);
                System.out.println("转账成功！您的账户余额为：" + account.getBalance());
                System.out.println("本日剩余可取款额度为：" + (account.getWithdraw() - money));
                thread.sleep(2000);
                userMenu(account, accounts);
            }
        }
        System.out.println("转账失败！您输入的账号不存在！");
        thread.sleep(2000);
        System.out.println("\n==================================");
        userMenu(account, accounts);
    }

    private static void withdraw(Account account, List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========取款操作==========");
        System.out.println("请输入您要取款的金额：");
        Double money = sc.nextDouble();
        if (money > account.getWithdraw()) {
            System.out.println("单次取款金额超过最大限额！");
            withdraw(account, accounts);
        }
        if (money > account.getBalance()) {
            System.out.println("余额不足！");
            withdraw(account, accounts);
        }
        account.setBalance(account.getBalance() - money);
        System.out.println("取款成功！您的账户余额为：" + account.getBalance());
        System.out.println("本日剩余可取款额度为：" + (account.getWithdraw() - money));
        thread.sleep(2000);
        System.out.println("\n==================================");
        userMenu(account, accounts);
    }

    private static void deposit(Account account, List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========存款操作==========");
        System.out.println("请输入您要存款的金额：");
        Double money = sc.nextDouble();
        account.setBalance(account.getBalance() + money);
        System.out.println("存款成功！您的账户余额为：" + account.getBalance());
        thread.sleep(2000);
        System.out.println("\n==================================");
        userMenu(account, accounts);
    }

    private static void query(Account account, List<Account> accounts) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========查询操作==========");
        System.out.println("账户余额：" + account.getBalance());
        System.out.println("账户卡号：" + account.getCardNumber());
        System.out.println("账号名称：" + account.getName());
        System.out.println("账号性别：" + account.getGender());
        System.out.println("取款额度：" + account.getWithdraw());
        System.out.println("账号密码：******");
        thread.sleep(2000);
        System.out.println("\n==================================");
        userMenu(account, accounts);
    }
}
