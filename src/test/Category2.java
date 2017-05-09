package test;

public class Category2 {
	private String cid;
	private String cname;
	public Category2() {
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Category2 [cid=" + cid + ", cname=" + cname + "]";
	}
}
