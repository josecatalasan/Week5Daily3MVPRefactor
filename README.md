# Week5Daily3MVPRefactor

This application is functionally the same as the Week4Daily3OkHttp application, except it has been refactored into the MVP architecture model. I restructured the packages to conform to the MVP model. The activies were moved into a view package, and subsequently into their own packages.

## MainActivityPresenter
I created a MainActivityPresenter and MainActivityContract to handle the data presented in MainActivity. MainActivity uses the present object that it contains to make the Asynchronous API call using AsyncTask. The AsyncTask makes the call, parses the response into a Java Object using GSON, then passes that Java Object back to MainActivityPresenter. The presenter, uses its instance of MainActivityContract to pass the Java Object to MainActivity, and MainActivity takes the objects and displays its information. I eliminated the use of EventBus from MainActivity and FlickrAsyncTask because it circumvented the purpose of the Presenter. 

## LongClickDialogue and SmallImageDialogue
I moved the Dialogues from the FlickrImagesAdapter to their own classes to further modularize the application.

<img src= "https://github.com/josecatalasan/Week4Daily3OkHttp/blob/master/main.jpg?raw=true" width=300>
<img src= "https://github.com/josecatalasan/Week4Daily3OkHttp/blob/master/fullimage.jpg?raw=true" width=300>
<img src= "https://github.com/josecatalasan/Week4Daily3OkHttp/blob/master/mainSroll.jpg?raw=true" width=300>
<img src= "https://github.com/josecatalasan/Week4Daily3OkHttp/blob/master/dialog.jpg?raw=true" width=300>
<img src= "https://github.com/josecatalasan/Week4Daily3OkHttp/blob/master/smallimage.jpg?raw=true" width=300>
