package com.xeiam.xchange.examples.bitcoin24.account;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.examples.bitcoin24.Bitcoin24DemoUtils;
import com.xeiam.xchange.service.account.polling.PollingAccountService;

/**
 * @author Thomas Koren
 */
public class Bitcoin24AccountDemo {
	
	/**
	 * <p>
	 * Example showing the following:
	 * </p>
	 * <ul>
	 * <li>Connect to Bitcoin24 exchange with authentication</li>
	 * <li>View account balance</li>
	 * <li>Get the bitcoin deposit address</li>
	 * </ul>
	 */
	public static void main(String[] args) {
		Exchange btc24 = Bitcoin24DemoUtils.getExchange();
    PollingAccountService accountService = btc24.getPollingAccountService();

    // Get the account information
    AccountInfo accountInfo = accountService.getAccountInfo();
    System.out.println("AccountInfo as String: " + accountInfo.toString());

    // TODO IMPLEMENT
    //String depositAddress = accountService.requestBitcoinDepositAddress(null, null);
    //System.out.println("Deposit address: " + depositAddress);
	}
}
