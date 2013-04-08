/**
 * 
 */
package com.xeiam.xchange.bitcoin24.service.trade.polling;


import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.NotYetImplementedForExchangeException;
import com.xeiam.xchange.dto.trade.LimitOrder;
import com.xeiam.xchange.dto.trade.MarketOrder;
import com.xeiam.xchange.dto.trade.OpenOrders;
import com.xeiam.xchange.service.streaming.BasePollingExchangeService;
import com.xeiam.xchange.service.trade.polling.PollingTradeService;

/**
 * @author Thomas Koren
 */
public class Bitcoin24PollingTradeService extends BasePollingExchangeService implements PollingTradeService {

  public Bitcoin24PollingTradeService(ExchangeSpecification exchangeSpecification) {
    super(exchangeSpecification);
  }

  @Override
  public OpenOrders getOpenOrders() {
  	throw new NotYetImplementedForExchangeException();
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
