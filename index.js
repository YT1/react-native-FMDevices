'use strict';
import React, {
    Component,
    PropTypes,
} from 'react';
import {NativeModules,Platform } from 'react-native';
const RCTFMDeviceApi = NativeModules.FMDevice;
export default class FMDeviceApi{
    //注册值
    static registerFMDevicesresolve(value){
        RCTFMDeviceApi.registerFMDevicesresolve(value);
    }
    //获取返回值
    static getFMDevicesresolve(){
        RCTFMDeviceApi.getFMDevicesresolve().then(
            r=>{
                console.info(r);
            },error=>{
                console.info(error);
            }

        )
    }
}

