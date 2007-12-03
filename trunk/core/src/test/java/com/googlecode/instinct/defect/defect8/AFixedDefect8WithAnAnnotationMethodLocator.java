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

package com.googlecode.instinct.defect.defect8;

import static com.googlecode.instinct.expect.Expect.expect;
import com.googlecode.instinct.integrate.junit4.InstinctRunner;
import com.googlecode.instinct.internal.locate.AnnotatedMethodLocator;
import com.googlecode.instinct.internal.locate.AnnotatedMethodLocatorImpl;
import com.googlecode.instinct.marker.annotate.AfterSpecification;
import com.googlecode.instinct.marker.annotate.BeforeSpecification;
import com.googlecode.instinct.marker.annotate.Context;
import com.googlecode.instinct.marker.annotate.Specification;
import com.googlecode.instinct.defect.defect8.data.AnotherContext;
import com.googlecode.instinct.defect.defect8.data.AContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.RunWith;

@RunWith(InstinctRunner.class)
@Context
public class AFixedDefect8WithAnAnnotationMethodLocator {
    private final AnnotatedMethodLocator locator = new AnnotatedMethodLocatorImpl();

    @Specification
    public void shouldReturnABeforeSpeciifcationDefinedInABaseClass() {
        final Collection<Method> methods = locator.locate(AContext.class, BeforeSpecification.class);
        expect.that(methods).hasSize(1);
        expect.that(methods.iterator().next().getName()).equalTo("setup");
    }

    @Specification
    public void shouldReturnAnAfterSpecificationDefinedInABaseClass() {
        final Collection<Method> methods = locator.locate(AContext.class, AfterSpecification.class);
        expect.that(methods).hasSize(1);
        expect.that(methods.iterator().next().getName()).equalTo("tearDown");
    }

    @Specification
    public void shouldReturnSpecificationsInAContextAndItsBaseClasses() {
        final Collection<Method> methods = locator.locate(AnotherContext.class, Specification.class);
        expect.that(methods).hasSize(2);
        final Iterator<Method> methodIterator = methods.iterator();
        final List<String> expectList = new ArrayList<String>();
        expectList.add("shouldEquateTrueToTrue");
        expectList.add("shouldEquateFalseToFalse");
        expect.that(expectList.contains(methodIterator.next().getName())).isTrue();
        expect.that(expectList.contains(methodIterator.next().getName())).isTrue();
    }
}
