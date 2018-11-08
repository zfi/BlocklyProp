/*
 * This file is generated by jOOQ.
*/
package com.parallax.server.blocklyprop.db.generated.tables.pojos;


import java.io.Serializable;

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
public class User implements Serializable {

    private static final long serialVersionUID = -1557826520;

    private Long   id;
    private Long   idcloudsession;
    private String screenname;

    public User() {}

    public User(User value) {
        this.id = value.id;
        this.idcloudsession = value.idcloudsession;
        this.screenname = value.screenname;
    }

    public User(
        Long   id,
        Long   idcloudsession,
        String screenname
    ) {
        this.id = id;
        this.idcloudsession = idcloudsession;
        this.screenname = screenname;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcloudsession() {
        return this.idcloudsession;
    }

    public void setIdcloudsession(Long idcloudsession) {
        this.idcloudsession = idcloudsession;
    }

    public String getScreenname() {
        return this.screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(id);
        sb.append(", ").append(idcloudsession);
        sb.append(", ").append(screenname);

        sb.append(")");
        return sb.toString();
    }
}
