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

package org.apache.shardingsphere.data.pipeline.cdc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.data.pipeline.cdc.constant.CDCSinkType;
import org.apache.shardingsphere.data.pipeline.core.context.PipelineContextKey;
import org.apache.shardingsphere.data.pipeline.core.job.id.PipelineJobId;
import org.apache.shardingsphere.data.pipeline.core.job.type.PipelineJobType;

import java.util.List;

/**
 * CDC job id.
 */
@RequiredArgsConstructor
@Getter
public final class CDCJobId implements PipelineJobId {
    
    private final PipelineJobType jobType = new CDCJobType();
    
    private final PipelineContextKey contextKey;
    
    private final List<String> schemaTableNames;
    
    private final boolean full;
    
    private final CDCSinkType sinkType;
}
