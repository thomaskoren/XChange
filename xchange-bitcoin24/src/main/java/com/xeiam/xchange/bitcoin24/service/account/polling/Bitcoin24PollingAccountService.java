package com.xeiam.xchange.bitcoin24.service.account.polling;

import java.math.BigDecimal;

import com.xeiam.xchange.ExchangeException;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.bitcoin24.Bitcoin24;
import com.xeiam.xchange.bitcoin24.Bitcoin24Adapters;
import com.xeiam.xchange.bitcoin24.dto.account.Bitcoin24AccountInfo;
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
    if(accInfo.getError() != null) {
      throw new ExchangeException("Error getting AccountInfo. " + accInfo.getError());
    }

    return Bitcoin24Adapters.adaptAccountInfo(accInfo, exchangeSpecification.getUserName());
  }

	@Override
  public String withdrawFunds(BigDecimal amount, String address) {
	  // TODO Auto-generated method stub
	  return null;
  }

	@Override
  public String requestBitcoinDepositAddress(String... arguments) {
	  // TODO Auto-generated method stub
	  return null;
  }
}
