/*
 * This file is generated by jOOQ.
*/
package com.parallax.server.blocklyprop.db.generated;


import com.parallax.server.blocklyprop.db.generated.tables.Admin;
import com.parallax.server.blocklyprop.db.generated.tables.Friend;
import com.parallax.server.blocklyprop.db.generated.tables.FriendRequest;
import com.parallax.server.blocklyprop.db.generated.tables.FriendRequestEmail;
import com.parallax.server.blocklyprop.db.generated.tables.Motd;
import com.parallax.server.blocklyprop.db.generated.tables.Project;
import com.parallax.server.blocklyprop.db.generated.tables.ProjectSharing;
import com.parallax.server.blocklyprop.db.generated.tables.SecRole;
import com.parallax.server.blocklyprop.db.generated.tables.SecUserRole;
import com.parallax.server.blocklyprop.db.generated.tables.Session;
import com.parallax.server.blocklyprop.db.generated.tables.Tag;
import com.parallax.server.blocklyprop.db.generated.tables.User;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>blocklyprop</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ADMIN_PRIMARY = Indexes0.ADMIN_PRIMARY;
    public static final Index FRIEND_FRIEND_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX = Indexes0.FRIEND_FRIEND_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX;
    public static final Index FRIEND_FRIEND_REQUESTED_USER_ID_FK = Indexes0.FRIEND_FRIEND_REQUESTED_USER_ID_FK;
    public static final Index FRIEND_PRIMARY = Indexes0.FRIEND_PRIMARY;
    public static final Index FRIEND_REQUEST_FRIEND_REQUEST_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX = Indexes0.FRIEND_REQUEST_FRIEND_REQUEST_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX;
    public static final Index FRIEND_REQUEST_FRIEND_REQUEST_REQUESTED_USER_ID_FK = Indexes0.FRIEND_REQUEST_FRIEND_REQUEST_REQUESTED_USER_ID_FK;
    public static final Index FRIEND_REQUEST_PRIMARY = Indexes0.FRIEND_REQUEST_PRIMARY;
    public static final Index FRIEND_REQUEST_EMAIL_ACCEPT_KEY = Indexes0.FRIEND_REQUEST_EMAIL_ACCEPT_KEY;
    public static final Index FRIEND_REQUEST_EMAIL_FRIEND_REQUEST_EMAIL_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX = Indexes0.FRIEND_REQUEST_EMAIL_FRIEND_REQUEST_EMAIL_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX;
    public static final Index FRIEND_REQUEST_EMAIL_PRIMARY = Indexes0.FRIEND_REQUEST_EMAIL_PRIMARY;
    public static final Index MOTD_PRIMARY = Indexes0.MOTD_PRIMARY;
    public static final Index PROJECT_PRIMARY = Indexes0.PROJECT_PRIMARY;
    public static final Index PROJECT_SHARING_PRIMARY = Indexes0.PROJECT_SHARING_PRIMARY;
    public static final Index PROJECT_SHARING_PROJECT_SHARING_ID_PROJECT_SHAREKEY_UINDEX = Indexes0.PROJECT_SHARING_PROJECT_SHARING_ID_PROJECT_SHAREKEY_UINDEX;
    public static final Index PROJECT_SHARING_PROJECT_SHARING_SHAREKEY_INDEX = Indexes0.PROJECT_SHARING_PROJECT_SHARING_SHAREKEY_INDEX;
    public static final Index SEC_ROLE_NAME_UNIQUE = Indexes0.SEC_ROLE_NAME_UNIQUE;
    public static final Index SEC_ROLE_PRIMARY = Indexes0.SEC_ROLE_PRIMARY;
    public static final Index SEC_USER_ROLE_FK_USER_ROLE_ROLE_IDX = Indexes0.SEC_USER_ROLE_FK_USER_ROLE_ROLE_IDX;
    public static final Index SEC_USER_ROLE_UNIQUE_USER_ROLE = Indexes0.SEC_USER_ROLE_UNIQUE_USER_ROLE;
    public static final Index SESSION_PRIMARY = Indexes0.SESSION_PRIMARY;
    public static final Index TAG_NAME_UNIQUE = Indexes0.TAG_NAME_UNIQUE;
    public static final Index TAG_PRIMARY = Indexes0.TAG_PRIMARY;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index ADMIN_PRIMARY = createIndex("PRIMARY", Admin.ADMIN, new OrderField[] { Admin.ADMIN.ID }, true);
        public static Index FRIEND_FRIEND_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX = createIndex("friend_idRequestUser_idRequestedUser_uindex", Friend.FRIEND, new OrderField[] { Friend.FRIEND.IDREQUESTUSER, Friend.FRIEND.IDREQUESTEDUSER }, true);
        public static Index FRIEND_FRIEND_REQUESTED_USER_ID_FK = createIndex("friend_requested_user_id_fk", Friend.FRIEND, new OrderField[] { Friend.FRIEND.IDREQUESTEDUSER }, false);
        public static Index FRIEND_PRIMARY = createIndex("PRIMARY", Friend.FRIEND, new OrderField[] { Friend.FRIEND.ID }, true);
        public static Index FRIEND_REQUEST_FRIEND_REQUEST_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX = createIndex("friend_request_idRequestUser_idRequestedUser_uindex", FriendRequest.FRIEND_REQUEST, new OrderField[] { FriendRequest.FRIEND_REQUEST.IDREQUESTUSER, FriendRequest.FRIEND_REQUEST.IDREQUESTEDUSER }, true);
        public static Index FRIEND_REQUEST_FRIEND_REQUEST_REQUESTED_USER_ID_FK = createIndex("friend_request_requested_user_id_fk", FriendRequest.FRIEND_REQUEST, new OrderField[] { FriendRequest.FRIEND_REQUEST.IDREQUESTEDUSER }, false);
        public static Index FRIEND_REQUEST_PRIMARY = createIndex("PRIMARY", FriendRequest.FRIEND_REQUEST, new OrderField[] { FriendRequest.FRIEND_REQUEST.ID }, true);
        public static Index FRIEND_REQUEST_EMAIL_ACCEPT_KEY = createIndex("accept_Key", FriendRequestEmail.FRIEND_REQUEST_EMAIL, new OrderField[] { FriendRequestEmail.FRIEND_REQUEST_EMAIL.ACCEPT_KEY }, true);
        public static Index FRIEND_REQUEST_EMAIL_FRIEND_REQUEST_EMAIL_IDREQUESTUSER_IDREQUESTEDUSER_UINDEX = createIndex("friend_request_email_idRequestUser_idRequestedUser_uindex", FriendRequestEmail.FRIEND_REQUEST_EMAIL, new OrderField[] { FriendRequestEmail.FRIEND_REQUEST_EMAIL.IDREQUESTUSER, FriendRequestEmail.FRIEND_REQUEST_EMAIL.EMAIL }, true);
        public static Index FRIEND_REQUEST_EMAIL_PRIMARY = createIndex("PRIMARY", FriendRequestEmail.FRIEND_REQUEST_EMAIL, new OrderField[] { FriendRequestEmail.FRIEND_REQUEST_EMAIL.ID }, true);
        public static Index MOTD_PRIMARY = createIndex("PRIMARY", Motd.MOTD, new OrderField[] { Motd.MOTD.ID }, true);
        public static Index PROJECT_PRIMARY = createIndex("PRIMARY", Project.PROJECT, new OrderField[] { Project.PROJECT.ID }, true);
        public static Index PROJECT_SHARING_PRIMARY = createIndex("PRIMARY", ProjectSharing.PROJECT_SHARING, new OrderField[] { ProjectSharing.PROJECT_SHARING.ID }, true);
        public static Index PROJECT_SHARING_PROJECT_SHARING_ID_PROJECT_SHAREKEY_UINDEX = createIndex("project_sharing_id_project_sharekey_uindex", ProjectSharing.PROJECT_SHARING, new OrderField[] { ProjectSharing.PROJECT_SHARING.ID_PROJECT, ProjectSharing.PROJECT_SHARING.SHAREKEY }, true);
        public static Index PROJECT_SHARING_PROJECT_SHARING_SHAREKEY_INDEX = createIndex("project_sharing_sharekey_index", ProjectSharing.PROJECT_SHARING, new OrderField[] { ProjectSharing.PROJECT_SHARING.SHAREKEY }, false);
        public static Index SEC_ROLE_NAME_UNIQUE = createIndex("name_UNIQUE", SecRole.SEC_ROLE, new OrderField[] { SecRole.SEC_ROLE.NAME }, true);
        public static Index SEC_ROLE_PRIMARY = createIndex("PRIMARY", SecRole.SEC_ROLE, new OrderField[] { SecRole.SEC_ROLE.ID }, true);
        public static Index SEC_USER_ROLE_FK_USER_ROLE_ROLE_IDX = createIndex("FK_USER_ROLE_ROLE_idx", SecUserRole.SEC_USER_ROLE, new OrderField[] { SecUserRole.SEC_USER_ROLE.ID_ROLE }, false);
        public static Index SEC_USER_ROLE_UNIQUE_USER_ROLE = createIndex("UNIQUE_user_role", SecUserRole.SEC_USER_ROLE, new OrderField[] { SecUserRole.SEC_USER_ROLE.ID_USER, SecUserRole.SEC_USER_ROLE.ID_ROLE }, true);
        public static Index SESSION_PRIMARY = createIndex("PRIMARY", Session.SESSION, new OrderField[] { Session.SESSION.IDSESSION }, true);
        public static Index TAG_NAME_UNIQUE = createIndex("name_UNIQUE", Tag.TAG, new OrderField[] { Tag.TAG.NAME }, true);
        public static Index TAG_PRIMARY = createIndex("PRIMARY", Tag.TAG, new OrderField[] { Tag.TAG.ID }, true);
        public static Index USER_PRIMARY = createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.ID }, true);
    }
}
