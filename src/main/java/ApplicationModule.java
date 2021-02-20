import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import handler.CreateCommentHandler;
import handler.CreatePostHandler;
import handler.EventHandler;

@Module
public abstract class ApplicationModule {
	@Binds
	@IntoMap
	@StringKey("createPost")
	abstract EventHandler createPostHandler(CreatePostHandler handler);

	@Binds
	@IntoMap
	@StringKey("createComment")
	abstract EventHandler createCommentHandler(CreateCommentHandler handler);

	@Provides
	static Outputter textOutputter() {
		System.out.println("outputter created");
		return new Outputter() {
			public void output(String value) {
				System.out.println(value);
			}
		};
	}
}
