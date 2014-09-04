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

package com.twitter.hbc.twitter4j.handler;

import com.twitter.hbc.twitter4j.message.DisconnectMessage;
import com.twitter.hbc.twitter4j.message.FollowsOverLimitMessage;
import com.twitter.hbc.twitter4j.message.StallWarningMessage;

import twitter4j.SiteStreamsListener;
import twitter4j.Status;
import twitter4j.User;

public interface SitestreamHandler extends SiteStreamsListener {
  /**
   * See documentation on disconnect messages here: https://dev.twitter.com/docs/streaming-apis/messages#Disconnect_messages_disconnect
   */
  void onDisconnectMessage(DisconnectMessage disconnectMessage);

  /**
   * See documentation on stall warnings here:
   * See https://dev.twitter.com/docs/streaming-apis/parameters#stall_warnings
   *
   * Ideally, twitter4j would make it's StallWarning's constructor public and we could remove this.
   */
  void onStallWarningMessage(StallWarningMessage warning);

  /**
   * Any message we receive that isn't handled by the other methods
   */
  void onUnknownMessageType(String msg);
  
  /**
   * Triggered when a user on the stream has more friends than the site stream limit (10k).
   * 
   * @param warningMessage
   */
  void onFollowsOverLimitMessage(FollowsOverLimitMessage warningMessage);
  
  /**
   * Triggered on a retweet.
   * @param sitestreamUser
   * @param source
   * @param target
   * @param tweet
   */
  void onRetweet(long sitestreamUser, User source, User target, Status tweet);
  
  /**
   * Triggered when geo info should be scrubbed from a status.
   * 
   * @param sitestreamUser
   * @param userId
   * @param upToStatusId
   */
  void onScrubGeo(long sitestreamUser, long userId, long upToStatusId);
  
  /**
   * Triggered when a user revokes access for the application.
   * https://dev.twitter.com/discussions/27246
   * @param userId
   */
  void onAccessRevoked(long userId);

  /**
   * Triggered when a user unrevokes access for the application.
   * https://dev.twitter.com/discussions/27246
   * @param userId
   */
  void onAccessUnrevoked(long userId);

  /**
   * Triggered when a user on the stream has been deleted.
   * https://dev.twitter.com/discussions/27246
   * @param userId
   */
  void onUserDelete(long userId);

  /**
   * Triggered when a user on the stream has been suspended.
   * https://dev.twitter.com/discussions/27246
   * @param userId
   */
  void onUserSuspend(long userId);

  /**
   * Triggered when a user that is part of a connection is added to the same connection.
   * https://dev.twitter.com/discussions/27246
   * @param userId
   */
  void onUserReconnected(long userId);
}
