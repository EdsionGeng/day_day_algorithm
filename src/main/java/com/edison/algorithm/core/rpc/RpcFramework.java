package com.edison.algorithm.core.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @Date 2020/3/29下午4:54
 * @Created by edsiongeng
 */
public class RpcFramework {

    public static void export(final Object service, int port) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("service instance ==null");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port" + port);
        }
        System.out.println("Export service" + service.getClass().getName() + "on port" + port);
        ServerSocket server = new ServerSocket(port);
        for (; ; ) {
            try {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            try {
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                                try {
                                    String methodName = input.readUTF();
                                    Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                                    Object[] arguments = (Object[]) input.readObject();
                                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                                    try {
                                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                                        Object result = method.invoke(service, arguments);
                                        output.writeObject(result);
                                    } catch (Throwable t) {
                                        output.writeObject(t);
                                    } finally {
                                        output.close();
                                    }
                                } finally {
                                    input.close();
                                }
                            } finally {
                                socket.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        {
            if (interfaceClass == null) {
                throw new IllegalArgumentException("Interface class ==null");
            }
            if (!interfaceClass.isInterface()) {
                throw new IllegalArgumentException("The" + interfaceClass.getName() + " must be interface class");
            }
            if (host == null || host.length() == 0) {
                throw new IllegalArgumentException("Host ==null! ");
            }
            if (port <= 0 || port > 65535) {
                throw new IllegalArgumentException("Invalid port:" + port);
            }
            System.out.println("Get remote service " + interfaceClass.getName() + " from server" + host + ":" + port);
            return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
                    Socket socket = new Socket(host, port);
                    try {
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        try {
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(arguments);
                            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                            try {
                                Object result = input.readObject();
                                if (result instanceof Throwable) {
                                    throw (Throwable) result;
                                }
                                return result;
                            } finally {
                                input.close();
                            }
                        } finally {
                            output.close();
                        }
                    } finally {
                        socket.close();
                    }
                }
            });
        }
    }
}
