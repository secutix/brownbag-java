package com.secutix.brownbag.java7.exercises;

import java.util.Date;

/**
 * A class taken from SecuTix for test purpose.
 * <p>
 */
public class MySTObjectOL {
	private Date dteLogI;
	private String usrLogI;

	private Date dteLogLu;
	private String usrLogLu;

	public Date getDateInserted() {
		return dteLogI;
	}

	@SuppressWarnings("unused")
	private void setDateInserted(final Date insertionDate) {
		this.dteLogI = insertionDate;
	}

	public Date getDateLastUpdated() {
		return dteLogLu;
	}

	@SuppressWarnings("unused")
	private void setDateLastUpdated(final Date lastUpdateDate) {
		this.dteLogLu = lastUpdateDate;
	}

	public String getUserInserted() {
		return usrLogI;
	}

	@SuppressWarnings("unused")
	private void setUserInserted(final String insertedByUser) {
		this.usrLogI = insertedByUser;
	}

	public String getUserLastUpdated() {
		return usrLogLu;
	}

	/**
	 * @param lastUpdateByUser
	 *            Is the username to set of the user that has last updated this record.
	 */
	@SuppressWarnings("unused")
	private void setUserLastUpdated(final String lastUpdateByUser) {
		this.usrLogLu = lastUpdateByUser;
	}

}
