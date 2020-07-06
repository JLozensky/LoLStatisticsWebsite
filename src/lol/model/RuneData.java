package lol.model;

public class RuneData {

	private int runeId;
	private String name;
	private String pathName;
	private String longDesc;
	
	public RuneData(int runeId, String name, String pathName, String longDesc) {
		this.runeId = runeId;
		this.name = name;
		this.pathName = pathName;
		this.longDesc = longDesc;
	}
	
	public int getRuneId() {
		return runeId;
	}

	public void setRuneId(int runeId) {
		this.runeId = runeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}


	
}
