# Android-based-Real-Estate-Information-Search-Engine-using-Zillow-API
CSCI 571 Web tech Final Project Android platform real estate info search app


1
Homework 9
Android App for Property Search with Facebook posts
1. Objectives
● Become familiar with Eclipse, Android and Facebook
● Use Java code with a combination of the Android SDK and Facebook SDK
● Provide an interface to post text and pictures to Facebook.
2. Background
2.1 Eclipse
Eclipse is an open source community, whose projects are focused on building an open development platform comprised of extensible frameworks, tools and runtimes for building, deploying and managing software across the lifecycle.
The Eclipse Project was originally created by IBM in November 2001 and supported by a consortium of software vendors. The Eclipse Top-Level Project is an open source, robust, full-featured, commercial-quality, industry platform for the development of highly integrated tools and rich client applications. The home page of the Eclipse Foundation is located at:
http://www.eclipse.org/
2.2. Android
Android is a mobile operating system initially developed by Android Inc., a firm purchased by Google in 2005. Android is based upon a modified version of the Linux kernel. Android dominates the world mobile operating system market share by a large margin.
The Android operating system software stack consists of Java applications running on a Java based object oriented application framework on top of Java core libraries running on the Dalvik virtual machine featuring JIT compilation (for versions <= Android 4.4 KitKat) and the ART runtime from Android 5.0. The Official Android home page is located at: http://www.android.com/. The Official Android Developer home page is located at: http://developer.android.com/index.html
2.3 Facebook
Facebook is a social networking service launched in February 2004, owned and operated by Facebook, Inc. Users can add friends and send them messages, and update their personal profiles to notify friends about themselves and what they are doing.
Users can additionally post news feeds to their profiles, and these feeds may include images, besides text messages.
The Facebook homepage is available at: http://www.facebook.com. Facebook provides developers with an application-programming interface, called the Facebook Platform.
2
3. Prerequisites
This homework requires the use of the following components:
1. Download and install Eclipse. For windows users, first you need to install Java on your local machine. You can download JDK 7 from -http://www.oracle.com/technetwork/java/javase/downloads/index.html. After installing the JDK, you need to add environment variables for JDK.
○ Properties -> Advanced -> Environment Variables -> System variables -> New Variable
Name: JAVA_HOME, Variable Value: <Full path to the JDK>
○ Typically, this full path looks something like C:\Program Files\Java\jdk1.7.0. Then modify the PATH variable as follows on Microsoft Windows: C:\WINDOWS\system32;C:\WINDOWS;C:\Program Files\Java\jdk1.7.0\bin
This path may vary depending on your installation.
○ Note: The PATH environment variable is a series of directories separated by semicolons (;) and is not case-sensitive. Microsoft Windows looks for programs in the PATH directories in order, from left to right. You should only have one bin directory for a JDK in the path at a time. Those following the first instance are ignored. If you are not sure where to add the path, add it to the right of the value of the PATH variable. The new path takes effect in each new command window you open after setting the PATH variable.
○ Reboot your computer and type “java –version” in the terminal to see whether your JDK has been installed correctly.
For Mac OS X users up to Lion and Linux users, you already have Java and the JDK installed with the OS. For Mac OS X users with Mountain Lion or Mavericks, which do not come with Java built in,, the first time you try to load a webpage or run an app that requires Java, Mountain Lion and Mavericks will prompt you to download and install the Java runtime, even if you already had Java installed under the previous version of OS X. You will also have to download JDK 7, as described in step 1 above. After installing JDK, you can download Eclipse from http://www.eclipse.org/downloads/. Any one of the latest versions should be fine.
2. Download and install the Android SDK in eclipse. Instructions on how to download and install both are available on the http://developer.android.com/sdk/installing/index.html. You need first download the SDK and then install the Eclipse plugin for Android. Finally make the plugin point to where you save the SDK.
3. Download the latest Facebook Android SDK 3.5.2 and register your application. The download and installation instructions are at
http://developers.facebook.com/android/.
3
4. You also need to create a Facebook Developer application as you did for your homework8: go to https://developers.facebook.com/docs/android/getting-started/ and follow the 5th step.
After registering as a Facebook developer, create a new application and click Allow it to access your information. Then click Set Up New Application. Name the application, agree to the terms, and click on Create Application. In the following windows keep all the defaults and click Save Changes. See the sections “Creating Your Facebook Application” and “Configuring Basic Settings”. In the window that displays next, you should see the Application ID (see figure below) that you will have to use with the Android Facebook SDK.
For the Android key hash, you have to run the following command:
-exportcert -alias androiddebugkey -keystore ~/.android/debug.keystore | openssl sha1 -binary | openssl base64
This works for Linux and Mac users. For Windows users, you should download openssl to do this. You can refer the blog http://sonyarouje.com/2011/09/18/facebook-hash-key-for-android-apps.
There is another interesting way to get it programmatically if you are interested:
http://stackoverflow.com/questions/5306009/facebook-android-generate-key-hash
4. Description of the Exercise
In this exercise, you will implement an Android Mobile application (hereby the “app”) that ports the Homework 8 web interface to a mobile interface. The app does the following sequence of actions:
1. Initial User Interface: Provide an Android Activity (page) to take Address, City, and State as input. The Address and City fields are text boxes, while the “State” field is a dropdown menu selector (called Spinner in Android). The fields should all be marked as compulsory (*) and appropriate text hints should be provided in the textbox.
A “Powered by Zillow” logo with the appropriate link to the Zillow website should be at the bottom right. Sample screenshot is shown in Figure 1.
2. When the “Search” button is tapped, error checking is done, and on valid input, the JSON result from the PHP file located on your AWS server is returned. On all valid input, another activity should show the results page, which is a tabbed interface(shown in Figure 2 to the right above).
Pressing the “Back” button of android should take you to the first user interface, to take the next query. You may retain the last query inputs to make things easier, but it is not compulsory.
4
Figure 1 - User Interface Figure 2 - Results
3. The Basic Info Tab:
This should have a scrollable list detailing all the information about the property as shown. Scrolling down will reveal further info as shown below in Figure 3.
The footer with terms of service, copyright notice and “What‟s a Zestimate link” should always be visible. In other words, only the info section should scroll, not the whole page. All text shown in blue (underlined) namely address, „Terms of Use‟ and „What‟s a Zestimate?‟ are active links as in HW8.
The numbers for all monetary values and Lot Size and Finished Area must be comma-separated as done in HW8. The info names must be left-justified, and the values right-justified as shown.
As in HW8 If any of the field is unavailable, you should show “N/A” instead or an empty field. Note that if the lastSoldPrice is 0.00 and lastSoldDate is 01-Jan-1970, it indicates that Zillow doesn‟t have that information and it should be shown as “N/A”. Appropriate UP/DOWN arrows must be shown with the fields shown as below –
5
Figure 3 - Scrolled down to reveal further info
4. Facebook: There should be a button at the top-right of the “Basic Info” tab which is a Facebook share button (as shown in Figure 2). Clicking on it will allow one to post the property details on Facebook. Facebook handles the first time logins if required
The pop up window that first appears should also have an option to cancel the action, along with posting on Facebook.
The information posted to Facebook is the same as in homework 8 - The Address, with details of its last sold price and 30 days overall change, with any of the corresponding chart as the image.
On successful posting (or failure), appropriate short “Toast” messages should be shown at the bottom („Posted Story, ID: XXXXX..‟ for successful post or „Post Cancelled‟). You may also use pop-up windows/dialog boxes to show the same. See the screenshots below for examples:
6
Figure 4: Facebook: on Click Figure 5: On “Post”
Figure 6: On Success Figure 7: On Failure/Cancel click
7
5. Historical Zestimates Tab:
The second and only other tab must show the images of the Zestimate charts. You may use ImageSwitcher and TextSwitcher implementation to make only one chart image at a time and corresponding text label to be shown. Clicking on NEXT or PREVIOUS buttons should switch to the appropriate charts.
A sample implementation of ImageSwitcher is shown below.
Fig. 7 - Historical Zestimate Charts Tab (Initial and on clicking Next)
6. Error handling:
a. Empty Fields: If any of the text boxes are empty, or the State is not selected, “This field is required” or similar text should be posted below the box in red or other warning color as shown. The current inputs (such as the filled address in the example below) must be maintained in all such cases.
8
b. Invalid Input: If any of the values are invalid, or there were no matches found by the Zillow API (PHP), then input values must be retained, but the error message should be shown at the bottom as shown in the figure to the right below.
The results page must be shown only on valid JSON results. You may ignore the settings button at the top right for the app (three dots)
Figures 8-10
Empty /Unselected Fields Invalid Input Valid Input
5. Implementation Hints
● Facebook offers multiple APIs for you to upload or request data. In this HW
implementation, you need to use 2 Facebook APIs (Session authentication and
Feed Dialog).
● The tutorial of Session Authentication is too complicated on the website.
However, you can refer to the sample project “SessionLoginSample” after importing the Facebook SDK and all sample projects. You can also learn more about sharing on Facebook at https://developers.facebook.com/docs/android/share or for the deprecated api(okay to use) see: https://developers.facebook.com/docs/sharing/reference/feed-dialog/v2.2.
The basic logic is to create a new session and set it active. Then open the session
with UI. Put your post method in the callback of opening the session.
● You need to use AsyncTask class to fetch the JSON data/ Chart images in background in order to avoid any Android not responsive error.
● To better understand how Facebook Feeds work, you can read this page:
http://wiki.developers.facebook.com/index.php/Feed
9
6. Materials to submit:
Unlike other exercises, for this HW you will have to “demo” your submission “in person” during a
special grading session. Details and logistics for the demo will be provided in class, in the
Class website and in Piazza.
For sections #1 and DEN (Prof. Horowitz’s), as an alternative to demoing your solution you may instead create a video of your solution and upload it to YouTube, providing a link on your homework page. Instructions for creating the video can be found on the Assignments page of the course website.
For sections #2 and #3 (Prof. Papa’s), demoing the solution during the demo session is a requirement, and submitting by video is not allowed.
You must also ZIP your Android source directory and SUBMIT the resulting ZIP file.
Make sure that the source path does not include the .apk binary file.
