package railroad19exericse.railroad19exericse;

import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
import com.paulhammant.ngwebdriver.ByAngularExactBinding;

public class FindByNgWebDriverTest {
	
	@ByAngularBinding.FindBy(rootSelector = "butter", binding = "cheese")
    public WebElement findBy_binding;
	
	 @ByAngularButtonText.FindBy(rootSelector = "butter", buttonText = "cheese")
	 public WebElement findBy_buttonText;
	
	 @ByAngularCssContainingText.FindBy(rootSelector = "butter", cssSelector = "cheese", searchText = "crackers")
	 public WebElement findBy_cssContainingText;

	 @ByAngularExactBinding.FindBy(rootSelector = "butter", exactBinding = "cheese")
	 public WebElement findBy_exactBinding;
}
