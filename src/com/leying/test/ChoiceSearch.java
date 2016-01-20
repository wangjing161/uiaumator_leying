package com.leying.test;

import java.io.IOException;
import android.os.RemoteException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.*;
import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

public class ChoiceSearch extends UiAutomatorTestCase{
	/*
	 * 乐影--精选--搜索
	 */

	public void test_keyword_search_case() throws UiObjectNotFoundException, RemoteException{
		/*
		 * 输入关键字搜索,搜索结果页视频/电影切换,清空历史搜索记录
		 */
		
		//连接设备
		UiDevice device = getUiDevice(); 
		// 点击home键
        device.pressHome();  
        //打开应用
        UiSelector selectorleying = new UiSelector().description("乐影");  
        UiObject leyingapp = new UiObject(selectorleying);
        leyingapp.click();
        sleep(100);
        //点击文本输入框
        UiObject text = new UiObject(new UiSelector().resourceId("com" +
        		".duohappy.leying:id/search_hot"));
        text.clickAndWaitForNewWindow();
        sleep(100);
        
        //在文本输入框内输入关键字   
        UiObject edit = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/search_hot"));
        edit.setText(Utf7ImeHelper.e("xiaoshidai"));
        
        //点击键盘搜索键
        UiObject click = new UiObject(new UiSelector().className("android.widget.LinearLayout"));
        click.clickBottomRight();
        sleep(100);
        
        //搜索结果页视频or电影切换    
        UiObject change_video = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/video_layout"));
        change_video.clickAndWaitForNewWindow();
        sleep(100);
        UiObject change_movie = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/movie_layout"));
        change_movie.clickAndWaitForNewWindow();
        
        // 点击播放视频and返回
        change_video.clickAndWaitForNewWindow();
        sleep(50);
        UiObject video_broad = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/video_name"));
        video_broad.clickAndWaitForNewWindow();
        sleep(50);
        // 点击视频返回按钮，返回到搜索页
        UiObject video_back = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/mediacontroller_top_back"));
        video_back.clickAndWaitForNewWindow();
        sleep(50);
        
        // 点击播放电影and返回
        change_movie.clickAndWaitForNewWindow();
        sleep(50);
        UiObject movie_now = new UiObject(new UiSelector().className("android.widget.LinearLayout"));
        movie_now.clickAndWaitForNewWindow();
        //点击电影返回按钮，返回到搜索页
        UiObject movie_back = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/mediacontroller_top_back"));
        movie_back.clickAndWaitForNewWindow();
        
        //点击 [搜索结果页视频or电影切换]的取消按钮
        UiObject cancel_btn = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/cancel_btn"));
        cancel_btn.clickAndWaitForNewWindow();
        sleep(50);
        //点击精选首页文本框
        text.clickAndWaitForNewWindow();
        //清空历史
        UiObject clear = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/clear_btn"));
        clear.clickAndWaitForNewWindow();
        sleep(50);
        cancel_btn.clickAndWaitForNewWindow(); 
	}
	
	public static void main(String[] args){
		
		String jarName = "leyingtest";
		String testClass = "com.leying.test.ChoiceSearch";
		String testName = "test_keyword_search_case";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
		
	}

}
