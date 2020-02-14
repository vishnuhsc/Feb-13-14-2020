### Lab04

* __Pair Up__ and implement this exercise, if you want. 

##### Application 01
* Create a Spring boot application running on **8081**
* Accessing **http://localhost:8081** will give you a text box where you enter a word as input 
* On hitting the submit button your application will talk to **http://localhost:8082/{word}**  
* Display the result in the **same page**


##### Application 02

* The **8082** application is another Spring boot application that accepts a word and computes if the given word is a palindrome or not


##### RestTemplate
* Talk to other services using **RestTemplate** class provided by Spring
* Create an instance of **RestTemplate** and use **getForXXX** or **postForXXX** methods

#### Caching
* Enable caching so that if the same word is entered you display the result from the cache

#### Exception Handling
* Bring down the Palindrome service and try. Handle the server down error gracefully using  @ExceptionHandler

#### Note

* We'll discuss configuration files, security, cors in this code