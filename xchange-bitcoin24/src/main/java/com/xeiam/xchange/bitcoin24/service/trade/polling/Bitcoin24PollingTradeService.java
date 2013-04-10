/**
 * 
 */
package com.xeiam.xchange.bitcoin24.service.trade.polling;


import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.NotYetImplementedForExchangeException;
import com.xeiam.xchange.bitcoin24.Bitcoin24;
import com.xeiam.xchange.bitcoin24.Bitcoin24Adapters;
import com.xeiam.xchange.bitcoin24.dto.trade.Bitcoin24OpenOrder;
import com.xeiam.xchange.dto.trade.LimitOrder;
import com.xeiam.xchange.dto.trade.MarketOrder;
import com.xeiam.xchange.dto.trade.OpenOrders;
import com.xeiam.xchange.rest.RestProxyFactory;
import com.xeiam.xchange.service.streaming.BasePollingExchangeService;
import com.xeiam.xchange.service.trade.polling.PollingTradeService;
import com.xeiam.xchange.utils.Assert;

/**
 * @author Thomas Koren
 */
public class Bitcoin24PollingTradeService extends BasePollingExchangeService implements PollingTradeService {
	private Bitcoin24 btc24;

  public Bitcoin24PollingTradeService(ExchangeSpecification exchangeSpecification) {
    super(exchangeSpecification);

    Assert.notNull(exchangeSpecification.getSslUri(), "Exchange specification URI cannot be null");
    this.btc24 = RestProxyFactory.createProxy(Bitcoin24.class, exchangeSpecification.getSslUri());
  }

  @Override
  public OpenOrders getOpenOrders() {
  	Bitcoin24OpenOrder[] openOrders = btc24.getOpenOrders(exchangeSpecification.getUserName(), exchangeSpecification.getApiKey(), "open_orders");
    return new OpenOrders(Bitcoin24Adapters.adaptOrders(openOrders));
  }

  @Override
  public String placeMarketOrder(MarketOrder marketOrder) {
  	throw new NotYetImplementedForExchangeException();
  }

  @Override
  public String placeLimitOrder(LimitOrder limitOrder) {
  	throw new NotYetImplementedForExchangeException();
  }

  @Override
  public boolean cancelOrder(String orderId) {
  	throw new NotYetImplementedForExchangeException();
  }
}
