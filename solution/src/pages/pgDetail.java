package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class pgDetail {

    @FindBy(className = "android.widget.TextView")
    private WebElement textView;
	
    @FindBy(id = "com.ustwo.sample:id/commit_detail_textview_name")
    private WebElement textViewName;

    @FindBy(id = "com.ustwo.sample:id/commit_detail_textview_email")
    private WebElement textViewEmail;

    @FindBy(id = "com.ustwo.sample:id/commit_detail_textview_date")
    private WebElement textViewDate;

    @FindBy(id = "com.ustwo.sample:id/commit_detail_textview_message")
    private WebElement textViewMsg;

    public WebDriver driver;

    public pgDetail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    
    public WebElement getTextView() {
        return textView;
    }
    
    public WebElement getTextViewName() {
        return textViewName;
    }

    public WebElement getTextViewEmail() {
        return textViewEmail;
    }

    public WebElement getTextViewDate() {
        return textViewDate;
    }

    public WebElement getTextViewMsg() {
        return textViewMsg;
    }
}