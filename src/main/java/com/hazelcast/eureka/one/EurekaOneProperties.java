/*
 * Copyright (c) 2008-2017, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.eureka.one;

import com.hazelcast.config.properties.PropertyDefinition;
import com.hazelcast.config.properties.SimplePropertyDefinition;
import com.hazelcast.core.TypeConverter;

import static com.hazelcast.config.properties.PropertyTypeConverter.BOOLEAN;
import static com.hazelcast.config.properties.PropertyTypeConverter.STRING;

/**
 * <p>Configuration class of the Hazelcast Discovery Plugin for <a href="https://github.com/Netflix/eureka">Eureka 1</a>.</p>
 * <p>For possible configuration properties please refer to the public constants of this class.</p>
 */
public final class EurekaOneProperties {

    /**
     * <p>Configuration System Environment Prefix: <tt>hazelcast.eurekaone.</tt></p>
     * Defines the prefix for system environment variables and JVM command line parameters.<br/>
     * Defining or overriding properties as JVM parameters or using the system environment, those
     * properties need to be prefixed to prevent collision on property names.<br/>
     * Example: {@link #SELF_REGISTRATION} will be:
     * <pre>
     *     -Dhazelcast.eurekaone.self-registration=value
     * </pre>
     * Example: {@link #NAMESPACE} will be:
     * <pre>
     *     -Dhazelcast.eurekaone.namespace=value
     * </pre>
     */
    public static final String EUREKA_ONE_SYSTEM_PREFIX = "hazelcast.eurekaone";

    /**
     * <p>Configuration key: <tt>self-registration</tt></p>
     * <p>Defines if the Discovery SPI plugin will register itself with the Eureka 1 service discovery.</p>
     * <p>The default value is: <tt>true</tt></p>
     */
    public static final PropertyDefinition SELF_REGISTRATION = property("self-registration", BOOLEAN);

    /**
     * <p>Configuration key: <tt>namespace</tt></p>
     * <p>Definition for providing different namespaces in order to not collide with other service registry clients in
     * eureka-client.properties file.</p>
     * <p>The default value is: <tt>hazelcast</tt></p>
     */
    public static final PropertyDefinition NAMESPACE = property("namespace", STRING);

    // Prevent instantiation
    private EurekaOneProperties() {
    }

    private static PropertyDefinition property(String key, TypeConverter typeConverter) {
        return new SimplePropertyDefinition(key, true, typeConverter);
    }

}
