/*
 * Copyright (c) 2022 Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.sun.tdk.jcov.instrument;

import java.util.ServiceLoader;

public interface Modifiers {

    static Modifiers parse(String[] flags) {
        return Services.getFactory().parse(flags);
    }

    static Modifiers parse(int flags) {
        return Services.getFactory().parse(flags);
    }

    boolean isPublic();

    boolean isPrivate();

    boolean isProtected();

    boolean isAbstract();

    boolean isFinal();

    boolean isSynthetic();

    boolean isStatic();

    boolean isInterface();

    boolean isSuper();

    boolean isNative();

    boolean isDeprecated();

    boolean isSynchronized();

    boolean isVolatile();

    boolean isBridge();

    boolean isVarargs();

    boolean isTransient();

    boolean isStrict();

    boolean isAnnotation();

    boolean isEnum();

    int access();

    /**
     * This method is only a part of the contract to support deprecated methods.
     * @param code
     * @return
     * @see DataClass#hasModifier(int)
     * @see DataField#hasModifier(int)
     * @see DataMethod#hasModifier(int)
     */
    @Deprecated
    boolean is(int code);

    interface ModifiersFactory {
        Modifiers parse(String[] flags);
        Modifiers parse(int flags);
    }
}
