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

package com.github.mysqlbinlog.model.variable;

public class QLcTimeNamesCode extends StatusVariable {
    private static final long serialVersionUID = 3944457493730034933L;
    private final int lcTimeNames;

    public QLcTimeNamesCode(int lcTimeNames) {
        this.lcTimeNames = lcTimeNames;
    }

    public int getLcTimeNames() {
        return lcTimeNames;
    }

    @Override
    public String toString() {
        return "QLcTimeNamesCode [lcTimeNames=" + lcTimeNames + "]";
    }
}
