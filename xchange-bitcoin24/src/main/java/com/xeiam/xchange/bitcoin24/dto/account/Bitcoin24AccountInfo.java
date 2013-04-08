package com.xeiam.xchange.bitcoin24.dto.account;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Thomas Koren
 */
public class Bitcoin24AccountInfo {
  private final BigDecimal eurBalance;
  private final BigDecimal usdBalance;
  private final BigDecimal btcBalance;
  private final BigDecimal btcAvailable;
  private final String errCode;
  private final String errMessage;
  
  public Bitcoin24AccountInfo(@JsonProperty("eur") BigDecimal eurBalance,
  														@JsonProperty("usd") BigDecimal usdBalance, 
  														@JsonProperty("btc") BigDecimal btcBalance,
  														@JsonProperty("btc_available") BigDecimal btcAvailable,
  														@JsonProperty("error") String errCode,
  														@JsonProperty("message") String errMessage) {
  	this.eurBalance = eurBalance;
    this.usdBalance = usdBalance;
    this.btcBalance = btcBalance;
    this.btcAvailable = btcAvailable;
    this.errCode = errCode;
    this.errMessage = errMessage;
  }
  
  public BigDecimal getEurBalance() {
    return eurBalance;
  }
  
  public BigDecimal getUsdBalance() {
    return usdBalance;
  }

  public BigDecimal getBtcBalance() {
    return btcBalance;
  }

  public BigDecimal getBtcAvailable() {
    return btcAvailable;
  }

  public String getErrorCode() {
    return errCode;
  }
  
  public String getErrorMessage() {
    return errMessage;
  }

  @Override
  public String toString() {
    return String.format("Balance{eurBalance=%s, usdBalance=%s, btcBalance=%s, btcAvailable=%s}", eurBalance, usdBalance, btcBalance, btcAvailable);
  }
}
