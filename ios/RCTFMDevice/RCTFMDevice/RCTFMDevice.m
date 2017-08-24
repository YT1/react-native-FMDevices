//
//  RCTFMDevice.m
//  RCTFMDevice
//
//  Created by Dowin on 16/12/14.
//  Copyright © 2016年 Dowin. All rights reserved.
//

#import "RCTFMDevice.h"
#import "RCTUtils.h"
#import "RCTConvert.h"
@implementation RCTFMDevice
{
    FMDeviceManager_t *manager;
}
@synthesize bridge = _bridge;

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()
//初始化
RCT_EXPORT_METHOD(registerFMDevicesresolve:(nonnull NSDictionary *)options)
{
    manager = [FMDeviceManager sharedManager];
    manager ->initWithOptions(options);
}
//取值
RCT_EXPORT_METHOD(getFMDevicesresolve:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)
{
    NSString *blackBox = manager->getDeviceInfo();
    resolve(blackBox);
}
@end
