/**
 * This class is generated by jOOQ
 */
package com.parallax.server.blocklyprop.db.generated.tables;


import com.parallax.server.blocklyprop.db.enums.ProjectType;
import com.parallax.server.blocklyprop.db.generated.Blocklyprop;
import com.parallax.server.blocklyprop.db.generated.Keys;
import com.parallax.server.blocklyprop.db.generated.tables.records.ProjectRecord;
import com.parallax.server.blocklyprop.db.utils.CalendarConverter;
import com.parallax.server.blocklyprop.db.utils.ProjectTypeConverter;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Project extends TableImpl<ProjectRecord> {

	private static final long serialVersionUID = 1793047352;

	/**
	 * The reference instance of <code>blocklyprop.project</code>
	 */
	public static final Project PROJECT = new Project();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ProjectRecord> getRecordType() {
		return ProjectRecord.class;
	}

	/**
	 * The column <code>blocklyprop.project.id</code>.
	 */
	public final TableField<ProjectRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>blocklyprop.project.id_user</code>.
	 */
	public final TableField<ProjectRecord, Long> ID_USER = createField("id_user", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>blocklyprop.project.name</code>.
	 */
	public final TableField<ProjectRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>blocklyprop.project.description</code>.
	 */
	public final TableField<ProjectRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>blocklyprop.project.code</code>.
	 */
	public final TableField<ProjectRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>blocklyprop.project.type</code>.
	 */
	public final TableField<ProjectRecord, ProjectType> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "", new ProjectTypeConverter());

	/**
	 * The column <code>blocklyprop.project.private</code>.
	 */
	public final TableField<ProjectRecord, Boolean> PRIVATE = createField("private", org.jooq.impl.SQLDataType.BOOLEAN.defaulted(true), this, "");

	/**
	 * The column <code>blocklyprop.project.shared</code>.
	 */
	public final TableField<ProjectRecord, Boolean> SHARED = createField("shared", org.jooq.impl.SQLDataType.BOOLEAN.defaulted(true), this, "");

	/**
	 * The column <code>blocklyprop.project.created</code>.
	 */
	public final TableField<ProjectRecord, GregorianCalendar> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "", new CalendarConverter());

	/**
	 * The column <code>blocklyprop.project.modified</code>.
	 */
	public final TableField<ProjectRecord, GregorianCalendar> MODIFIED = createField("modified", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "", new CalendarConverter());

	/**
	 * Create a <code>blocklyprop.project</code> table reference
	 */
	public Project() {
		this("project", null);
	}

	/**
	 * Create an aliased <code>blocklyprop.project</code> table reference
	 */
	public Project(String alias) {
		this(alias, PROJECT);
	}

	private Project(String alias, Table<ProjectRecord> aliased) {
		this(alias, aliased, null);
	}

	private Project(String alias, Table<ProjectRecord> aliased, Field<?>[] parameters) {
		super(alias, Blocklyprop.BLOCKLYPROP, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ProjectRecord, Long> getIdentity() {
		return Keys.IDENTITY_PROJECT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ProjectRecord> getPrimaryKey() {
		return Keys.KEY_PROJECT_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ProjectRecord>> getKeys() {
		return Arrays.<UniqueKey<ProjectRecord>>asList(Keys.KEY_PROJECT_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Project as(String alias) {
		return new Project(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Project rename(String name) {
		return new Project(name, null);
	}
}
