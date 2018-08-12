//
//  user.h
//  forex
//
//  Created by Su on 2018/8/11.
//  Copyright © 2018年 Su. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface user : NSObject
{
    NSString* username;
    NSString* password;
}
-(void)setName:(NSString*) username setCode:(NSString*) password;

@end
