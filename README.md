# EasyPrefs
Easiest way ever for using SharedPreferences on Android.

## Usage

```java

// Initialization
EasyPrefs easyPrefs = new EasyPreferences(this, "AppPrefs", MODE_PRIVATE);

// Saving
easyPrefs.store("anyKey", ANY_DATA);

// Getting
THE_REAL_DATA_TYPE data = easyPrefs.get("anyKey", DEFAULT_VALUE);

// Deletes all the saved Data
easyPrefs.reset();

```

## Example

```java

//Initialization, MODE_PRIVATE is default
EasyPrefs easyPrefs = new EasyPreferences(this, "AppPrefs");

// Saving Data
easyPrefs.store("USER_FULL_NAME", "John Doe");
easyPrefs.store("IS_FIRST_LAUNCH", true);

// Getting Data
String username = easyPrefs.get("USER_FULL_NAME", "none");
boolean is_firstLaunch = easyPrefs.get("IS_FIRST_LAUNCH", false);
```

For an example, please check the MainActivity class in the provided Sample App.

## License
```
MIT License

Copyright (c) 2019 yashDev

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
```
EasyPrefs uses the [GSON](https://github.com/google/gson) library, which is released under the [Apache license](https://github.com/google/gson/blob/master/LICENSE). 