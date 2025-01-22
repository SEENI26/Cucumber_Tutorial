Feature: To validate the login Functionality of facebook application

Background:
Given To launch the chrome browser and maximise window

Scenario: To validate login with valid username and invalid password
When To launch thr url of the facebook application
And To pass valid username in email field
And To pass invalid password in password field
And To click the login button
And To check whether navigate to the home page or not
Then To close the browser
 
Scenario Outline: To validate the positive and negative combination of login functionality
When User has to hit the Facebook url
When User has to pass the data "<emaildatas>" in email field
And User has to pass the data "<passworddatas>" in password field
But To check the Valid user or not
And User has to click login button
Then User has to close the browser

Examples:
|emaildatas|passworddatas|
|abc@gmail.com|avE34|
|bca@gmail.com|Ceridc@|
|seenian91@gmail.com|sfsfsf%sf|
|Qrsedf@gmail.com|KjhgB34@|