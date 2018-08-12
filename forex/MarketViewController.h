//
//  MarketViewController.h
//  forex
//
//  Created by Su on 2018/8/12.
//  Copyright © 2018年 Su. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "user.h"
@interface MarketViewController : UIViewController
@property(nonatomic,assign) user* User;

@property (weak, nonatomic) IBOutlet UILabel *demo;

@end
