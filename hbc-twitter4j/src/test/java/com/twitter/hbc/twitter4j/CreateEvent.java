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

package com.twitter.hbc.twitter4j;

import com.google.common.base.Preconditions;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class CreateEvent {
  /**
   * Creates event where target, source, and targetObject are assumed to be 
   * JSON strings which are parsed into JSON objects.
   * 
   * @param eventName
   * @param target
   * @param source
   * @param targetObject
   * @return
   * @throws JSONException
   */
  public static JSONObject createEvent(
          String eventName,
          String target,
          String source,
          @Nullable String targetObject
  ) throws JSONException {

    return createEventWithTarget(
        eventName, 
        target, 
        source, 
        targetObject != null ? new JSONObject(targetObject) : null
    );
  }
  
  /**
   * Creates event where targetObject, if specified, is set on the event
   * as-is (i.e. it's not parsed into JSON object).
   * 
   * @param eventName
   * @param target
   * @param source
   * @param targetObject
   * @return
   * @throws JSONException
   */
  public static JSONObject createEventWithTarget(
      String eventName,
      String target,
      String source,
      @Nullable Object targetObject
   ) throws JSONException {

    Preconditions.checkNotNull(eventName);
    Preconditions.checkNotNull(target);
    Preconditions.checkNotNull(source);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("event", eventName);
    map.put("target", new JSONObject(target));
    map.put("source", new JSONObject(source));
    if (targetObject != null) {
      map.put("target_object", targetObject);
    }
    return new JSONObject(map);
  }
  
  /**
   * Creates event where targetObject, if specified, is set on the event
   * as-is (i.e. it's not parsed into JSON object).
   * 
   * @param eventName
   * @param target
   * @param source
   * @param targetObject
   * @return
   * @throws JSONException
   */
  public static JSONObject createEventWithTarget(
      String eventName,
      long target,
      long source,
      @Nullable String targetObject
   ) throws JSONException {

    Preconditions.checkNotNull(eventName);
    Preconditions.checkNotNull(target);
    Preconditions.checkNotNull(source);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("event", eventName);
    map.put("target", target);
    map.put("source", source);
    if (targetObject != null) {
      map.put("target_object", targetObject);
    }
    return new JSONObject(map);
  }
}
