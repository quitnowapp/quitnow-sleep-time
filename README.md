[![Build Status](https://travis-ci.org/Fewlaps/quitnow-sleep-time.svg?branch=master)](https://travis-ci.org/Fewlaps/quitnow-sleep-time)
[![Coverage Status](https://coveralls.io/repos/github/Fewlaps/quitnow-sleep-time/badge.svg?branch=master)](https://coveralls.io/github/Fewlaps/quitnow-sleep-time?branch=master)

# [QuitNow!](http://quitnowapp.com)'s sleeping time
Be sure that your user is awake before disturbing it with soundy and vibrant notifications!

Before this library, QuitNow! and lots of apps were sending notifications when the user was sleeping... and HEY! That makes people angry. So, before setting the sound of that notifications and asking the phone to vibrate arround five minutes, write this lovely line:

```java
new SleepingTime().isSleepingTime();
```

We've done it using TDD, so it's totally tested. [Check the tests!](https://github.com/Fewlaps/quitnow-sleep-time/tree/master/src/test/java/com/fewlaps/quitnowsleepingtime) :·)

The sample
----------

```java
SleepingTime st = new SleepingTime(); //By default, it uses the Locale of the phone
st.isSleepingTime(); //Is it a bad moment to do noise?
st.getBedtime(); //The average bedtime of the user's country, based in its Locale
st.getWakeUp(); //The average wake up of the user's country, based in its Locale

new SleepingTime("es")).isSleepingTime(); //You can also force a country code
```

# Download

* Get <a href="https://github.com/Fewlaps/quitnow-sleep-time/releases/download/v1.0/quitnow-sleeping-time-1.0.0.jar">the latest .jar</a> 

* Grab via Gradle:
```groovy
repositories { jcenter() }
    
compile 'com.fewlaps.quitnowsleepingtime:quitnow-sleeping-time:1.0.0'
```
* Grab via Maven:
```xml
<repository>
  <id>jcenter</id>
  <url>http://jcenter.bintray.com</url>
</repository>

<dependency>
    <groupId>com.fewlaps.quitnowsleepingtime</groupId>
    <artifactId>quitnow-sleeping-time</artifactId>
    <version>1.0.0</version>
</dependency>
```


## LICENSE ##

The MIT License (MIT)

Copyright (c) 2015 Fewlaps

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
