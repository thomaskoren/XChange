package com.xeiam.xchange.bitcoin24.service.account.polling;

import java.math.BigDecimal;

import com.xeiam.xchange.ExchangeException;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.bitcoin24.Bitcoin24;
import com.xeiam.xchange.bitcoin24.Bitcoin24Adapters;
import com.xeiam.xchange.bitcoin24.dto.account.Bitcoin24AccountInfo;
import com.xeiam.xchange.bitcoin24.dto.account.Bitcoin24BtcAddress;
import com.xeiam.xchange.bitcoin24.dto.account.Bitcoin24WithdrawBtc;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.rest.RestProxyFactory;
import com.xeiam.xchange.service.account.polling.PollingAccountService;
import com.xeiam.xchange.service.streaming.BasePollingExchangeService;

/**
 * @author Thomas Koren
 */
public class Bitcoin24PollingAccountService extends BasePollingExchangeService implements PollingAccountService {
	private Bitcoin24 btc24;

  /**
   * Constructor
   * 
   * @param exchangeSpecification
   */
  public Bitcoin24PollingAccountService(ExchangeSpecification exchangeSpecification) {

    super(exchangeSpecification);
    this.btc24 = RestProxyFactory.createProxy(Bitcoin24.class, exchangeSpecification.getUri());
  }
	
	@Override
  public AccountInfo getAccountInfo() {
		Bitcoin24AccountInfo accInfo = btc24.getAccountInfo(exchangeSpecification.getUserName(), exchangeSpecification.getApiKey(), "get_balance");
    if(accInfo.getErrorCode() != null) {
      throw new ExchangeException("Error getting AccountInfo. Error Code: " + accInfo.getErrorCode() + "; Error Message: " + accInfo.getErrorMessage());
    }

    return Bitcoin24Adapters.adaptAccountInfo(accInfo, exchangeSpecification.getUserName());
  }

	@Override
  public String requestBitcoinDepositAddress(String... arguments) {
		Bitcoin24BtcAddress btcAddr = btc24.getBitcoinAddress(exchangeSpecification.getUserName(), exchangeSpecification.getApiKey(), "get_addr");
    if(btcAddr.getError() != null) {
      throw new ExchangeException("Error getting Bitcoin Address. " + btcAddr.getError());
    }

    return btcAddr.getBtcAddress();
  }
	
	@Override
  public String withdrawFunds(BigDecimal amount, String address) {
		Bitcoin24WithdrawBtc wd = btc24.withdrawBitcoin(exchangeSpecification.getUserName(), exchangeSpecification.getApiKey(), "withdraw_btc", amount, address);
    if(wd.getError() != null) {
      throw new ExchangeException("Error withdrawing. " + wd.getError());
    }

    return wd.getTransactionId();
  }
}
