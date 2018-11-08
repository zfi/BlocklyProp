/*
 * This file is generated by jOOQ.
*/
package com.parallax.server.blocklyprop.db.generated.tables.records;


import com.parallax.server.blocklyprop.db.generated.tables.ProjectTag;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


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
public class ProjectTagRecord extends TableRecordImpl<ProjectTagRecord> implements Record2<Long, Long> {

    private static final long serialVersionUID = -742443456;

    /**
     * Setter for <code>blocklyprop.project_tag.id_project</code>.
     */
    public void setIdProject(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>blocklyprop.project_tag.id_project</code>.
     */
    public Long getIdProject() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>blocklyprop.project_tag.id_tag</code>.
     */
    public void setIdTag(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>blocklyprop.project_tag.id_tag</code>.
     */
    public Long getIdTag() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ProjectTag.PROJECT_TAG.ID_PROJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ProjectTag.PROJECT_TAG.ID_TAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getIdProject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getIdTag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getIdProject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getIdTag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectTagRecord value1(Long value) {
        setIdProject(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectTagRecord value2(Long value) {
        setIdTag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectTagRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProjectTagRecord
     */
    public ProjectTagRecord() {
        super(ProjectTag.PROJECT_TAG);
    }

    /**
     * Create a detached, initialised ProjectTagRecord
     */
    public ProjectTagRecord(Long idProject, Long idTag) {
        super(ProjectTag.PROJECT_TAG);

        set(0, idProject);
        set(1, idTag);
    }
}
