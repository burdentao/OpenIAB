/*******************************************************************************
 * Copyright 2013 One Platform Foundation
 *
 *       Licensed under the Apache License, Version 2.0 (the "License");
 *       you may not use this file except in compliance with the License.
 *       You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *       Unless required by applicable law or agreed to in writing, software
 *       distributed under the License is distributed on an "AS IS" BASIS,
 *       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *       See the License for the specific language governing permissions and
 *       limitations under the License.
 ******************************************************************************/

package org.onepf.life2.oms.appstore;

import android.content.Context;
import android.util.Log;
import com.amazon.inapp.purchasing.BasePurchasingObserver;
import com.amazon.inapp.purchasing.PurchasingManager;

/**
 * Author: Ruslan Sayfutdinov
 * Date: 16.04.13
 */
public class AmazonAppstoreObserver extends BasePurchasingObserver {

    private final String TAG = "Life";
    private final AmazonAppstoreBillingService mBillingService;

    AmazonAppstoreObserver(Context context, AmazonAppstoreBillingService billingService) {
        super(context);
        mBillingService = billingService;
    }

    @Override
    public void onSdkAvailable(final boolean isSandboxMode) {
        Log.v(TAG, "onSdkAvailable recieved: Response - " + isSandboxMode);
        if (!isSandboxMode) {
            mBillingService.setIsInstaller(true);
            PurchasingManager.initiateGetUserIdRequest();
        }
    }
}
