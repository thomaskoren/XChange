package com.xeiam.xchange.bitcoin24.dto.trade;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Thomas Koren
 */
public class Bitcoin24OpenOrder {
	private final String     orderId;
	private final BigDecimal btcAmount;
	private final BigDecimal btcAmountStart;
	private final BigDecimal price;
	private final String     currency;
	private final String     type;
	private final long       date;
	
  private final String errCode;
  private final String errMessage;
  
  public Bitcoin24OpenOrder(@JsonProperty("id")           String     orderId,
                            @JsonProperty("amount")       BigDecimal btcAmount,
                            @JsonProperty("amount_start") BigDecimal btcAmountStart,
                            @JsonProperty("price") 				BigDecimal price,
                            @JsonProperty("cur") 					String     currency,
                            @JsonProperty("type") 				String     type,
                            @JsonProperty("date") 				long       date,
                            @JsonProperty("error") 				String     errCode,
                            @JsonProperty("message") 			String     errMessage) {
  	
  	this.orderId = orderId;    
  	this.btcAmount = btcAmount;
  	this.btcAmountStart = btcAmountStart;
  	this.price = price;    
  	this.currency = currency;
  	this.type = type;
  	this.date = date;  
  	this.errCode = errCode;  
  	this.errMessage = errMessage;
  }

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @return Bitcoin amount left to buy / sell
	 */
	public BigDecimal getBtcAmount() {
		return btcAmount;
	}

	/**
	 * @return Bitcoin you started the offer
	 */
	public BigDecimal getBtcAmountStart() {
		return btcAmountStart;
	}

	/**
	 * @return Price per Bitcoin
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return Currency EUR, USD
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @return Type 1 = Buy, 2 = Sell
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return timestamp
	 */
	public long getDate() {
		return date;
	}

	/**
	 * @return error code
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @return the error message
	 */
	public String getErrMessage() {
		return errMessage;
	}

  @Override
  public String toString() {
    return String.format("OpenOrder{orderId=%s, btcAmount=%s, btcAmountStart=%s, price=%s, currency=%s, type=%s, date=%s}", orderId, btcAmount, btcAmountStart, price, currency, type, date);
  }
}
