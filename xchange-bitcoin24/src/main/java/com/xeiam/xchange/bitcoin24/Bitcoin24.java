/**
 * Copyright (C) 2013 Michael Lagacé
 * Copyright (C) 2013 Xeiam LLC http://xeiam.com
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
package com.xeiam.xchange.bitcoin24;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.xeiam.xchange.bitcoin24.dto.account.Bitcoin24AccountInfo;
import com.xeiam.xchange.bitcoin24.dto.marketdata.Bitcoin24Depth;
import com.xeiam.xchange.bitcoin24.dto.marketdata.Bitcoin24Ticker;
import com.xeiam.xchange.bitcoin24.dto.marketdata.Bitcoin24Trade;
import com.xeiam.xchange.dto.account.AccountInfo;

/**
 * @author Michael Lagacé
 */
@Path("api")
public interface Bitcoin24 {

  @GET
  @Path("{currency}/ticker.json")
  Bitcoin24Ticker getTicker(@PathParam("currency") String currency);

  @GET
  @Path("{currency}/orderbook.json")
  Bitcoin24Depth getFullDepth(@PathParam("currency") String currency);

  @GET
  @Path("{currency}/trades.json")
  Bitcoin24Trade[] getTrades(@PathParam("currency") String currency, @QueryParam("since") long sinceId);

  @POST
  @Path("user_api.php")
  @Produces("application/json")
  @Consumes("application/x-www-form-urlencoded")
  Bitcoin24AccountInfo getAccountInfo(@FormParam("user") String username, @FormParam("key") String apiKey, @FormParam("api") String apiFunction);
}
