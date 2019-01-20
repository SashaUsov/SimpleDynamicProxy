package proxyClasses;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class NeverSleepingEye implements InvocationHandler {

    private Object obj;

    public NeverSleepingEye(Object f1) {

        obj = f1;

    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        String methodName = method.getName();

        System.out.println("Method name - " + methodName);

        String returnType = method.getReturnType().getTypeName();

        System.out.println("     return type - " + returnType);

        Parameter[] methodParameters = method.getParameters();

        for (int i = 0; i < methodParameters.length; i++) {

            Parameter parameter = methodParameters[i];

            String paramName = parameter.getName();

            System.out.println("     parameter type - " + parameter.getType().getTypeName());

            System.out.println("     parameter name - " + paramName);

            System.out.println("     parameter value - " + args[i].toString());
        }

        System.out.println("");

        return method.invoke(obj, args);
    }
}
