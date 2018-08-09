//
//  clientSocket.h
//  forex
//
//  Created by Su on 2018/8/5.
//  Copyright © 2018年 Su. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface clientSocket : NSObject
{
    int clientsocket;
}
-(int)connect;
-(int)sendmessage: (NSString*)command;
-(int)receivemessage:(NSString*)command;
@end
