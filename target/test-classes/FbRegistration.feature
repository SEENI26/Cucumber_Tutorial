Feature: To validate the account creation for Facebook application

Scenario: To create New Account
Given To launch the browser and maximise the window
When To launch Url of FB application
And To click the create new account button

# one dimensional map data
And To pass firstname in the firstname text field
#key  Value
|firstname|samuel|
|firstname1|seeni|
|firstname2|sai|

And To pass secondname in the surname text field
# Two dimensional map data 
And To pass mobile number or email in the email text box
|email1|email2|email3|
|abc$%23|GHtree4&|kneew87&|
|lhjteer$@|dascsc67$|cjsckf98)|
|Kyfhb%|jvbvky82&|gsjcc%^|
And Create a new password in the New Password text box

Then To close the Chrome browser

