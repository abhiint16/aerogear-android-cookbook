/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keycloak.accountprovider.token;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.jboss.aerogear.android.http.HeaderAndBody;
import org.jboss.aerogear.android.impl.http.HttpRestProvider;
import org.keycloak.accountprovider.Keycloak;
import org.keycloak.accountprovider.KeycloakAccount;
import org.keycloak.accountprovider.util.TokenExchangeUtils;

public class AccessTokenExchangeLoader extends AsyncTaskLoader<KeycloakAccount> {


    private final Keycloak kc;
    private final String accessToken;
    private KeycloakAccount account;

    public AccessTokenExchangeLoader(Context context, String accessToken) {
        super(context);
        this.kc = new Keycloak(context);
        this.accessToken = accessToken;
    }

    @Override
    public KeycloakAccount loadInBackground() {
        return TokenExchangeUtils.exchangeForAccessCode(accessToken, kc);
    }

}