/*
 * This file is generated by jOOQ.
*/
package com.parallax.server.blocklyprop.db.generated.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Friend implements Serializable {

    private static final long serialVersionUID = 1556483056;

    private Long      id;
    private Long      idrequestuser;
    private Long      idrequesteduser;
    private Timestamp requested;
    private Timestamp accepted;
    private Integer   requestSentCount;
    private Timestamp requestLastSent;

    public Friend() {}

    public Friend(Friend value) {
        this.id = value.id;
        this.idrequestuser = value.idrequestuser;
        this.idrequesteduser = value.idrequesteduser;
        this.requested = value.requested;
        this.accepted = value.accepted;
        this.requestSentCount = value.requestSentCount;
        this.requestLastSent = value.requestLastSent;
    }

    public Friend(
        Long      id,
        Long      idrequestuser,
        Long      idrequesteduser,
        Timestamp requested,
        Timestamp accepted,
        Integer   requestSentCount,
        Timestamp requestLastSent
    ) {
        this.id = id;
        this.idrequestuser = idrequestuser;
        this.idrequesteduser = idrequesteduser;
        this.requested = requested;
        this.accepted = accepted;
        this.requestSentCount = requestSentCount;
        this.requestLastSent = requestLastSent;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdrequestuser() {
        return this.idrequestuser;
    }

    public void setIdrequestuser(Long idrequestuser) {
        this.idrequestuser = idrequestuser;
    }

    public Long getIdrequesteduser() {
        return this.idrequesteduser;
    }

    public void setIdrequesteduser(Long idrequesteduser) {
        this.idrequesteduser = idrequesteduser;
    }

    public Timestamp getRequested() {
        return this.requested;
    }

    public void setRequested(Timestamp requested) {
        this.requested = requested;
    }

    public Timestamp getAccepted() {
        return this.accepted;
    }

    public void setAccepted(Timestamp accepted) {
        this.accepted = accepted;
    }

    public Integer getRequestSentCount() {
        return this.requestSentCount;
    }

    public void setRequestSentCount(Integer requestSentCount) {
        this.requestSentCount = requestSentCount;
    }

    public Timestamp getRequestLastSent() {
        return this.requestLastSent;
    }

    public void setRequestLastSent(Timestamp requestLastSent) {
        this.requestLastSent = requestLastSent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Friend (");

        sb.append(id);
        sb.append(", ").append(idrequestuser);
        sb.append(", ").append(idrequesteduser);
        sb.append(", ").append(requested);
        sb.append(", ").append(accepted);
        sb.append(", ").append(requestSentCount);
        sb.append(", ").append(requestLastSent);

        sb.append(")");
        return sb.toString();
    }
}
