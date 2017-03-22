# Cordova Hello World Plugin

Simple plugin that returns weather keyguard lock is enabled or not



Create a new Cordova Project

    $ cordova create Keyguard 
    
Install the plugin

    $ cd Keyguard
    $ cordova plugin add https://github.com/iamMangya/KeyguardLock
    

Edit `www/js/index.js` and add the following code inside `onDeviceReady`

```js
    var success = function(message) {
        alert(message);
    }

    var failure = function() {
        alert("Error calling Hello Plugin");
    }

    keyguard.greet("World", success, failure);
```

Install iOS or Android platform

    cordova platform add ios
    cordova platform add android
    
Run the code

    cordova run 