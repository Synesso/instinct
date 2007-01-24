/*
 * Copyright 2006-2007 Tom Adams
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.instinct.internal.aggregate.locate;

import java.io.File;
import java.lang.annotation.Annotation;
import au.net.netstorm.boost.edge.EdgeException;
import com.googlecode.instinct.internal.util.ClassInstantiator;
import com.googlecode.instinct.internal.util.ClassInstantiatorFactory;
import com.googlecode.instinct.internal.util.ClassInstantiatorFactoryImpl;
import static com.googlecode.instinct.internal.util.ParamChecker.checkNotNull;
import com.googlecode.instinct.internal.util.Suggest;

public final class AnnotatedClassFileCheckerImpl implements AnnotatedClassFileChecker {
    private AnnotationChecker annotationChecker = new AnnotationCheckerImpl();
    private ClassInstantiatorFactory instantiatorFactory = new ClassInstantiatorFactoryImpl();
    private ClassInstantiator instantiator;

    public AnnotatedClassFileCheckerImpl(final File packageRoot) {
        checkNotNull(packageRoot);
        instantiator = instantiatorFactory.create(packageRoot);
    }

    @Suggest("Write test that ensures that we reject non-classes & return false for EdgeExceptions")
    public <A extends Annotation> boolean isAnnotated(final File classFile, final Class<A> annotationType) {
        checkNotNull(classFile, annotationType);
        return classFile.getName().endsWith(".class") && checkClass(classFile, annotationType);
    }

    private <A extends Annotation> boolean checkClass(final File classFile, final Class<A> annotationType) {
        try {
            final Class<?> candidateClass = instantiator.instantiateClass(classFile);
            return annotationChecker.isAnnotated(candidateClass, annotationType);
        } catch (EdgeException e) {
            return false;
        }
    }
}
