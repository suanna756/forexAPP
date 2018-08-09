//
//  clientSocket.m
//  forex
//
//  Created by Su on 2018/8/5.
//  Copyright © 2018年 Su. All rights reserved.
//

#import "clientSocket.h"
#import <sys/socket.h>
#import <netinet/in.h>
#import <arpa/inet.h>
#import <unistd.h>
@implementation clientSocket
-(int)connect{
//create the client socket
    clientsocket = socket(AF_INET,SOCK_STREAM,0);
    /*AF_INET for ipv4;SOCK_STREAM for TCP,SOCK_DGRAM for udp;0 for selecting the parameter according to last parameter*/

    if(clientsocket>0)
        NSLog(@"client socket created");

//connect the client socket to server socket
    struct sockaddr_in addr;
    addr.sin_family = AF_INET;
    addr.sin_port = htons(10086);
    addr.sin_addr.s_addr = inet_addr("127.0.0.1");
    
    int isConnected = connect(clientsocket, (const struct sockaddr *)&addr, sizeof(addr));
    if(isConnected == 0){
        NSLog(@"connection created");
    }


    
    return 0;


}
-(int)sendmessage :(NSString*)command{
    //send message
    NSString *message = [[NSString alloc]initWithFormat:command];
    int s = send(clientsocket,message.UTF8String,strlen(message.UTF8String),0);
    NSLog(@"%d",s);
   // close(clientsocket);
  //  close(clientsocket);
    return 1;
}


-(int)receivemessage:(NSString*)command{
    // build the buffer block
    uint8_t buffer[1024];
    // build the container for the message data
    NSMutableData *dataM = [NSMutableData data];
    
    // receive the message data from the server
    ssize_t recvCount = -1;
  
    recvCount = recv(clientsocket, buffer, sizeof(buffer), 0);
    NSLog(@"the received data length %ld",recvCount);
    [dataM appendBytes:buffer length:recvCount];
    NSString *servermessage = [[NSString alloc] initWithData:dataM encoding:NSUTF8StringEncoding];
    NSLog(@"%@",servermessage);
    if([servermessage isEqualToString:command])
        return 1;
    // 5.关闭Socket
   // close(clientsocket);
    else
    return 0;
}
@end
