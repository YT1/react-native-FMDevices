#iOS
1、导入SDK添加动态链接库 libresolv.9.tdb
2、[options setValue:@"allowd" forkey @"allowd"];
SDK具有放调试功能，当使用Xcode调试时添加，上线Appstore时删除此字段
3、[options setValue:@"Sandbox" forkey @"env"];
指定对接的测试环境，正式上线时，删除或注释这个字段，切换为同盾正式环境
4、[options setValue:@"tenyuan" forkey @"partner"];
指定合作方标示
5、import FMDevice from 'react-native-FMDevices';
6、
//进入应用注册
componentWillMount() {
      FMDevice.registerFMDevicesresolve({'allowd':'allowd','env':'sandbox','partner':'tenyuan'});
      }
7、获取唯一标示值
 FMDevice.getFMDevicesresolve();
#Android

1. 添加项目引用，在android/setting.gradle中:


    include ':react-native-FMDevices'
    project(':react-native-FMDevices').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-FMDevices/android')

2.在android/app/build.gradle中：

    dependencies {

    compile fileTree(dir: "libs", include: ["*.jar"])

    compile project(':react-native-FMDevices')//同盾风控SDK集成
    }


3. 添加package:
*  使用startReactApplication




     //MainActivity
    import android.os.Bundle;
    import com.facebook.react.ReactInstanceManager;
    import com.facebook.react.ReactRootView;
    import com.facebook.react.shell.MainReactPackage;

    import com.dowin.fm.FMPackage;//同盾风控SDK集成


    private ReactInstanceManager mReactInstanceManager;
    private ReactRootView mReactRootView;

     @Override
     protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                 .setApplication(getApplication())
                 .setBundleAssetName("index.android.bundle")
                 .setJSMainModuleName("index.android")
                 .addPackage(new MainReactPackage())
                .addPackage(new FMPackage())//同盾风控SDK集成
                 .setUseDeveloperSupport(true)
                 .setInitialLifecycleState(LifecycleState.RESUMED)
                 .build();

        Bundle options = new Bundle();
        //
        mReactRootView.startReactApplication(mReactInstanceManager, getMainComponentName(), options);
     }


*  setReactNativeHost


     import android.os.Bundle;
     import com.facebook.react.ReactInstanceManager;
     import com.facebook.react.ReactRootView;
     import com.facebook.react.shell.MainReactPackage;

     import com.dowin.fm.FMPackage;//同盾风控SDK集成


     import com.facebook.react.ReactNativeHost;
     import com.facebook.react.ReactPackage;
     import java.util.Arrays;
     import java.util.List;

     @Override
     protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         MainApplication application = (MainApplication) getApplication();
                  application.setReactNativeHost(new ReactNativeHost(application) {
                      @Override
                      protected boolean getUseDeveloperSupport() {
                          return false;
                      }
                  
                      @Override
                      protected List<ReactPackage> getPackages() {
                          return Arrays.<ReactPackage>asList(
                                  new MainReactPackage(),
                                  new FMPackage()//同盾风控SDK集成
                          );
                      }
                  });
     }
     //MainApplication
     public void setReactNativeHost(ReactNativeHost mReactNativeHost) {
         this.mReactNativeHost = mReactNativeHost;
     }


4. AndroidManifest.xml


    <meta-data
        android:name="PARTNER_CODE"
        android:value="tenyuan"/>


#使用


	//进入应用注册
    import FMDevice from 'react-native-FMDevices';

    componentDidMount(){
        FMDevice.registerFMDevicesresolve();
    }
    //获取唯一标示值
    FMDevice.getFMDevicesresolve((backbox) => {

    });
    
#