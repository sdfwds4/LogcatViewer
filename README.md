[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-LogcatViewer-green.svg?style=true)](https://android-arsenal.com/details/1/3463)  [![](https://jitpack.io/v/fatangare/LogcatViewer.svg)](https://jitpack.io/#fatangare/LogcatViewer)

# LogcatViewer - Android Logcat Viewer

## Purpose
LogcatViewer is utility library which will allow user to view the logcat logs of the application on phone itself.   
It will be useful for tester to provide logs along with defects and also to developer to do initial analysis of defects.  
Moreever, if correct tags are used, it can also be useful for performance measurement, for monitoring network requests etc. etc.  

#### How to plug LogcatViewer in your application?

Add following line to build.gradle.
```
repositories {
    maven {     
        url "https://jitpack.io"    
    }    
}  

dependencies { 
    debugImplementation 'com.github.sdfwds4:LogcatViewer:1.1'
    }
```

*That's all!*  
  
It will launch floating window which will show logcat logs of the application.   
![mainview](https://github.com/fatangare/LogcatViewer/blob/master/Images/mainview.png)  
Since it is floating window, user can play around with the application while viewing logcat logs.  

#### Operations which can be done in LogcatViewer:
1. Pause/Resume - Pause/Resume listening to logcat logs
2. Stop/Start Recording - Recording to file starts automatically when the viewer is launched. File is stored in android.os.Environment.DIRECTORY_DOWNLOADS+ "/LogcatViewer/"+ getPackageName() directory.
It take filter-text used before recording is started. Any change to filter-text during recording will not update filter-text used for recording.
To apply new filter-text for recording, new recording should be started.
3. View saved log files - Here you can share or delete log files saved on the device. (Bear in mind logs are written to file at 5s intervals).
4. Enter filter text - Filter logs by filter text. It can be tag, package name or some text.
5. Select log level - Filter logs by log level.
6. Reset - Show all logcat logs.      

#### More screenshots
###### Enter Filter text       
![filter](https://github.com/smithaaron/LogcatViewer/blob/master/Images/filter.png)   
###### Select log level
![loglevel](https://github.com/fatangare/LogcatViewer/blob/master/Images/loglevel.png)  
###### Notification
![loglevel](https://github.com/fatangare/LogcatViewer/blob/master/Images/notification.png)    
