FindStems-FarmersFridge contains source code for FindStems application.

Source code contains 3 XML files(1 for main activity, 1 for each of the 2 fragments), 5 java files(1 for main activity, 1 for getStems algorithm, 1 for SectionsPageAdapter, and 1 for each of the 2 fragments), and additional files needed to run the app (prepopulated in Android Studio).

Libraries/Frameworks Used:
java.util.*;

Overview:
  This app is created in Android Studio with the intention of running on Android Devices.
  
  In the first fragment, Enter Words, the user can enter an input into the EditText region, and click Enter to see the stems generated for each word.
  In the second fragment, See Stem History, the user can click on Get History to see the frequencies of all past searches. The user can also click Clear     Search History to stem data that had been collected prior.
  
  MainActivity.java: 
    Sets up the ViewPager, and controls the Fragment1Listener which sends the stems generated in the user entry to the Map that holds the history.
  
  Word.java:
   Contains the static method that runs the algorithm to find the stems given a word. Using recursion, the original word is first considered a stem word,      no matter if it contains a suffix(e.g. "jelly" contains "ly" but "jelly is still the root word). THen, it is put into a series of if statements that        check the different suffixes given by Farmer's Fridge. If one or multiple of them matches, the method is recursivily called using the modified word as      the paramater(if modified word contains the removal of the suffix, or an addition of new characters depending on the suffix rule). All generated stems      are returned in a Set<String> that can be called by the user. Fragment 1, Enter Words, calls this static method to generate the stems.
  
  Tab1Fragment.java:
   Contains the interface of Fragment1Listener, which sends the generated stems to fragment 2. Tab1Fragment.java also contains the code for when the Enter    button is clicked. OnClick Tab1Fragment will build an array of all words entered in EditText(uses split(" ") to break up the input into words). Each        word is treated as all upperclass characters to simplify the Word.getStems method. Tab1Fragment.java runs Word.getStems on each of the entered words in    the array, and prints the stems. It also uses the listener to send all generated stems to fragment 2.
  
  Tab2Fragment.java:
   Initializes a HashMap that will be used to store all stem searches and their frequencies. Contains the OnClick implementation for the Clear Search          History button which clears the HashMap and resets the text on screen to an empty text box. Contains the OnClick implementation for the Get History        button, which prints the stem and its frequency for each Entry in the Map. Contains the updateHistory method, which is called in MainActivity and          retrieves the data from the Fragment1Listener and for each stem in the List<String> sent to fragment 2, updates the Map with that stem.
  
  SectionsPageAdapter.java:
    Builds the page adapter, which sets the screen to the current fragment. Implements getPageTitle, getItem, getCount, and addFragment. addFragment is called twice in ActivityMain to initialize the 2 fragments.
  
  XML Files:
    Contains the layout of each screen. Contains XML code for buttons, editText, and textView objects in each screen.
 

Setup and Execution:
  1) Download and open Android Studio. 
  
  If using online Git repository:
  2) Open Android Studio, and go to File > New > Project from Version Control
  3) Select Git from dropdown menu
  4) Paste the link of this repository's URL, and the directory to clone it into (directory should be in AndroidStudioProjects). Click Clone.
  
  If using zip repository:
  2)Select File > Open and locate where you have stored the zip file
  
  Execute on Virtual Emulator:
    1) Click on the green pick axe icon to build the function.
    2) Make sure you have an emulator in your Android Studio. To check, click on the phone icon in the top right. This brings use to the Device Manager. If        no emulators appear, click on Create Device and follow the steps to create a new emulator. **The layout of this app is set to fit Pixel phones**
    3) Click on the play icon to run the app. You can now use the app in the emulator.
  
  Execute on Physical Device:
    1) In the Device Manager, select the Physical tap to pair a physical phone. Click the Pair Using Wifi button and follow the steps to pair an Android          phone.
  
    



