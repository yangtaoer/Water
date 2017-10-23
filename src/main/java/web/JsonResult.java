package web;

public class JsonResult {
	private static final int SUCCESS=1;
	private static final int ERROR=0;
	/**״̬*/
	private int state;
	/**��Ӧ��״̬��Ϣ��Ϣ*/
	private String message;
	private Object data;
	/**���ڷ���ֵΪnull�����*/
	public JsonResult(){
		this.state=SUCCESS;
		this.message="OK";
	}
	public JsonResult(Object data){
		this();
		this.data=data;
	}
	/**���ڷ�װ�쳣*/
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
