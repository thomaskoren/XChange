package com.xeiam.xchange.bitcoin24.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Thomas Koren
 */
public class Bitcoin24BtcAddress {
	private final String btcAddress;
	private final String error;
	
	public Bitcoin24BtcAddress(@JsonProperty("address") String address,
  													 @JsonProperty("error") String error) {
		this.btcAddress = address;
		this.error = error;
	}

  public String getBtcAddress() {
    return btcAddress;
  }

  public String getError() {
    return error;
  }

  @Override
  public String toString() {
    return String.format("BtcAddress{address=%s}", btcAddress);
  }
}

