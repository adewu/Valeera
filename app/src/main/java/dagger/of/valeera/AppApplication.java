package dagger.of.valeera;

import android.app.Application;

/**
 * Created by wuxm on 09/05/2017.
 * Email 380510218@qq.com
 */

public class AppApplication  extends Application {

    private static AppApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        this.sInstance = this;
        setupCompoent();
    }

    private void setupCompoent(){
        appComponent = DaggerAppComponent.builder()
                .githubApiModule(new GithubApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public static AppApplication getsInstance(){
        return sInstance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}