package restAssured.restAssured;

import org.testng.annotations.DataProvider;

public class testData {

	@DataProvider(name = "DataUsers")
	public Object[][] dataForPost() {

//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "abcd";
//		data[0][1] = "xyzasf";
//		data[0][2] = 1;
//		
//		data[1][0] = "efghi";
//		data[1][1] = "kshjhf";
//		data[1][2] = 2;
//		
//		return data;

		return new Object[][] { { "graham", "Bell", 1 }, { "Henry", "Ford", 2 } };

	}

	@DataProvider(name = "DeleteUser")
	public Object[] deleteuser() {
		return new Object[] { 4, 5 };
	}

}
