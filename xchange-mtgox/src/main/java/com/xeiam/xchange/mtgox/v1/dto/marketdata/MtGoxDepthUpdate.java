/**
 * Copyright (C) 2012 - 2013 Xeiam LLC http://xeiam.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.mtgox.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * Data object representing a Market Depth Change from Mt Gox
 * <p>
 * Auto-generated using the simplest types possible with conversion delegated to the adapter
 * <p>
 * Note: deprecated fields are not included in this value object
 */
public final class MtGoxDepthUpdate {

  private final String tradeType;
  private final long priceInt;
  private final long volumeInt;
  private final String item;
  private final String currency;
  private final long now;
  private final long totalVolumeInt;

  /**
   * Constructor
   * 
   * @param tradeType
   * @param priceInt
   * @param volumeInt
   * @param item
   * @param currency
   * @param now
   * @param totalVolumeInt
   */
  public MtGoxDepthUpdate(@JsonProperty("type_str") String tradeType, @JsonProperty("price_int") long priceInt, @JsonProperty("volume_int") long volumeInt, @JsonProperty("item") String item,
      @JsonProperty("currency") String currency, @JsonProperty("now") long now, @JsonProperty("total_volume_int") long totalVolumeInt) {

    this.tradeType = tradeType;
    this.priceInt = priceInt;
    this.volumeInt = volumeInt;
    this.item = item;
    this.currency = currency;
    this.now = now;
    this.totalVolumeInt = totalVolumeInt;
  }

  public String getTradeType() {

    return tradeType;
  }

  public long getPriceInt() {

    return priceInt;
  }

  public long getVolumeInt() {

    return volumeInt;
  }

  public String getItem() {

    return item;
  }

  public String getCurrency() {

    return currency;
  }

  public long getNow() {

    return now;
  }

  public long getTotalVolumeInt() {

    return totalVolumeInt;
  }

  @Override
  public String toString() {

    return "MtGoxDepthUpdate [tradeType=" + tradeType + ", priceInt=" + priceInt + ", volumeInt=" + volumeInt + ", item=" + item + ", currency=" + currency + ", now=" + now + ", totalVolumeInt="
        + totalVolumeInt + "]";
  }

}
