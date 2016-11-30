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

Things to check
---------------
- Lambda functions in Java
- Visual Studio Code

