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
package com.xeiam.xchange.mtgox.v1.service.marketdata.polling;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xeiam.xchange.mtgox.v1.dto.marketdata.MtGoxTrade;

/**
 * Test MtGoxTrade[] JSON parsing
 */
public class TradesJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is = TradesJSONTest.class.getResourceAsStream("/v1/marketdata/polling/example-trades-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MtGoxTrade[] mtGoxTrades = mapper.readValue(is, MtGoxTrade[].class);

    // Verify that the example data was unmarshalled correctly
    assertThat("Unexpected Return Buy value", mtGoxTrades[0].getPriceInt(), equalTo(1560000L));
    // System.out.println(mtGoxTrades[0].toString());
  }
}
