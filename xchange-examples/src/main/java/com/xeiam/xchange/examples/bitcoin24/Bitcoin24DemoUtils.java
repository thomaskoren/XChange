package com.xeiam.xchange.examples.bitcoin24;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.bitcoin24.Bitcoin24Exchange;

/**
 * @author Thomas Koren
 */
public class Bitcoin24DemoUtils {

  public static Exchange getExchange() {
    ExchangeSpecification exSpec = new Bitcoin24Exchange().getDefaultExchangeSpecification();
    exSpec.setUserName("47110815");
    exSpec.setApiKey("TU3hSq0cecxEsKdO6N3oc4DRUprefQAp");
    return ExchangeFactory.INSTANCE.createExchange(exSpec);
  }
}
