//
//  ViewController.m
//  forex
//
//  Created by Su on 2018/7/30.
//  Copyright © 2018年 Su. All rights reserved.
//

#import "ViewController.h"
#import "clientSocket.h"
#import <sys/socket.h>
#import <netinet/in.h>
#import <arpa/inet.h>
#import "MarketViewController.h"
#import "user.h"
@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    clientsocket = [[clientSocket alloc] init];
    [clientsocket connect];
    //[clientsocket sendmessage:@"hello there\n"];
    
    // Do any additional setup after loading the view, typically from a nib.
    username.placeholder = @"username";
    password.placeholder = @"password";
    //make the password hiden from the screen
    password.secureTextEntry = YES;
    
    
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void) touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event{
    //withdraw the keyboard
    [username resignFirstResponder];
    [password resignFirstResponder];
    
}
- (IBAction)register:(id)sender {
    userName = username.text;
    passWord = password.text;
    /*sender to server part*/
    NSString* m = [[NSString alloc] initWithFormat:@"register,%@,%@\n",userName,passWord];
    [clientsocket sendmessage:m];
    /*get response from the server*/
    if( [clientsocket receivemessage:@"register successful\n"]){
        /*the notice window*/
        UIAlertView* notice = [[UIAlertView alloc] initWithTitle:@"notice" message:@"register successful" delegate:nil cancelButtonTitle:@"ok" otherButtonTitles:nil];
        [notice show];
    }
    
    else{
        UIAlertView* notice = [[UIAlertView alloc] initWithTitle:@"notice" message:@"the username already exists" delegate:nil cancelButtonTitle:@"ok" otherButtonTitles:nil];
        [notice show];
    }
}

- (IBAction)login:(id)sender {
    
    userName = username.text;
    passWord = password.text;
    
    /*sender to server part*/
    NSString* m =[[NSString alloc] initWithFormat:@"login,%@,%@\n",userName,passWord];
    [clientsocket sendmessage:m];
    /*get response from the server*/
    
    if([clientsocket receivemessage:@"login successful\n"]){
        
        /*the notice window*/
        //    UIAlertView* notice = [[UIAlertView alloc] initWithTitle:@"notice" message:@"login successful" delegate:nil cancelButtonTitle:@"ok" otherButtonTitles:nil];
        //  [notice show];
        //[self performSegueWithIdentifier:@"loginSegue" sender:self];
        
        
        //init the user
        user* User = [[user alloc] init];
        [User setName:userName setCode:passWord];
        //init the marketViewController
        
        //because u create the biew from storyboard,so u can only load the view from storyboard
        //the storyboardname is Main.storyboard
        //the identifier is the storyboard id u set in storyboard
        MarketViewController* marketView = [[UIStoryboard storyboardWithName:@"Main" bundle:nil] instantiateViewControllerWithIdentifier:@"marketviewcontroller"];
        [marketView setUser:User];
        [self.navigationController pushViewController:marketView animated:YES];
        
        NSLog(@"market view");
        NSLog(@"%@",self.navigationController);
        
    }
    else{
        /*the notice window*/
        UIAlertView* notice = [[UIAlertView alloc] initWithTitle:@"notice" message:@"wrong username or password" delegate:nil cancelButtonTitle:@"ok" otherButtonTitles:nil];
        [notice show];
    }
}
@end
