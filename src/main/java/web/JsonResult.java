package web;

public class JsonResult {
	private static final int SUCCESS=1;
	private static final int ERROR=0;
	/**状态*/
	private int state;
	/**对应的状态信息信息*/
	private String message;
	private Object data;
	/**用于返回值为null的情况*/
	public JsonResult(){
		this.state=SUCCESS;
		this.message="OK";
	}
	public JsonResult(Object data){
		this();
		this.data=data;
	}
	/**用于封装异常*/
	public JsonResult(Throwable t){
		this.state=ERROR;
		this.message=t.getMessage();
	}

	public int getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	
	

}
