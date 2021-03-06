/*
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.switchyard.serial.graph;

import org.switchyard.common.type.reflect.Construction;

/**
 * The factory the AccessNode will use.
 * 
 * @param <T> the factory type
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; &copy; 2012 Red Hat Inc.
 */
public abstract class Factory<T> {

    /**
     * Creates a new object of the specified type.
     * @param type the type
     * @return the object
     */
    public abstract T create(Class<T> type);

    /**
     * Whether this factory supports the specified type.
     * @param type the type
     * @return if the type is supported
     */
    public abstract boolean supports(Class<?> type);

    /**
     * Gets the factory for the specified type.
     * @param <T> the factory type
     * @param type the type
     * @return the factory
     */
    @SuppressWarnings("unchecked")
    public static final <T> Factory<T> getFactory(Class<T> type) {
        Strategy strategy = type.getAnnotation(Strategy.class);
        if (strategy != null) {
            return Construction.construct(strategy.factory());
        }
        return new DefaultFactory<T>();
    }

}
