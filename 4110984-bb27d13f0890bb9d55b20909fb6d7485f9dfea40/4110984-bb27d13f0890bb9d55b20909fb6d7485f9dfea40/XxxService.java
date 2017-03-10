package demo.powermock;


public class XxxService {
	
	/* 
	 * 1.修改私有域
	 * 	- unit test 必须保证 '快'，需要修改private field
	 */
	private static int threshold = 1000000;
	public int sum() {
		int i=0;
		while(i < threshold) {
			i=i+1;
		}
		return i;
	}
	
	/*
	 * 2.测试私有方法
	 */
	private boolean isPositiveNumber(int i) {
		if(i > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * 3.无返回值，校验：对某方法调用次数
	 */
	public void foreach(int count) {
		for(int i=0; i<count; i++) {
			isPositiveNumber(i);
		}
	}
	
	/*
	 * 3.mock静态方法
	 */
	public boolean isAllowBuy(int i) {
		//判断是否安全
		if(XxxUtil.isSafe(i)) {
			//判断是否超过支付能力
			// ....
		}
		return false;
	}
	
	/*
	 * 4.mock partial method
	 *  - 需要mock isNeedHandle()，否则导致单元测试粒度太大
	 */
	public boolean handle(int i) {
		if(isNeedHandle(i)) {
			// ... logic handle
			return true;
		}
		return false;
	}
	private boolean isNeedHandle(int i) {
		//假设此方法逻辑，依赖外部服务、且逻辑较复杂
		return true;
	}
	
	
	/*
	 * 5.mock construction
	 */
	public XxxUtil getUtil() {
		XxxUtil util = new XxxUtil();
		return util;
	}

}
