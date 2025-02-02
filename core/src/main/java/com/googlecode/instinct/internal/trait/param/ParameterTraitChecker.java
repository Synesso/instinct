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

package com.googlecode.instinct.internal.trait.param;

public interface ParameterTraitChecker {
    <T> void checkPublicConstructorsRejectsNull(Class<T> classToCheck);

    <T> void checkPublicConstructorsRejectEmptyString(Class<T> classToCheck);

    void checkPublicMethodsRejectsNull(Object instance);

    void checkPublicMethodsRejectEmptyString(Object instance);
}
