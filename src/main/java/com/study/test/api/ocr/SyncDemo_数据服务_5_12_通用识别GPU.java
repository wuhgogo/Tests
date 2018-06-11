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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import com.alibaba.cloudapi.sdk.core.model.ApiResponse;

import sun.misc.BASE64Encoder;

public class SyncDemo_数据服务_5_12_通用识别GPU {

    private SyncApiClient_数据服务_5_12_通用识别GPU syncClient = null;

    public SyncDemo_数据服务_5_12_通用识别GPU() {
        this.syncClient = SyncApiClient_数据服务_5_12_通用识别GPU.newBuilder()
                .appKey("24909239")
                .appSecret("712b5514462b6938dfccace328eb4c14")
                .build();
    }

    public void 通用识别GPUDemo(byte[] body) {
        ApiResponse response = syncClient.通用识别GPU(body);
        printResponse(response);
    }

    private static void printResponse(ApiResponse response) {
        try {
            System.out.println("response code = " + response.getStatusCode());
            System.out.println("response content = " + new String(response.getBody(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {
    	//获取图片文件
    	File imgFile = new File("C:\\Users\\wuh\\Desktop\\test2.jpg");
    	//获取图片文件流
    	FileInputStream imgFileIn = new FileInputStream(imgFile);
    	//定义字节数组对象
    	byte[] imgBytes = new byte[1024];
    	//定义字节数组输出流
    	ByteArrayOutputStream imgByteArrayOs = new ByteArrayOutputStream();
    	int len = -1;
    	while((len = imgFileIn.read(imgBytes))!=-1) {
    		imgByteArrayOs.write(imgBytes, 0, len);
    	}
    	//获取照片base64码
    	BASE64Encoder encoder = new BASE64Encoder();
    	String imgBase64Str = encoder.encode(imgByteArrayOs.toByteArray());
    	//构造请求参数
    	String reqParamText = "{" + 
    			"   \"image\":    \""+imgBase64Str+"\", " + 
    			"	\"configure\":\"{" + 
    			"               \\\"min_size\\\" : 16," + 
    			"	      \\\"output_prob\\\" : true" + 
    			"          }\"" + 
    			"}";
    	String reqParamExcel = "{" + 
    			"  \"image\": \""+imgBase64Str+"\",\n" + 
    			"  \"configure\": \"{\\\"format\\\":\\\"html\\\", \\\"finance\\\":false, \\\"dir_assure\\\":false}\"" + 
    			"}";
    	new SyncDemo_数据服务_5_12_通用识别GPU().通用识别GPUDemo(reqParamText.getBytes());
//    	new SyncDemo_数据服务_5_17_表格识别().数据服务_5_17_表格识别Demo(reqParamExcel.getBytes());
    }
}

