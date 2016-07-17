/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.server.blocklyprop.db.dao;

import com.parallax.server.blocklyprop.db.generated.tables.records.FriendRequestRecord;
import java.util.List;

/**
 *
 * @author Michel
 */
public interface FriendsDao {

    FriendRequestRecord request(Long idFriend);

    List<FriendRequestRecord> getOpenFriendRequests();

    List<FriendRequestRecord> getRefusedFriendRequests();

    List<FriendRequestRecord> getFriendRequestsYouHaventAccepted();

    List<FriendRequestRecord> getFriendRequestsYouRefused();

}
