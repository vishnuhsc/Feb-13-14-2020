### Spring Boot with DB

``` sql
create database training;
use training;
create table persons( id int(4) not null primary key auto_increment, name varchar(40), age int(4));
```
 



```
[src]
	[main]
		[java]
		[webapp]
			*.jsp
		[resources]
			[static] -> *.html, *.css, *.js

```

``` java
class Account {
	accountNumber, balance;
	deposit(amount) {
	}
	withdraw(amount) {
	}
	transferFund(to, amount) {}
}

```

``` java
interface AccountHome extends Home {
}
interface AccountRemote extends Remote {
	deposit, withdraw, transferFund
}
class AccountBean implements EntityBean {
	//no constructors
	//no final variables
	//no static methods
	//not throw exceptions
	//not have threading code 
	//no inheritance
}
ejb-jar.xml
	withdraw -> security
	trnasferFund -> transaction
	AccountBean -> Pool of objects

<Account.jar>

```

* Install EJB container like Jboss, WebLogic, WebSphere
* Configure it
* Drop your Account.jar file in it
* Start your server
* It starts working
* Scratching your head





* Object Pooling -> Pool of Account object
* transaction service for transferFund 
* security for withdraw

* DI
* POJO framework or a lightweight container


* Cloud
* NODEJS
* Helps you bootstrap your application development
* abstraction of spring framework
* annotation  