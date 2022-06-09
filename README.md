# link_mobility_test
This repository contains the solution for the link mobility test.

The solution has one main file which is <b>LinkMobility.java</b>
In this file,e I have put in a static final string to put in <b>MSIDN_CODE</b> so in the future if we want to change the code we can change it.
Also provided static file name which in the particular case is <b>"clients.txt"</b>.
For this class, I call nested methodcallsl to two different classes which are <b>Utility.java</b> and <b>FileOperations.java</b>

As the name gives some idea about the functionality.
<h3>Utility.java</h3> has two methods

<b>converToMSISDN</b>
This method take string <b>phoneNumber</b> as input and returns corresponding <b>MSIDN phoneNumber</b>
For manupilation on the string I am using StringBuilder for this purpose because at the moment we are not in a multithread environment other wise we would have used String buffer which is thread safe. But at the moment we donot have requirement for the multi-threading we can use StringBuilder time effient over StringBuffer over a few hundred milli second.
<br><i><u>Note:</u> Although same could be acheived using String objects but every time we assign or change the values of String it will create a new object in the String pool and hence could be costly operation interms of memory for this particular scenario</i><br>

the second method is <b>convertToMSIDNAndCheckForDuplicates</b>
this method take input as List of Strings as phoneNumbers and the MSIDN_CODE for which the these numbers in the list are to be converted. This method returns us HashMap with key as the phoneNumber and value as the number of times this phone number appeared. I am using hashmap to store the phoneNumber because HashMap will not allow duplicate keys if a key is duplicated we just increment the value and we could easily iterate over this Hashmap to see which phoneNumber how many times in the list.

<h3>FileOperations.java</h3> also has two mehotds

<b>readDataFromFile</b>
This method takes fileName or filePath as input and opens that file in using BufferedReader on top of FileReader to increase the performance of the code and enhace speed.BufferedReader uses buffer to read data and we can also give size for the buffer if required in short it take less trips to the hardDrive to access data then File reader.
So this method takes all the lines as stream and converts it list of String and return it back.

the second methos id <b>writeBackToFile</b>
Now this method again uses buffered writer to write back the results into a file. It takes fileName or filePath as input along with the hashMap generated with the MSIDN phoneNumbers. Now before writing the phoneNumber into the file we are intializing a new map as <b>TreeMap</b>. TreeMap stores sorted data in a tree like structure. Our main purpose is to effiently sort the HashMap and then write values in the map so for this purpose we intialize a new map using TreeMap and pass our already create HashMap into it. Now we have the sorted data in map and we will iteratate over the key set and wirte it into the file in any way we want.In this case we are storing <b>key;value i.e. PhoneNumber;NumberOfAppearances</b>
