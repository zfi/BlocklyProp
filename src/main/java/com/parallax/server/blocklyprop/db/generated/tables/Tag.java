/*
 * This file is generated by jOOQ.
*/
package com.parallax.server.blocklyprop.db.generated.tables;


import com.parallax.server.blocklyprop.db.generated.Blocklyprop;
import com.parallax.server.blocklyprop.db.generated.Indexes;
import com.parallax.server.blocklyprop.db.generated.Keys;
import com.parallax.server.blocklyprop.db.generated.tables.records.TagRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Tag extends TableImpl<TagRecord> {

    private static final long serialVersionUID = 1300586962;

    /**
     * The reference instance of <code>blocklyprop.tag</code>
     */
    public static final Tag TAG = new Tag();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TagRecord> getRecordType() {
        return TagRecord.class;
    }

    /**
     * The column <code>blocklyprop.tag.id</code>.
     */
    public final TableField<TagRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>blocklyprop.tag.name</code>.
     */
    public final TableField<TagRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>blocklyprop.tag</code> table reference
     */
    public Tag() {
        this(DSL.name("tag"), null);
    }

    /**
     * Create an aliased <code>blocklyprop.tag</code> table reference
     */
    public Tag(String alias) {
        this(DSL.name(alias), TAG);
    }

    /**
     * Create an aliased <code>blocklyprop.tag</code> table reference
     */
    public Tag(Name alias) {
        this(alias, TAG);
    }

    private Tag(Name alias, Table<TagRecord> aliased) {
        this(alias, aliased, null);
    }

    private Tag(Name alias, Table<TagRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Blocklyprop.BLOCKLYPROP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TAG_NAME_UNIQUE, Indexes.TAG_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TagRecord, Long> getIdentity() {
        return Keys.IDENTITY_TAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TagRecord> getPrimaryKey() {
        return Keys.KEY_TAG_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TagRecord>> getKeys() {
        return Arrays.<UniqueKey<TagRecord>>asList(Keys.KEY_TAG_PRIMARY, Keys.KEY_TAG_NAME_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tag as(String alias) {
        return new Tag(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tag as(Name alias) {
        return new Tag(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Tag rename(String name) {
        return new Tag(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Tag rename(Name name) {
        return new Tag(name, null);
    }
}
