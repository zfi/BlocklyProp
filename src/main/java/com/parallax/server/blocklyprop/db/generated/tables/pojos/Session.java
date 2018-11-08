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
public class Session implements Serializable {

    private static final long serialVersionUID = 2091558876;

    private String    idsession;
    private Timestamp starttimestamp;
    private Timestamp lastaccesstime;
    private Long      timeout;
    private String    host;
    private byte[]    attributes;

    public Session() {}

    public Session(Session value) {
        this.idsession = value.idsession;
        this.starttimestamp = value.starttimestamp;
        this.lastaccesstime = value.lastaccesstime;
        this.timeout = value.timeout;
        this.host = value.host;
        this.attributes = value.attributes;
    }

    public Session(
        String    idsession,
        Timestamp starttimestamp,
        Timestamp lastaccesstime,
        Long      timeout,
        String    host,
        byte[]    attributes
    ) {
        this.idsession = idsession;
        this.starttimestamp = starttimestamp;
        this.lastaccesstime = lastaccesstime;
        this.timeout = timeout;
        this.host = host;
        this.attributes = attributes;
    }

    public String getIdsession() {
        return this.idsession;
    }

    public void setIdsession(String idsession) {
        this.idsession = idsession;
    }

    public Timestamp getStarttimestamp() {
        return this.starttimestamp;
    }

    public void setStarttimestamp(Timestamp starttimestamp) {
        this.starttimestamp = starttimestamp;
    }

    public Timestamp getLastaccesstime() {
        return this.lastaccesstime;
    }

    public void setLastaccesstime(Timestamp lastaccesstime) {
        this.lastaccesstime = lastaccesstime;
    }

    public Long getTimeout() {
        return this.timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public byte[] getAttributes() {
        return this.attributes;
    }

    public void setAttributes(byte... attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Session (");

        sb.append(idsession);
        sb.append(", ").append(starttimestamp);
        sb.append(", ").append(lastaccesstime);
        sb.append(", ").append(timeout);
        sb.append(", ").append(host);
        sb.append(", ").append("[binary...]");

        sb.append(")");
        return sb.toString();
    }
}
