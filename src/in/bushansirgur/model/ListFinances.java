package in.bushansirgur.model;

public class ListFinances {
	
	private Integer id;
	
	private String name_finance;
	
	private int user_id;
	
	private float  value;
	
	private String type_value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_finance() {
		return name_finance;
	}

	public void setName_finance(String name_finance) {
		this.name_finance = name_finance;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getType_value() {
		return type_value;
	}

	public void setType_value(String type_value) {
		this.type_value = type_value;
	}

}
