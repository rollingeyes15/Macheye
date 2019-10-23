package com.macheye.vamshi.nashorn.bean;

public class Header {
	
	private String workspace;
	private String uuid;
	private String ts;
	private String originatoryType;
	public String getWorkspace() {
		return workspace;
	}
	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getOriginatoryType() {
		return originatoryType;
	}
	public void setOriginatoryType(String originatoryType) {
		this.originatoryType = originatoryType;
	}
	@Override
	public String toString() {
		return "Header [workspace=" + workspace + ", uuid=" + uuid + ", ts="
				+ ts + ", originatoryType=" + originatoryType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((originatoryType == null) ? 0 : originatoryType.hashCode());
		result = prime * result + ((ts == null) ? 0 : ts.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		result = prime * result
				+ ((workspace == null) ? 0 : workspace.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Header other = (Header) obj;
		if (originatoryType == null) {
			if (other.originatoryType != null)
				return false;
		} else if (!originatoryType.equals(other.originatoryType))
			return false;
		if (ts == null) {
			if (other.ts != null)
				return false;
		} else if (!ts.equals(other.ts))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		if (workspace == null) {
			if (other.workspace != null)
				return false;
		} else if (!workspace.equals(other.workspace))
			return false;
		return true;
	}
}