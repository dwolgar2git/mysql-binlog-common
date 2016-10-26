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

package com.github.mysqlbinlog.event.unmarshaller;

import java.io.IOException;

import com.github.mysql.io.MysqlBinlogByteArrayInputStream;
import com.github.mysqlbinlog.model.event.BinlogEvent;
import com.github.mysqlbinlog.model.event.IncidentEvent;

public class IncidentEventUnmarshaller implements BinlogEventUnmarshaller<IncidentEvent> {

    public BinlogEvent unmarshal(IncidentEvent event, MysqlBinlogByteArrayInputStream is, BinlogUnmarshallerContext context) throws IOException {
        
        event.setIncidentNumber(is.readInt(1, true));
        event.setMessageLength(is.readInt(1, true));
        if (event.getMessageLength() > 0)
            event.setMessage( is.readString( event.getMessageLength() ) );
        return event;
    }

}
