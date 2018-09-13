/**
 * This class is generated by jOOQ
 */
package com.parallax.server.blocklyprop.db.generated.tables.records;


import com.parallax.server.blocklyprop.db.generated.tables.Motd;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Customer-facing alerts
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MotdRecord extends UpdatableRecordImpl<MotdRecord> implements Record10<Long, String, String, String, Byte, Byte, Timestamp, Timestamp, Timestamp, Timestamp> {

	private static final long serialVersionUID = -1264919800;

	/**
	 * Setter for <code>blocklyprop.motd.id</code>.
	 */
	public void setId(Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.id</code>.
	 */
	public Long getId() {
		return (Long) getValue(0);
	}

	/**
	 * Setter for <code>blocklyprop.motd.message_text</code>.
	 */
	public void setMessageText(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.message_text</code>.
	 */
	public String getMessageText() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>blocklyprop.motd.message_html</code>.
	 */
	public void setMessageHtml(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.message_html</code>.
	 */
	public String getMessageHtml() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>blocklyprop.motd.notes</code>.
	 */
	public void setNotes(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.notes</code>.
	 */
	public String getNotes() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>blocklyprop.motd.enabled</code>.
	 */
	public void setEnabled(Byte value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.enabled</code>.
	 */
	public Byte getEnabled() {
		return (Byte) getValue(4);
	}

	/**
	 * Setter for <code>blocklyprop.motd.is_deleted</code>.
	 */
	public void setIsDeleted(Byte value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.is_deleted</code>.
	 */
	public Byte getIsDeleted() {
		return (Byte) getValue(5);
	}

	/**
	 * Setter for <code>blocklyprop.motd.create_date</code>.
	 */
	public void setCreateDate(Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.create_date</code>.
	 */
	public Timestamp getCreateDate() {
		return (Timestamp) getValue(6);
	}

	/**
	 * Setter for <code>blocklyprop.motd.last_change_date</code>.
	 */
	public void setLastChangeDate(Timestamp value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.last_change_date</code>.
	 */
	public Timestamp getLastChangeDate() {
		return (Timestamp) getValue(7);
	}

	/**
	 * Setter for <code>blocklyprop.motd.message_enable_time</code>.
	 */
	public void setMessageEnableTime(Timestamp value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.message_enable_time</code>.
	 */
	public Timestamp getMessageEnableTime() {
		return (Timestamp) getValue(8);
	}

	/**
	 * Setter for <code>blocklyprop.motd.message_disable_time</code>.
	 */
	public void setMessageDisableTime(Timestamp value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>blocklyprop.motd.message_disable_time</code>.
	 */
	public Timestamp getMessageDisableTime() {
		return (Timestamp) getValue(9);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Long> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record10 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row10<Long, String, String, String, Byte, Byte, Timestamp, Timestamp, Timestamp, Timestamp> fieldsRow() {
		return (Row10) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row10<Long, String, String, String, Byte, Byte, Timestamp, Timestamp, Timestamp, Timestamp> valuesRow() {
		return (Row10) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return Motd.MOTD.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Motd.MOTD.MESSAGE_TEXT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Motd.MOTD.MESSAGE_HTML;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Motd.MOTD.NOTES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Byte> field5() {
		return Motd.MOTD.ENABLED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Byte> field6() {
		return Motd.MOTD.IS_DELETED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field7() {
		return Motd.MOTD.CREATE_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field8() {
		return Motd.MOTD.LAST_CHANGE_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field9() {
		return Motd.MOTD.MESSAGE_ENABLE_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field10() {
		return Motd.MOTD.MESSAGE_DISABLE_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getMessageText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getMessageHtml();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getNotes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte value5() {
		return getEnabled();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte value6() {
		return getIsDeleted();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value7() {
		return getCreateDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value8() {
		return getLastChangeDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value9() {
		return getMessageEnableTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value10() {
		return getMessageDisableTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value2(String value) {
		setMessageText(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value3(String value) {
		setMessageHtml(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value4(String value) {
		setNotes(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value5(Byte value) {
		setEnabled(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value6(Byte value) {
		setIsDeleted(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value7(Timestamp value) {
		setCreateDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value8(Timestamp value) {
		setLastChangeDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value9(Timestamp value) {
		setMessageEnableTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord value10(Timestamp value) {
		setMessageDisableTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MotdRecord values(Long value1, String value2, String value3, String value4, Byte value5, Byte value6, Timestamp value7, Timestamp value8, Timestamp value9, Timestamp value10) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached MotdRecord
	 */
	public MotdRecord() {
		super(Motd.MOTD);
	}

	/**
	 * Create a detached, initialised MotdRecord
	 */
	public MotdRecord(Long id, String messageText, String messageHtml, String notes, Byte enabled, Byte isDeleted, Timestamp createDate, Timestamp lastChangeDate, Timestamp messageEnableTime, Timestamp messageDisableTime) {
		super(Motd.MOTD);

		setValue(0, id);
		setValue(1, messageText);
		setValue(2, messageHtml);
		setValue(3, notes);
		setValue(4, enabled);
		setValue(5, isDeleted);
		setValue(6, createDate);
		setValue(7, lastChangeDate);
		setValue(8, messageEnableTime);
		setValue(9, messageDisableTime);
	}
}