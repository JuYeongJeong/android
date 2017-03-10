package demo.powermock;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxUtil.class)  // 注意：非 Thread.class 
public class MockJavaCoreLibraryTest {

	@Test
	public void mockJavaCoreLibrary() throws Exception {
		//prepare
		PowerMockito.mockStatic(Thread.class);
		
		//action
		XxxUtil.sleep(1000);
		
		//assert
		PowerMockito.verifyStatic(times(1));
		Thread.sleep(anyLong());
	}
	
	/**
	 * 关键点：withArguments(value), value必须与实际new时的参数相同
	 * @throws Exception
	 */
	@Test
	public void readFile$mockNewFile() throws Exception {
		//preapare
		File file = mock(File.class);
		PowerMockito.whenNew(File.class).withArguments(anyString()).thenReturn(file);
		
		//action
		XxxUtil.readFile(anyString());
		
		//assert
		verify(file, times(1)).getAbsolutePath();
	}
	
}
