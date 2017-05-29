Java
====

Cloning Objects
---------------
There are an issue with cloning objects, it could lead to unwanted behavior when 
manipulating the cloned object. There is a difference between shallow and deep clone.
A deep clone should be independent of the source.  
There are several ways to deep clone an object. An easy way is to use
[DeepClone](https://github.com/kostaskougios/cloning/)

```java
    /**
     * Deep clone a list with any type of objects.
     * @param sourceList
     * @return destionationList
     */
    public static <T> List <T> deepCloneList (List<T> sourceList) {
        List<T> destinationList = new ArrayList<T>();
        Cloner clone = new Cloner();
        destinationList = clone.deepClone(sourceList);
        return destinationList;
    }
```
Another way could be to add a clone method in the class that you want to duplicate,
like the one below.

```java
public class Requirement implements Comparable<Requirement> {

    public Double ReqX;
    public Double ReqY;
    public String ReqTypeY;

    public Requirement() {
    }
    /**
     * Used for cloning objects.
     * @param requirement
     */
    public Requirement (Requirement requirement) {
        this.ReqX = requirement.ReqX;
        this.ReqY = requirement.ReqY;
        this.ReqTypeY = requirement.ReqTypeY;
    }

    /*
     * Creates a clone of the current object.
     */
    public Requirement clone () {
        return new Requirement(this);
    }
```
It is the used in the following way.
```java
    public class testMethod {
        /*
        * Returns a copy of the TestResult List
        */

        private List<TestResult> copyTestResult (List<TestResult> resultList) {
            List<TestResult> copyOfResultList = new ArrayList<TestResult>(resultList.size());
            for (TestResult reqItem : resultList) {
                copyOfResultList.add(reqItem.clone());
            }
            return copyOfResultList;
        }
    }
```

Builder Pattern
---------------
When the user want to initialize different amount of fields from one time to another it is benefitial to use the Builder pattern. Specially if the object has many attributes.
If you are able to make the object immutable the class will need a constructor for each possbile combination of fields that you want to set. With the builder pattern this will not be necessary.
So the builder will build different representations with the same construction of the object.

The builder objects can be immutable. In the examlpe with the inner static class instead of a director the object is immutable.


The example below is copied from [https://jlordiales.me/2012/12/13/the-builder-pattern-in-practice/](https://jlordiales.me/2012/12/13/the-builder-pattern-in-practice/)
```java
   public class User {
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}
}

```

### Immutability ###
This is brief description of the concept immutability used in the builder pattern example.

***What is Immutability?***

An immutable object is an object that is never changed. 

***How to make objects immutable?***

Make the instance variables final. This will ensure that the user is unable to change the values of the variables.
There are no public methods to modify the instance variables.
All fields are private.
Make sure that all mutable fields never are accessed. Only copies of the mutable fields should be possible to access.
Any mutable fields should not be initialized with a parameter passed from a user. Use "defensive copies"? instead.

***Benefits of immutable objects?***

Since it is never changed it is thread safe, whenever in time a thread access the object it has not changed.

### Defensive copying ###
When sharing an object the user will get a copy of the object so that any unintentional modification of the object is prevented.

Enum
----
*Below is a merely re write of [oracel docs](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)* </BR>
Enum is powerfull in Java. They can be used to set both a constant a value, the values are passed automaticly to the constructor when the constant is created.
Java requires that the constants to be defined before any fields or methods.

Classpath
---------
https://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean



Things to check
---------------
- Lambda functions in Java
- Reflections
- java.lang.Class
- java.lang.Object
- ~~Defensive copies~~
- ~~Visual Studio Code~~