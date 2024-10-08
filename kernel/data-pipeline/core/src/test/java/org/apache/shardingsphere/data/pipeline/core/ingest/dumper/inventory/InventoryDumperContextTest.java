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

package org.apache.shardingsphere.data.pipeline.core.ingest.dumper.inventory;

import org.apache.shardingsphere.data.pipeline.core.ingest.dumper.DumperCommonContext;
import org.apache.shardingsphere.data.pipeline.core.metadata.model.PipelineColumnMetaData;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class InventoryDumperContextTest {
    
    @Test
    void assertHasUniqueKey() {
        InventoryDumperContext inventoryDumperContext = new InventoryDumperContext(mock(DumperCommonContext.class));
        inventoryDumperContext.setUniqueKeyColumns(Collections.singletonList(mock(PipelineColumnMetaData.class)));
        assertTrue(inventoryDumperContext.hasUniqueKey());
    }
    
    @Test
    void assertHasNotUniqueKeyWhenNull() {
        InventoryDumperContext inventoryDumperContext = new InventoryDumperContext(mock(DumperCommonContext.class));
        assertFalse(inventoryDumperContext.hasUniqueKey());
    }
    
    @Test
    void assertHasNotUniqueKeyWhenEmpty() {
        InventoryDumperContext inventoryDumperContext = new InventoryDumperContext(mock(DumperCommonContext.class));
        inventoryDumperContext.setUniqueKeyColumns(Collections.emptyList());
        assertFalse(inventoryDumperContext.hasUniqueKey());
    }
    
    @Test
    void assertGetQueryColumnNamesWithInsertColumnNames() {
        InventoryDumperContext inventoryDumperContext = new InventoryDumperContext(mock(DumperCommonContext.class));
        inventoryDumperContext.setInsertColumnNames(Collections.singletonList("id"));
        assertThat(inventoryDumperContext.getQueryColumnNames(), is(Collections.singletonList("id")));
    }
    
    @Test
    void assertGetQueryColumnNamesWithoutInsertColumnNames() {
        InventoryDumperContext inventoryDumperContext = new InventoryDumperContext(mock(DumperCommonContext.class));
        assertThat(inventoryDumperContext.getQueryColumnNames(), is(Collections.singletonList("*")));
    }
}
