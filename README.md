# uni
Write a Java program using the AWT library that generates an Ulam spiral.
Assumethat the generated spiral will start (be anchored) in the middle of the screen and will bedrawn in the form of a square filling the entire application window.
Because checking whether a number is prime is a costly operation,
make sure thatthe prime numbers for a square with a side length 10 times larger than the applicationwindow being opened are calculated during the first application run.
Save the calculateddata in a binary file according to the following format:
•the first 8 bytes in each line represent how many prime numbers are saved in thatline;
•after 8 bytes, the unsupervised prime numbers are written according to the assump-tion that the first line contains only numbers that require exactly one byte to besaved, the second line contains only numbers that require exactly 2 bytes to besaved, in the third line 3 bytes are required, etc
