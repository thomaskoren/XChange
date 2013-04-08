package com.xeiam.xchange.bitcoin24.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Thomas Koren
 */
public class Bitcoin24WithdrawBtc {
	private final String transactionId;
	private final String error;
	
	public Bitcoin24WithdrawBtc(@JsonProperty("trans") String transactionId,
  														 @JsonProperty("error") String error) {
		this.transactionId = transactionId;
		this.error = error;
	}

  public String getTransactionId() {
    return transactionId;
  }

  public String getError() {
    return error;
  }

  @Override
  public String toString() {
    return String.format("WidthdrawBtc{transaction_id=%s}", transactionId);
  }
}


