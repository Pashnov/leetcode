package org.axp.start;

// https://leetcode.com/problems/richest-customer-wealth/submissions/
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        for (int customerIndex = 0; customerIndex < accounts.length; customerIndex++ ) {
            sumA(accounts[customerIndex]);
            if (accounts[customerIndex][0] > accounts[0][0]) {
                accounts[0][0] = accounts[customerIndex][0];
            }
        }
        return accounts[0][0];
    }

    public void sumA(int[] account) {
        for (int i = 1; i < account.length; i++) {
            account[0] += account[i];
        }
    }
}
