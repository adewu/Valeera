package dagger.of.valeera;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wuxm on 09/05/2017.
 * Email 380510218@qq.com
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Provides
    public Application provideApplication(){
        return application;
    }
}
