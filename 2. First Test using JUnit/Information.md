Annotations:
------------

Keywords start with @ are annotations like : 

@Override: It insures that method is override from a super class and we don't want to
change it name of signature.
Ex: 
@Override
public void getName(){...}

@FunctionalInterface: Used on top of a interface when make a functional interface that
allow to have only one method.
Ex:     
@FunctionalInterface
interface A{
    public void getA();
}

@Deprecated: It says that the matadata that we are using is depricated.

@Test:  To indicate that this method will be used to test some code. It is from JUnit package.

