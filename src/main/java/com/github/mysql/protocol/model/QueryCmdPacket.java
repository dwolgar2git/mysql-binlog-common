/*
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
 *
 */

package com.github.mysql.protocol.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.github.mysql.constant.MysqlConstants;
import com.github.mysql.io.MysqlBinlogByteArrayOutputStream;

public class QueryCmdPacket implements CmdPacket {
    private final String sql;
    
    public QueryCmdPacket(String command) {
        this.sql = command;
    }

    @Override
    public byte[] getBody() throws IOException {
        MysqlBinlogByteArrayOutputStream os = new MysqlBinlogByteArrayOutputStream(new ByteArrayOutputStream());
        
        os.writeInteger(MysqlConstants.COM_QUERY, 1);
        os.writeString(this.sql);
//        os.writeZeroTerminatedString(this.sql);
        os.close();
        
        return ((ByteArrayOutputStream)(os.getOutputStream())).toByteArray();
    }

    public String getSql() {
        return sql;
    }

    @Override
    public String toString() {
        return "QueryCmdPacket [sql=" + sql + "]";
    }
}
