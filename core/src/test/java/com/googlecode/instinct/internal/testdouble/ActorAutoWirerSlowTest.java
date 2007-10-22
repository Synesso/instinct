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

package com.googlecode.instinct.internal.testdouble;

import java.lang.reflect.Field;
import static com.googlecode.instinct.expect.Expect.expect;
import com.googlecode.instinct.marker.annotate.Stub;
import com.googlecode.instinct.marker.annotate.Subject;
import com.googlecode.instinct.test.InstinctTestCase;
import static com.googlecode.instinct.test.checker.ExceptionTestChecker.expectException;
import static com.googlecode.instinct.test.reflect.Reflector.getFieldByName;

@SuppressWarnings({"InstanceVariableOfConcreteClass"})
public final class ActorAutoWirerSlowTest extends InstinctTestCase {
    @Subject(implementation = ActorAutoWirerImpl.class) private ActorAutoWirer actorAutoWirer;
    @Stub private SomeClassWithMarkedFieldsToAutoWire instanceWithFieldsToWire;
    @Stub private SomeClassWithMarkedFieldsToNotAutowire instanceWithFieldsNotToWire;

    public void testAutoWiresDummiesIntoClasses() throws Exception {
        actorAutoWirer.autoWireFields(instanceWithFieldsToWire);
        final Field dummyField = getField(instanceWithFieldsToWire, "dummy");
        final CharSequence value = (CharSequence) dummyField.get(instanceWithFieldsToWire);
        expectException(IllegalInvocationException.class, new Runnable() {
            public void run() {
                value.charAt(0);
            }
        });
    }

    public void testDoesNotAutoWireDummiesWhenNotRequested() throws Exception {
        actorAutoWirer.autoWireFields(instanceWithFieldsNotToWire);
        final Field dummyField = getField(instanceWithFieldsNotToWire, "dummy");
        final CharSequence value = (CharSequence) dummyField.get(instanceWithFieldsNotToWire);
        expect.that(value).isNull();
    }

    private Field getField(final Object instance, final String fieldName) {
        final Field field = getFieldByName(instance.getClass(), fieldName);
        field.setAccessible(true);
        return field;
    }
}