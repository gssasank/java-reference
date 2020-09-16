# Access Modifiers

Access keywords are added with classes or any blocks or definitions that define the extent of acces to that class, block or definitions in the program.

## Types of access modifiers
- Access Control Modifiers
- Non Access Modifiers

---
## Access control modifiers:
- ### private
    - Any entity declared as private is only accessible inside the entity (class or package or interface) which it is defined
    ```
    public class demo{   // Outer class can not be private
        private String greeting = "Hello World"; //private variable
          
        private void hello(){ // private method
            System.out.println(greeting);
        }
     }
    ```
- ### default
    - There is no keyword for default access modifiers.
    - Any entity declared as default can only be access with in a package.
    - It is also known as package-private
    ```
    class demo{ // default class
        void hello(){
            System.out.println(greeting);
        }
    }
    ```
- ### protected
    - Any entity declared as protected can be access with in a package and outside the package within child classes through inheritance only. 
    ```
    public class demo{ // outer class cannot be protected
        protected int number; // protected variable

        protected void hello(){ // protected method
            System.out.println("Hello World!");
        } 
    }
    ```
- ### public
    - If any entity is declared as public than we can access that any where.
    - We can only use one public class in a java file.
    ```
    public class demo{ // public class
        public int number; // public variable

        public void hello(){ // public method
            System.out.println("Hello World!");
        } 
    }
    ```
**NOTE :** An outer class in JAVA cannot be private or protected.

|                                | private | default | protected | public |
|:--                             |:-:      |:-:      |:-:        |:-:     |
| Same class                     | YES     |  YES    |  YES      | YES    |
| Same package subclass          | NO      |  YES    |  YES      | YES    |
| Same package non-subclass      | NO      |  YES    |  YES      | YES    |
| Different package subclass     | NO      |  NO     |  YES      | YES    |
| Different package non-subclass | NO      |  NO     |  NO       | YES    |

---

## Non Access Modifiers

- First of all we have static modifier. That we mostly use with class or methods.
- Then we have final modifier that we can use to make our variables or class or methods finalize.
- The abstract modifier that we us to make our class or methods abstract.