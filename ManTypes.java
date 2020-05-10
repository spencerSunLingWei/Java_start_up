package com.stage1.part2.task5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)

public @interface ManTypes {
    ManType[] value();
}
