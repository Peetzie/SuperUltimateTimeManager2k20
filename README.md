# SuperUltimateTimeManager2k20
## Gui VS console
The program can run in both console and GUI mode, inside the Backend->Main line 25, set it to true then it will run in console, otherwise per defualt the program runs in GUI mode.
## To sign in
Per default the prgram creates an admin user with the following login details;
UserID : 0
Password : password
## User mode / Admin mode
The program may run in two modes, both admin mode and user mode. 
In admin mode, it is possible to add additional users, and projects, aswell as remove them. 
In user mode, there is another mode build in, the project manager. 
Since its a user can also be a project manager we chose to include theese settings in the menu pr default. 

## Project manager
The project manager has a more complicated menu, where the "quick" settings are directly on the front page. 
For additional settings such as, create activity, please check the "other options" in the bottom. 
On the page of the project manager, a hyperlink is included, for a small guide directly in the program it self. 

## Fixed after the conversation on monday 
After the conversation, we realized that a date check for creating activities and projects was a good idea. 
We implemented a fix, for checking weather the deadline selected is prior to the current date or not. If so it gives a warning. If the user whishes to override and still create a project, the user simply enters a date prior to current date again. 

## Additional features; 
It would be smart to create a storage, so that the program saves the user and projects etc, when closed down. So that the user could restart the program and conteniue working. 
