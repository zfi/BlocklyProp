/**
 * This class is generated by jOOQ
 */
package com.parallax.server.blocklyprop.db.generated;


import com.parallax.server.blocklyprop.db.generated.tables.Project;
import com.parallax.server.blocklyprop.db.generated.tables.ProjectTag;
import com.parallax.server.blocklyprop.db.generated.tables.SecPermission;
import com.parallax.server.blocklyprop.db.generated.tables.SecRole;
import com.parallax.server.blocklyprop.db.generated.tables.SecRolePermission;
import com.parallax.server.blocklyprop.db.generated.tables.SecUserRole;
import com.parallax.server.blocklyprop.db.generated.tables.Tag;
import com.parallax.server.blocklyprop.db.generated.tables.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Blocklyprop extends SchemaImpl {

	private static final long serialVersionUID = 215326260;

	/**
	 * The reference instance of <code>blocklyprop</code>
	 */
	public static final Blocklyprop BLOCKLYPROP = new Blocklyprop();

	/**
	 * No further instances allowed
	 */
	private Blocklyprop() {
		super("blocklyprop");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Project.PROJECT,
			ProjectTag.PROJECT_TAG,
			SecPermission.SEC_PERMISSION,
			SecRole.SEC_ROLE,
			SecRolePermission.SEC_ROLE_PERMISSION,
			SecUserRole.SEC_USER_ROLE,
			Tag.TAG,
			User.USER);
	}
}
