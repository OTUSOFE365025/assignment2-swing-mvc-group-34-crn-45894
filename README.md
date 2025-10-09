[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)
Example of an MVC design based on Swing. Answer questions 1 & 2 in this README file.

Part A 
The swing framework is java is a GUI tool that can be used to create buttons ,tables, text fields and many more components. Swing components are good to use because they are lightweight and more flexible/portable than other GUI’s. The main components in Swing are: JFrame, JDialog, JApplet.

<img width="1209" height="898" alt="image" src="https://github.com/user-attachments/assets/1653e41d-9d12-469c-81c2-9aec2d30887f" />

Part B
The example code in the repository adheres to the Model-View-Controller (MVC) pattern, separating the program into three primary components.

The Model stores and manages the data for the program. It keeps track of products, scanned items, and the subtotal.
The View handles what the user sees on the screen, such as buttons, lists, and labels. It shows information from the model but doesn’t change the data itself.
The Controller connects the model and the view. It listens for user actions, such as pressing the “Scan” button, updates the model, and then instructs the view to refresh and display the new information.

In this particular code, we have the scanner class, which acts like a fake barcode scanner that gives a random product code when the user clicks “Scan.”

This setup matches the idea of MVC from the lecture: the user interacts with the controller, which updates the model, and the view displays the new results. The difference from the traditional MVC pattern that we have discussed in lecture is that here, the controller directly updates the view instead of the model sending notifications automatically. This simpler version works well for Swing programs while still keeping the code organized and easy to understand.


Part D 
<img width="778" height="567" alt="image" src="https://github.com/user-attachments/assets/cc47a621-7e85-4bc0-8901-c59231221144" />


