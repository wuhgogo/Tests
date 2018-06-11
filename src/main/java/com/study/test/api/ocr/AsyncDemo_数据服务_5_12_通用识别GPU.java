package com.study.test.api.ocr;
/*
* Copyright 2017 Alibaba Group
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;
import com.alibaba.cloudapi.sdk.core.model.ApiCallBack;

public class AsyncDemo_数据服务_5_12_通用识别GPU {

    private AsyncApiClient_数据服务_5_12_通用识别GPU asyncClient = null;

    public AsyncDemo_数据服务_5_12_通用识别GPU() {
        this.asyncClient = AsyncApiClient_数据服务_5_12_通用识别GPU.newBuilder()
                .appKey("your app key here")
                .appSecret("your app secret here")
                .build();
    }

    public void 通用识别GPUDemo(byte[] body) {
        asyncClient.通用识别GPU(body, new ApiCallBack() {
            public void onFailure(ApiRequest request, Exception e) {
                System.out.println("failure");
                e.printStackTrace();
            }

            public void onResponse(ApiRequest request, ApiResponse response) {
                System.out.println("success");
                printResponse(response);
            }
        });
    }

    private static void printResponse(ApiResponse response) {
        try {
            System.out.println("response code = " + response.getStatusCode());
            System.out.println("response content = " + new String(response.getBody(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

