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

package com.github.mysql.protocol.unmarshaller;


import com.github.mysql.io.MysqlBinlogByteArrayInputStream;
import com.github.mysql.protocol.model.EOFResponsePacket;
import com.github.mysql.protocol.model.ResponsePacket;

public class EOFResponsePacketUnmarshaller implements ResponsePacketUnmarshaller {
    @Override
    public ResponsePacket unmarshal(MysqlBinlogByteArrayInputStream is) {
        try {
            EOFResponsePacket packet = new EOFResponsePacket();

            int marker = is.readInt(1, true);
            packet.setWarningCount(is.readInt(2, true));
            packet.setServerStatus(is.readInt(2, true));
            return packet;
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}
