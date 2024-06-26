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

package org.apache.shardingsphere.encrypt.merge.dal.show;

import org.apache.shardingsphere.encrypt.rule.EncryptRule;
import org.apache.shardingsphere.infra.binder.context.statement.SQLStatementContext;
import org.apache.shardingsphere.infra.executor.sql.execute.result.query.QueryResult;
import org.apache.shardingsphere.infra.metadata.database.rule.RuleMetaData;

import java.sql.SQLException;

/**
 * Merged encrypt show create table merged result.
 */
public final class MergedEncryptShowCreateTableMergedResult extends EncryptShowCreateTableMergedResult {
    
    private final QueryResult queryResult;
    
    public MergedEncryptShowCreateTableMergedResult(final RuleMetaData globalRuleMetaData, final QueryResult queryResult, final SQLStatementContext sqlStatementContext,
                                                    final EncryptRule encryptRule) {
        super(globalRuleMetaData, sqlStatementContext, encryptRule);
        this.queryResult = queryResult;
    }
    
    @Override
    protected boolean nextValue() throws SQLException {
        return queryResult.next();
    }
    
    @Override
    protected Object getOriginalValue(final int columnIndex, final Class<?> type) throws SQLException {
        return queryResult.getValue(columnIndex, type);
    }
    
    @Override
    public boolean wasNull() throws SQLException {
        return queryResult.wasNull();
    }
}
