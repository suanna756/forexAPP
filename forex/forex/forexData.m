//
//  forexData.m
//  forex
//
//  Created by Su on 2018/7/30.
//  Copyright © 2018年 Su. All rights reserved.
//

#import "forexData.h"

@implementation forexData
-(void)getGBPUSD{
    /*set the url to visit*/
    
    /*build the request
     initWithURL : the url you are going to visit
     cachePolicy : the cache strategy(6 in total)
     timeoutInterval : specify the time limitation
     */

  /*  NSURLRequest *request = [[NSURLRequest alloc] initWithURL:url cachePolicy:NSURLRequestUseProtocolCachePolicy timeoutInterval:10];
   
    NSData *received = [NSURLConnection sendSynchronousRequest:request returningResponse:nil error: nil];
    NSLog(@"%@",received); 
   */
    NSError *error;
/*    NSString *url = [NSString stringWithFormat:@"https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=GBP&apikey=ZP6SWN37QBLNACU5"];
    NSData *data = [NSData dataWithContentsOfURL:[NSURL URLWithString:url]];
    NSMutableArray *json = [NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:&error];
    NSLog(@"%@",json);
 */
    
    
    NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:@"https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=GBP&apikey=ZP6SWN37QBLNACU5"]];
    NSData *response = [NSURLConnection sendSynchronousRequest:request returningResponse:nil error:nil];
   // NSDictionary *Dic = [NSJSONSerialization JSONObjectWithData:response options:NSJSONReadingMutableLeaves error:&error];
    
   // NSLog(@"%@",[Dic objectForKey:@"Realtime Currency Exchange Rate"]);
    
    
}

-(NSMutableArray*)dataHandler:(id)response{
    NSMutableArray *result;
    NSString *str = [[NSString alloc] initWithData:response encoding:NSUTF8StringEncoding];
    NSMutableArray *array = [str componentsSeparatedByString:@"        "];
    NSMutableArray *array2 = [array[5] componentsSeparatedByString:@"\""];
    NSMutableArray *array3 = [array[6] componentsSeparatedByString:@"\""];
    NSString *price = array2[3];
    NSMutableArray *rawtime = [array3[3] componentsSeparatedByString:@" "];
    NSString *date = rawtime[0];
    NSString *time = rawtime[1];
    [result addObject:price];
    [result addObject:date];
    [result addObject:time];
    return result;
}

@end
