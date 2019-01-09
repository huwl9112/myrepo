package catchGlobalkey;

import com.melloware.jintellitype.JIntellitype;

import java.awt.*;

//创建全局快捷键
public class CatchGlobalKeyDemo {
    Robot robot;

	// 初始化
	public CatchGlobalKeyDemo() {
		init();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CatchGlobalKeyDemo();
			}
		});
	}

	// 初始化
	private void init() {
	    try {
	        robot=new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
		registerKeys();

		// 添加热键监听器
		// 第二步：添加热键监听器
		JIntellitype.getInstance().addHotKeyListener(markCode->{
            System.out.println("按下的键位："+(char)markCode);
            JIntellitype.getInstance().unregisterHotKey(markCode);//取消监听
            robot.keyPress(markCode);//模拟输入
            JIntellitype.getInstance().registerHotKey(markCode,0,markCode);//重新监听
		});
	}

    private void registerKeys() {
        for (int code=48;code<=127;code++){//注册常用键
            JIntellitype.getInstance().registerHotKey(code, 0, code);
            /*JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_3,
                    JIntellitype.MOD_SHIFT + JIntellitype.MOD_CONTROL, code);
            JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_4, JIntellitype.MOD_SHIFT, code);
            JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_2, JIntellitype.MOD_CONTROL, code);*/
        }
        JIntellitype.getInstance().registerHotKey(32, 0, 32);
        JIntellitype.getInstance().registerHotKey(8, 0, 8);
        JIntellitype.getInstance().registerHotKey(13, 0, 13);
    }
}
