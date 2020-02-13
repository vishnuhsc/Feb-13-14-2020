* Create the following table in __training__ database

``` sql
create table cars( id int(4) not null primary key auto_increment, model varchar(40), year int(4), person_id int (4));
```

* Create the entity class for car and repository
* Every person has a collection of cars. So relate the person and car entities using @OneToMany and @ManyToOne, @JoinColumn required

* Create __CarController__ where you define 2 methods 
* Add a car to a person 
* Print all the persons who own atleast one car