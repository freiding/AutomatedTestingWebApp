# List of tests

***

## Sign In Test
This test is designed to test Sign In function performance

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/signInAnim.gif)

### Actions
  - Open SignIn page
  - Input user email
  - Click button "Next"
  - Input user password
  - Get a username per page, and equals with the original
 
##### Correctness: 100%

***

## Add contact to circle Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/addContactToCircleAnim.gif)

### Actions
  - SignIn()
  - Open circles page
  - Click button "Add new contact"
  - Input user email in "Username or user email" text field
  - Press key "ENTER"
  - Click on selected circle
  - Click on button "Save"
  - Get cirrent number of contacts in selected circle
  - Сheck that there are more than 0
  - Get contacts list
  - Find contact with original name
  - On founded contact click on button "Delete"
 
##### Correctness: 100%

***

## Add new post Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/addPostAnim.gif)

### Actions
  - SignIn()
  - Open startPage
  - Click on textField post message
  - Input text message in opened frame message textField
  - Input for whom in opened frame textField and press key "Enter"
  - Press on button "Share"
  - Get last added post Author and text message
  - Equals their with original
 
##### Correctness: 100%

***

## Add new post to new collection Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/addPostToCollectionAnim.gif)

### Actions
  - SignIn()
  - CreateCollection()
  - AddNewPost()
 
##### Correctness: 100%

***

## Create new circle Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/createCircleAnim.gif)

### Actions
  - Sign()
  - Open circles page
  - Click on circle "Create new circle"
  - Input new circle title in textField "Circle title" on opened frame
  - Click on button "Create empty circle"
  - Equals original title with last circle
  - Get circles list
  - Get last item in list
  - Click on this cirlce
  - Click on button "Delete cirle"
  - In opened frame click on checbox "Confirm" and click on button "Delete this cirlce"
 
##### Correctness: 90%

***

## Create new collection Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/createCollectionAnim.gif)

### Actions
  - SignIn()
  - Open collections page
  - Click on button "Create collection"
  - In opened frame set title and description of collection
  - Click on button "Create"
  - Opens page created collection
  - Get collection title, description and author per page
  - Equals got data with original
  - Click on button collection menu
  - Click on menu item Delete
  - In opened frame click on button "Delete"
 
##### Correctness: 100%

***

## Create new event Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/createEventAnim.gif)

### Actions
  - SignIn()
  - Open events page
  - Click on button "Create event"
  - In frame that opens fill field title, date, time, for whom
  - Click on button "Invite"
  - Opens page created event
  - Get title and author text per page
  - Equlas got data with original
  - Click on button event menu
  - Click on menu item "Delete this event"
  - In opened frame click on button "Delete"
 
##### Correctness: 80%

***

## Join to community Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/joinToCommunityAnim.gif)

### Actions
  - SignIn()
  - Open communities page
  - Input text in search community textField and press key "Enter"
  - Get list founded communities
  - Take first community from list
  - Scroll to this community
  - Click on button "Join" and save joined community title
  - Open communities page 
  - Get list joined communities
  - Equals saved community title with titles got joined communities
  - Open community page with saved title
  - Click on community menu button
  - Click on menu item "Leave this community" 
  - In opened frame click on button "Leave"
 
##### Correctness: 60%

***

## Search Test
Description

![alt tag](https://github.com/freiding/AutomatedTestingWebApp/blob/master/animations/searchAnim.gif)

### Actions
  - SignIn()
  - Open search page
  - Input text in search field and press key "Enter"
  - Get search title
  - Equals got title with original
 
##### Correctness: 100%
