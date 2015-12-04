package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Wrapper for future legal stakeholder rights information and the agreed attribution statement / notice.
 *
 * @author Simon
 */
public class Copyright {

	private String notice;

	public Copyright(@JsonProperty("notice") String notice) {
		this.notice = notice;
	}

	public String getNotice() {
		return notice;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Copyright that = (Copyright) o;

		return Objects.equal(this.notice, that.notice);	}

	@Override
	public int hashCode() {
		return Objects.hashCode(notice);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static Builder notice(String notice) {
		return (new Builder()).withNotice(notice);
	}

	public static class Builder {

		String notice;

		public Builder withNotice(String notice) {
			this.notice = notice;
			return this;
		}

		public Copyright build() {
			return new Copyright(notice);
		}
	}

}
