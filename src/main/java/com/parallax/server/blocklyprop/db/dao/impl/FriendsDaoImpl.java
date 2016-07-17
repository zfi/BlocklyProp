/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.server.blocklyprop.db.dao.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.parallax.server.blocklyprop.db.dao.FriendsDao;
import com.parallax.server.blocklyprop.db.generated.Tables;
import com.parallax.server.blocklyprop.db.generated.tables.records.FriendRequestRecord;
import com.parallax.server.blocklyprop.services.impl.SecurityServiceImpl;
import java.util.List;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Michel
 */
@Singleton
public class FriendsDaoImpl implements FriendsDao {

    private static Logger log = LoggerFactory.getLogger(FriendsDaoImpl.class);

    private DSLContext create;

    @Inject
    public void setDSLContext(DSLContext dsl) {
        this.create = dsl;
    }

    @Override
    public FriendRequestRecord request(Long idFriend) {
        Long idUser = SecurityServiceImpl.getSessionData().getIdUser();
        return create.insertInto(Tables.FRIEND_REQUEST).columns(Tables.FRIEND_REQUEST.IDREQUESTUSER, Tables.FRIEND_REQUEST.IDREQUESTEDUSER).values(idUser, idFriend).returning().fetchOne();
    }

    @Override
    public List<FriendRequestRecord> getOpenFriendRequests() {
        Long idUser = SecurityServiceImpl.getSessionData().getIdUser();
        return create.selectFrom(Tables.FRIEND_REQUEST).where(Tables.FRIEND_REQUEST.IDREQUESTUSER.equal(idUser).and(Tables.FRIEND_REQUEST.REFUSED.equal(Boolean.FALSE))).fetch();
    }

    @Override
    public List<FriendRequestRecord> getRefusedFriendRequests() {
        Long idUser = SecurityServiceImpl.getSessionData().getIdUser();
        return create.selectFrom(Tables.FRIEND_REQUEST).where(Tables.FRIEND_REQUEST.IDREQUESTUSER.equal(idUser).and(Tables.FRIEND_REQUEST.REFUSED.equal(Boolean.TRUE))).fetch();
    }

    @Override
    public List<FriendRequestRecord> getFriendRequestsYouHaventAccepted() {
        Long idUser = SecurityServiceImpl.getSessionData().getIdUser();
        return create.selectFrom(Tables.FRIEND_REQUEST).where(Tables.FRIEND_REQUEST.IDREQUESTEDUSER.equal(idUser).and(Tables.FRIEND_REQUEST.REFUSED.equal(Boolean.FALSE))).fetch();
    }

    @Override
    public List<FriendRequestRecord> getFriendRequestsYouRefused() {
        Long idUser = SecurityServiceImpl.getSessionData().getIdUser();
        return create.selectFrom(Tables.FRIEND_REQUEST).where(Tables.FRIEND_REQUEST.IDREQUESTEDUSER.equal(idUser).and(Tables.FRIEND_REQUEST.REFUSED.equal(Boolean.TRUE))).fetch();
    }

}
