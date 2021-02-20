import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ProcessExecutorFactory {
	ProcessExecutor executor();
}
