/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//
// To run this integrations use:
//
//     kamel run --name=rest-with-restlet --dependency=camel-rest --dependency=camel-restlet examples/RestWithRestlet.java
//
import org.apache.camel.Exchange;

public class customer extends org.apache.camel.builder.RouteBuilder {
    @Override
    public void configure() throws Exception {
        /*restConfiguration()
            .component("restlet")
            .host("0.0.0.0")
            .port("8080");*/

        /*rest()
            .get("/hello")
            .to("direct:hello");*/

        from("direct:getCustomer")
            .setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
            .transform().simple("Customer User1 gotten using Camel K");

        from("direct:CreateCustomer")
            .setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
            .transform().simple("Customer Created using Camel K");

    }
}