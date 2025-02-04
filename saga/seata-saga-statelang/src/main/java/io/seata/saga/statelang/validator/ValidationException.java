/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.seata.saga.statelang.validator;

import io.seata.common.util.StringUtils;

/**
 * Validation exception throws if exception occurs in validation phase.
 *
 * @author ptyin
 */
public class ValidationException extends RuntimeException {

    public ValidationException(Rule rule, String message) {
        super(spliceMessage(rule, message));
    }

    public ValidationException(Rule rule, String message, Throwable cause) {
        super(spliceMessage(rule, message), cause);
    }

    private static String spliceMessage(Rule rule, String message) {
        String canonicalMessage = String.format("Rule [%s]: %s", rule.getName(), message);
        if (StringUtils.isNotBlank(rule.getHint())) {
            canonicalMessage = canonicalMessage + ", hints: " + rule.getHint();
        }
        return canonicalMessage;
    }
}
