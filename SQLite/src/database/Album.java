package testsnippets.database;

public class Album {
	String name;
	String icon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Album [name=" + name + ", icon=" + icon + "]";
	}
	
}
