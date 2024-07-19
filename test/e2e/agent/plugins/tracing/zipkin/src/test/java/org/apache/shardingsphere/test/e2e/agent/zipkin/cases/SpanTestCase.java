/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.test.e2e.agent.zipkin.cases;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.test.e2e.agent.common.env.E2ETestEnvironment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;

/**
 * Span test case.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public final class SpanTestCase {
    
    @XmlAttribute(name = "service-name")
    private String serviceName;
    
    @XmlAttribute(name = "span-name")
    private String spanName;
    
    @XmlElement(name = "tag-assertion")
    private Collection<TagAssertion> tagCases;
    
    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", E2ETestEnvironment.getInstance().getAdapter(), spanName, tagCases.iterator().next().toString());
    }
}
