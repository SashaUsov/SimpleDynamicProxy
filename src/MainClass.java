import classes.Person;
import interfaces.IPerson;
import proxyClasses.NeverSleepingEye;

import java.lang.reflect.Proxy;

public class MainClass {

    public static void main(String[] args) {

        Person person = new Person();

        IPerson personProxy = (IPerson) Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(),
                new NeverSleepingEye(person));

        personProxy.setName("Гриша");

        String h  = personProxy.getName() ;

        personProxy.rename("Вася");
    }
}
