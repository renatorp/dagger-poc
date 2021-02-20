import handler.CreatePostHandler;
import handler.EventHandler;

import javax.inject.Inject;
import java.util.Map;

public class ProcessExecutor {

	private static ProcessExecutor instance;
	private final Outputter outputter;

	private Map<String, EventHandler> handlers;

	@Inject
	public ProcessExecutor(Outputter outputter, Map<String,EventHandler> handlers) {
		this.handlers = handlers;
		this.outputter = outputter;
	}

	public void execute(String value) {
		// Problema 1: sempre cria todos os handles msm sem precisar
		outputter.output(handlers.get(value).handle("teste-"+value));
	}

	public static void main(String[] args) {
		getInstance();
//		getInstance().execute("createComment");

		// Problema 2: não cacheia handlers  OK
//		System.out.println(getInstance().execute("createPost"));
	}

	private static ProcessExecutor getInstance() {
		if (instance == null) {
			instance = DaggerProcessExecutorFactory.create().executor();
		}
		return instance;
	}
}
