package com.kevidn;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kevidn.service.AccountService;

public class App {  
    public static void main(String[] args)   {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        
        // Menampilkan saldo masing-masing rekening.
        System.out.println("Saldo uang sekarang (sebelum di transfer)");
        System.out.println("Saldo Account 1 : " + accountService.getAccount(1L).getBalance());
        System.out.println("Saldo Account 2 : " + accountService.getAccount(2L).getBalance());
        System.out.println("Saldo Account 3 : " + accountService.getAccount(3L).getBalance());


        // Mencoba transfer dari rekening akun pertama ke ketiga sebesar Rp 2.000.000.
        accountService.transferMoney(1L, 3L, new BigDecimal(2000000));
        System.out.println("Transfer dari rekening pertama ke ketiga berhasil.");

        // Menampilan saldo rekening pertama dan ketiga setelah terjadi transfer antar rekening.
        System.out.println("Saldo uang sekarang (setelah di transfer)");
        System.out.println("Saldo Account 1 : " + accountService.getAccount(1L).getBalance());
        System.out.println("Saldo Account 3 : " + accountService.getAccount(3L).getBalance());
    }
}
