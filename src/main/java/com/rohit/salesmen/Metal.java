package com.rohit.salesmen;

/**
 * @author Rohit Raja
 * <p> Holds Metal information.
 *
 */
public class Metal {
	
	private String metalName;
	private Double metalValue;
	public Metal(String metalName, Double metalValue) {
		super();
		this.metalName = metalName;
		this.metalValue = metalValue;
	}
	public String getMetalName() {
		return metalName;
	}
	public Double getMetalValue() {
		return metalValue;
	}
	@Override
	public String toString() {
		return "Metal [metalName=" + metalName + ", metalValue=" + metalValue + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Metal other = (Metal) obj;
		if (metalName == null) {
			if (other.metalName != null)
				return false;
		} else if (!metalName.equals(other.metalName))
			return false;
		if (metalValue == null) {
			if (other.metalValue != null)
				return false;
		} else if (!metalValue.equals(other.metalValue))
			return false;
		return true;
	}
	
	
}
