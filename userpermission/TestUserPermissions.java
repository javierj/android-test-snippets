
import android.content.pm.PackageManager;
import android.test.AndroidTestCase;

/**
 * Tests that the application has specific user permissions
 * @author Javier J.
 *
 */
public class TestUserPermissions extends AndroidTestCase 
{
	
	String packageName;
	PackageManager pm;
	
	public void setUp() throws Exception {
		super.setUp();
		// name of the package of the main activity
		packageName = "org.iwt2.restrung";
	}

	public void testPermissionsACCESS_NETWORK_STATE_isInManifest() {
		this.pm = this.getContext().getPackageManager();
		int res = this.pm.checkPermission("android.permission.ACCESS_NETWORK_STATE", packageName); 
		assertEquals(res, PackageManager.PERMISSION_GRANTED );
	}
	
	public void testPermissionsINTERNET_isInManifest() {
		this.pm = this.getContext().getPackageManager();
		int res = this.pm.checkPermission("android.permission.INTERNET", packageName); 
		assertEquals(res, PackageManager.PERMISSION_GRANTED );
	}

}
