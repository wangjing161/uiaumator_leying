package com.leying.test;

import java.io.IOException;
import android.os.RemoteException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.*;

public class SnsHome extends UiAutomatorTestCase {
	/*
	 * 乐影--乐影单
	 */
	
	public static void main(String[] args){
		String jarName = "leyingtest";
		String testClass = "com.leying.test.SnsHome";
		String testName = "test_c_sns_edit";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
		
	}
	
	public void test_a_sns_fresh_change_case() throws UiObjectNotFoundException, RemoteException{
		/*
		 * 乐影单下拉刷新，上下滑动查看
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
		
        System.out.println("***********+++++执行case a +++++***********");
        
        //点击，进入乐影单页面     
        UiObject sns = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/sns_layout"));
        sns.clickAndWaitForNewWindow(); 
        
		// 首页下拉刷新
        UiScrollable sns_home = new UiScrollable(new UiSelector().scrollable(true));
        sns_home.scrollBackward(20);
        sleep(100);
        
        // 首页上下滑动，查看
        sns_home.scrollForward();
        sns_home.scrollBackward();
        
        // 推荐，最热，最新页面切换
        UiObject change_recommend = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/tv_recommend"));
        change_recommend.clickAndWaitForNewWindow();
        UiObject change_hot = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/tv_hot"));
        change_hot.clickAndWaitForNewWindow();
        UiObject change_new = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/tv_latest"));
        change_new.clickAndWaitForNewWindow();
        
        // 退出乐影app
        device.pressBack();
        device.pressBack();
	}
	
	public void test_b_sns_create_case() throws UiObjectNotFoundException, RemoteException{
		/*
		 * 创建乐影单,添加视频,播放视频,删除视频
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
		
        System.out.println("***********+++++执行case b +++++***********");		
        
        // 登陆后创建乐影单，进入我的标签页
        UiObject mine_tab = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/mine_layout"));
        mine_tab.clickAndWaitForNewWindow();
        // 点击登录
        UiObject login = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/layout_mine"));
        login.clickAndWaitForNewWindow();
        // 第三方登录暂时选择qq登录
        UiObject qq_login = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/ll_login_qq"));
        qq_login.clickAndWaitForNewWindow();
        sleep(50);
        UiObject qq_login_button = new UiObject(new UiSelector().text("登录"));
        qq_login_button.clickAndWaitForNewWindow();
        sleep(100);
        // 选择"我的"我的乐影单，创建乐影单
        UiObject my_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/layout_leyingdan"));
        my_sns.clickAndWaitForNewWindow();
        sleep(50);
        UiObject create_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/tv_addlyd"));
        create_sns.clickAndWaitForNewWindow();
        sleep(50);
        UiObject edit_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/et_lyd_title"));
        edit_sns.setText("wangjing");
        sleep(100);
        UiObject finish_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/right_btn"));
        finish_sns.clickAndWaitForNewWindow();
        // 返回到标签页，进入精选标签页进行---乐影单添加视频操作
        UiObject edit_back_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/iv_goback"));
        edit_back_sns.clickAndWaitForNewWindow();
        UiObject choice_tab = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/home_layout"));
        choice_tab.clickAndWaitForNewWindow();
        //选择精选标签页的视频下方的详情按钮
        UiObject detail_choice = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/video_detail_btn"));
        detail_choice.clickAndWaitForNewWindow();
        sleep(50);
        // 选择"+乐影单"按钮，点击
        UiObject button_add_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/video_detail_join_menu"));
        button_add_sns.clickAndWaitForNewWindow();
        sleep(50);
        // 在弹出的框中选择刚刚建立的乐影单
        UiObject add_video = new UiObject(new UiSelector().className("android.widget.TextView").text("wangjing"));
        add_video.clickAndWaitForNewWindow();
        sleep(100);
        device.pressBack();
        // 进入我的tab页
        mine_tab.clickAndWaitForNewWindow();
        // 点击我的乐影单
        my_sns.clickAndWaitForNewWindow();
        // 点击之前创建的"wangjing"的乐影单
        UiObject sns_ready = new UiObject(new UiSelector().className("android.widget.TextView").text("wangjing"));
        sns_ready.clickAndWaitForNewWindow();
        sleep(50);
        
        // 点击刚刚添加的视频---进行视频播放操作
        UiObject sns_video_delete = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/owner_video_layout"));
        sns_video_delete.clickAndWaitForNewWindow();
        sleep(100);
        device.pressBack();
        
        // 长按刚刚添加的视频---进行删除视频操作
        sns_video_delete.longClick();
        UiObject sns_video_delete_button = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/cb_ok").text("确定"));
        sns_video_delete_button.clickAndWaitForNewWindow();
        
        // 删除视频后，点击乐影单左上方返回---按钮
        UiObject back_sns = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/left_iv"));
        back_sns.clickAndWaitForNewWindow();
        
        // 点击我的乐影单主页的---编辑按钮，点击
        UiObject edit_mine_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/cb_lyd_edit"));
        edit_mine_sns.clickAndWaitForNewWindow();
        sleep(50);
        // 选择刚刚建立的"wangjing"乐影单，选择，点击
        UiObject choice_mine_sns = new UiObject(new UiSelector().className("android." +
        		"widget.TextView").text("wangjing"));
        choice_mine_sns.click();
        // 选择时候进行删除操作
        UiObject delete_mine_sns = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/tv_alldel"));
        delete_mine_sns.clickAndWaitForNewWindow();
        sleep(100);
        // 删除之后，回到"我的"标签页
        device.pressBack();
        
        // 点击 "设置"按钮
        UiObject set_tab = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/layout_settings"));
        set_tab.clickAndWaitForNewWindow();
        
        // 点击退出登录按钮
        UiObject logout = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/btn_logout"));
        logout.clickAndWaitForNewWindow();
        // 点击弹框中的"确定"按钮
        UiObject logout_button = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/cb_ok").text("确定"));
        logout_button.clickAndWaitForNewWindow();
     
        
        // 退出乐影app
        device.pressBack();
        device.pressBack();
        
	}
	
	public void test_c_sns_edit() throws UiObjectNotFoundException, RemoteException{
		/*
		 * 
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
		
        System.out.println("***********+++++执行case c +++++***********");
        
        // 先选择qq登录方式，进行登录
        UiObject mine_tab = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/mine_layout"));
        mine_tab.clickAndWaitForNewWindow();
        // 点击登录
        UiObject login = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/layout_mine"));
        login.clickAndWaitForNewWindow();
        // 第三方登录暂时选择qq登录
        UiObject qq_login = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/ll_login_qq"));
        qq_login.clickAndWaitForNewWindow();
        sleep(50);
        UiObject qq_login_button = new UiObject(new UiSelector().text("登录"));
        qq_login_button.clickAndWaitForNewWindow();
        sleep(100);
        
        // 登陆之后，选择乐影单tab页
        UiObject sns_tab = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/sns_layout"));
        sns_tab.clickAndWaitForNewWindow();
        
        // 选择"推荐"中的一个乐影单
        UiObject sns_recommend = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(1));
        sns_recommend.clickAndWaitForNewWindow();
        
        // 点击"收藏" 按钮,进行收藏
        UiObject collect_sns = new UiObject(new UiSelector().resourceId("com.duohappy.leying:id/collect_btn"));
        collect_sns.clickAndWaitForNewWindow();
        
        // 返回
        device.pressBack();
        
        // 选择"我的"我的乐影单
        UiObject my_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/layout_leyingdan"));
        my_sns.clickAndWaitForNewWindow();
        sleep(50);
        
        // 创建乐影单
        UiObject create_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/tv_addlyd"));
        create_sns.clickAndWaitForNewWindow();
        sleep(50);
        
        // "新建乐影单"---"填写乐影单的名称"
        UiObject edit_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/et_lyd_title"));
        edit_sns.setText("wangjing");
        sleep(100);
        
        // 编辑之后，点击"完成"
        UiObject finish_sns = new UiObject(new UiSelector().resourceId("com.duohappy." +
        		"leying:id/right_btn"));
        finish_sns.clickAndWaitForNewWindow();
        
        // 点击刚刚建立的"wangjing"乐影单
        UiObject fin_sns = new UiObject(new UiSelector().resourceId("com." +
        		"duohappy.leying:id/tv_title").text("wangjing"));
        fin_sns.clickAndWaitForNewWindow();
        // 点击"编辑"按钮
        UiObject edit_mine_sns = new UiObject(new UiSelector().resourceId("com." +
        		"duohappy.leying:id/collect_btn").text("编辑"));
        edit_mine_sns.clickAndWaitForNewWindow();
        
        // 修改乐影单名称
        
        
        
        
        
        
        
        
        
        // 退出乐影app
        device.pressBack();
        device.pressBack();
	}

}
