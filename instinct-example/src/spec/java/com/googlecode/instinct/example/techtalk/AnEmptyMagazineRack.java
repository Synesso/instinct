package com.googlecode.instinct.example.techtalk;

import com.googlecode.instinct.core.annotate.BehaviourContext;
import com.googlecode.instinct.core.annotate.Specification;
import com.googlecode.instinct.internal.util.Suggest;
import com.googlecode.instinct.verify.Verify;

@Suggest({"TechTalk: Drive out a magazine rack, using a mock stack to show interactions.",
        "TechTalk: Use this to show how to do automocking"})
@BehaviourContext
public final class AnEmptyMagazineRack {
    @Specification
    void mustDoSomething() {
        Verify.mustBeTrue(true);
    }
}
