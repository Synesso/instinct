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

package com.googlecode.instinct.test.suite;

import junit.framework.Test;
import junit.framework.TestSuite;

public final class AllTestSuite {
    private AllTestSuite() {
        throw new UnsupportedOperationException();
    }

    public static Test suite() {
        final TestSuite suite = new TestSuite("All");
        suite.addTest(AtomicTestSuite.suite());
        suite.addTest(SlowTestSuite.suite());
        suite.addTest(AllSpecificationsSuite.suite());
        return suite;
    }
}
