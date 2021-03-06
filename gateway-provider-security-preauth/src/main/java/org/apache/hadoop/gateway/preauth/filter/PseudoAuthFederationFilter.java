/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.gateway.preauth.filter;

import java.security.Principal;
import java.util.Set;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class PseudoAuthFederationFilter 
  extends AbstractPreAuthFederationFilter {
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    super.init(filterConfig);
  }

  /**
   * @param httpRequest
   */
  @Override
  protected String getPrimaryPrincipal(HttpServletRequest httpRequest) {
    return httpRequest.getParameter("user.name");
  }

  /**
   * @param principals
   */
  @Override
  protected void addGroupPrincipals(HttpServletRequest request, 
      Set<Principal> principals) {
    // pseudo auth currently has no assertion of group membership
    // we may want to consider adding group lookup here when available unless 
    // it is an independent provider
  }
}
