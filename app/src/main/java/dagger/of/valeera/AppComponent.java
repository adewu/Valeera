package dagger.of.valeera;

import dagger.Component;
import dagger.Module;

/**
 * Created by wuxm on 09/05/2017.
 * Email 380510218@qq.com
 */

@Component(modules = {AppModule.class,GithubApiModule.class})
public interface AppComponent {
    void inject(ReposListActivity activity);
}
