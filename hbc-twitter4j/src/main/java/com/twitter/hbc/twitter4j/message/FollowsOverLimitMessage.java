/**
 * Copyright 2013 Twitter, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.twitter.hbc.twitter4j.message;

/**
 * 
 * https://dev.twitter.com/docs/streaming-apis/messages#Too_many_follows_warning
 * 
 * @author jamesjory
 */
public class FollowsOverLimitMessage {
	private final String code;
	private final String message;
	private final long userId;
	
	public FollowsOverLimitMessage(String code, String message, long userId) {
		this.code = code;
		this.message = message;
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public long getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return String.format("Stream warning: %s %s for user %s", code, message, userId);
	}
}
