package dagger.of.valeera;

import android.app.Application;



import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by wuxm on 09/05/2017.
 * Email 380510218@qq.com
 */
@Module
public class GithubApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {

        OkHttpClient okHttpClient;

        okHttpClient = new OkHttpClient.Builder()

                //失败重连
                .retryOnConnectionFailure(true)
                //auth
                //time out
                .readTimeout(60 * 1000, TimeUnit.SECONDS)
                .connectTimeout(60 * 1000, TimeUnit.SECONDS)

                .build();


        return okHttpClient;
    }

    @Provides
    public Retrofit provideRetrofit(Application application, OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(application.getString(R.string.api_github))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    protected GithubApiService provideGitHubService(Retrofit retrofit) {

        return retrofit.create(GithubApiService.class);
    }
}
