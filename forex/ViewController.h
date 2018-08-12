//
//  ViewController.h
//  forex
//
//  Created by Su on 2018/7/30.
//  Copyright © 2018年 Su. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "clientSocket.h"
@interface ViewController : UIViewController
{
    
    __weak IBOutlet UITextField *username;
    
    __weak IBOutlet UITextField *password;
    
    __weak IBOutlet UIButton *registerButton;
    __weak IBOutlet UIButton *loginButton;
    NSString *userName;
    NSString *passWord;
    
    clientSocket *clientsocket;
    
}

- (IBAction)register:(id)sender;
- (IBAction)login:(id)sender;




@end

