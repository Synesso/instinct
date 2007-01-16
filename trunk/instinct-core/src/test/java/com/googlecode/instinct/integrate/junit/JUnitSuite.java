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

package com.googlecode.instinct.integrate.junit;

import com.googlecode.instinct.test.suite.AllTestSuite;
import junit.framework.Test;

public final class JUnitSuite {
    private JUnitSuite() {
        throw new UnsupportedOperationException();
    }

    public static Test suite() {
//        final TestSuite test = (TestSuite) new JUnitTestSuiteBuilderImpl(AllTestSuite.class).buildSuite("Behaviour Contexts");
//        return test.testAt(0);
        return new JUnitTestSuiteBuilderImpl(AllTestSuite.class).buildSuite("Behaviour Contexts");
    }
}
