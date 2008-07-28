/*
 * Copyright 2006-2008 Workingmouse
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

package com.googlecode.instinct.stack

import integrate.junit4.InstinctRunner
import org.junit.runner.RunWith

@RunWith(classOf[InstinctRunner])
final class AnEmptyStackInScala {
    def shouldDoSomething {
        println("Foo")
    }
}

object Runner {
    import com.googlecode.instinct.runner.TextRunner._
    import com.googlecode.instinct.stack.AnEmptyStackInScala

    def main(args: Array[String]) {
        runContexts(Array(classOf[AnEmptyStackInScala]));
    }
}
