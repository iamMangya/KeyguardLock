#import "Keyguard.h"

@implementation Keyguard

- (void)greet:(CDVInvokedUrlCommand*)command
{

    NSString* name = [[command arguments] objectAtIndex:0];
    NSString* msg = [NSString stringWithFormat: @"Hello, %@", name];
     BOOL isPassCodeEnabled = [self deviceHasPasscode];
    if (isPassCodeEnabled) {
        msg = @"true";
    }
    else{
        msg = @"false";
    }
    CDVPluginResult* result = [CDVPluginResult
                               resultWithStatus:CDVCommandStatus_OK
                               messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

-(BOOL) deviceHasPasscode {
    NSData* secret = [@"Device has passcode set?" dataUsingEncoding:NSUTF8StringEncoding];
    NSDictionary *attributes = @{ (__bridge id)kSecClass: (__bridge id)kSecClassGenericPassword, (__bridge id)kSecAttrService: @"LocalDeviceServices",  (__bridge id)kSecAttrAccount: @"NoAccount", (__bridge id)kSecValueData: secret, (__bridge id)kSecAttrAccessible: (__bridge id)kSecAttrAccessibleWhenPasscodeSetThisDeviceOnly };
    
    OSStatus status = SecItemAdd((__bridge CFDictionaryRef)attributes, NULL);
    if (status == errSecSuccess) { // item added okay, passcode has been set
        SecItemDelete((__bridge CFDictionaryRef)attributes);
        
        return true;
    }
    
    return false;
}

@end
