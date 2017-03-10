package demo.powermock;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

// We prepare XxxServiceClass for test because it's final or we need to mock private or static methods
@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxService.class)  // spy是不需要声明 @PrepareForTest，但必须使用 doReturn("foo").when(spy).get(0);
public class MockPartialMethodTest {
	
	private XxxService service = new XxxService();
	
	@Test 
	public void mockPartialPrivateMethod() throws Exception {
		//prepare
		service = PowerMockito.spy(service);
		PowerMockito.doReturn(false).when(service, "isNeedHandle", anyInt()); // mock private method
		
		/*
		* spy must use doReturn()
		*
		List list = new LinkedList();
		List spy = spy(list);
		//Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
		when(spy.get(0)).thenReturn("foo");
		
		//You have to use doReturn() for stubbing
		doReturn("foo").when(spy).get(0);
		*/
		
		//action
		boolean res = service.handle(2);
		
		//assert
		assertFalse(res); 
		PowerMockito.verifyPrivate(service, times(1)).invoke("isNeedHandle", anyInt());
	}

}
