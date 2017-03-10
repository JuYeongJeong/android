package demo.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxService.class)  //注意：非 XxxUtil.class
public class MockConstructionTest {

	/*
	 * 1.Use the @RunWith(PowerMockRunner.class) annotation at the class-level of the test case.
	 * 2.Use the @PrepareForTest(ClassThatCreatesTheNewInstance.class) annotation at the class-level of the test case.
	 * 3.PowerMockito.whenNew(MockNewClass.class)
	 * 4.Note : withArguments(value), value必须与实际new时的参数类型相同
	 */
	
	@Test
	public void mockConstruction() throws Exception {
		//prepare
		XxxService service = new XxxService();
		XxxUtil util = new XxxUtil();
		String name = "hello";
		util.setName(name);
		PowerMockito.whenNew(XxxUtil.class).withNoArguments().thenReturn(util);
		
		//action
		XxxUtil res = service.getUtil();
		
		//assert
		assertEquals(name, res.getName());
	}
	
}
