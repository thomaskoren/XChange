package com.xeiam.xchange.examples.bitcoin24.trade;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.dto.trade.OpenOrders;
import com.xeiam.xchange.examples.bitcoin24.Bitcoin24DemoUtils;
import com.xeiam.xchange.service.trade.polling.PollingTradeService;

/**
 * Test requesting all open orders for a given user on Bitcoin24
 * 
 * @author Thomas Koren
 */
public class OpenOrdersDemo {

  public static void main(String[] args) {
  	Exchange btc24 = Bitcoin24DemoUtils.getExchange();
    PollingTradeService tradeService = btc24.getPollingTradeService();

    System.out.println("Getting open orders...");
    OpenOrders openOrders = tradeService.getOpenOrders();
    System.out.println("Open Orders: " + openOrders.toString());
  }

}