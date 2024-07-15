package com.twozo.commons.listener.annotation;

import com.twozo.commons.listener.TestNgListener;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public interface AnnotationListener extends TestNgListener {

    default void transformer(final ITestAnnotation annotation, final Class<?> testClass, final Constructor<?> testConstructor, final Method testMethod) {
    }

    default void transform(final IConfigurationAnnotation annotation, final Class<?> testClass, final Constructor<?> testConstructor, final Method testMethod) {
    }

    default void transform(final IDataProviderAnnotation annotation, final Method method) {
    }

    default void transform(final IFactoryAnnotation annotation, final Method method) {
    }

    default void transform(final IListenersAnnotation annotation, final Class<?> testClass) {
    }
}