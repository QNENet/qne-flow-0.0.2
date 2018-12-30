/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.component;

import java.util.stream.Stream;

/**
 * Enumeration of possible keyboard key locations.
 */
public enum KeyLocation {

    /**
     * Standard key location.
     */
    STANDARD(0),

    /**
     * Left key location.
     */
    LEFT(1),

    /**
     * Right key location.
     */
    RIGTH(2),

    /**
     * Numeric pad key location.
     */
    NUMPAD(3);

    private final int location;

    KeyLocation(int location) {
        this.location = location;
    }

    /**
     * Gets the key location integer value.
     *
     * @return the key location integer value
     */
    public int getLocation() {
        return location;
    }

    /**
     * Returns the {@code KeyLocation} for {@code location}.
     *
     * @param location
     *            the location integer value
     * @return the {@code KeyLocation}
     */
    public static KeyLocation of(int location) {
        return Stream.of(values()).filter(l -> l.location == location)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

}
