//
//  forexData.h
//  forex
//
//  Created by Su on 2018/7/30.
//  Copyright © 2018年 Su. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface forexData : NSObject
{
    NSURL *url;

}
-(void)getGBPUSD;
-(NSMutableArray*)dataHandler;
@end
