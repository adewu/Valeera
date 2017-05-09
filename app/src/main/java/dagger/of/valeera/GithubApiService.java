package dagger.of.valeera;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by wuxm on 09/05/2017.
 * Email 380510218@qq.com
 */

public interface GithubApiService {

    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}
