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

package org.apache.shardingsphere.data.pipeline.postgresql.query;

import org.apache.shardingsphere.data.pipeline.core.query.DialectJDBCStreamQueryBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC stream query builder for PostgreSQL.
 */
public final class PostgreSQLJDBCStreamQueryBuilder implements DialectJDBCStreamQueryBuilder {
    
    @Override
    public PreparedStatement build(final Connection connection, final String sql, final int batchSize) throws SQLException {
        PreparedStatement result = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
        connection.setAutoCommit(false);
        if (batchSize > 0) {
            result.setFetchSize(batchSize);
        }
        return result;
    }
    
    @Override
    public String getDatabaseType() {
        return "PostgreSQL";
    }
}
